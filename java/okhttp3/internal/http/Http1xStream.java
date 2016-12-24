/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.EOFException
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.ProtocolException
 *  java.net.Proxy
 *  java.net.Proxy$Type
 *  java.util.concurrent.TimeUnit
 */
package okhttp3.internal.http;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpEngine;
import okhttp3.internal.http.HttpStream;
import okhttp3.internal.http.OkHeaders;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.RetryableSink;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.http.StreamAllocation;
import okhttp3.internal.io.RealConnection;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class Http1xStream
implements HttpStream {
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    private HttpEngine httpEngine;
    private final BufferedSink sink;
    private final BufferedSource source;
    private int state = 0;
    private final StreamAllocation streamAllocation;

    public Http1xStream(StreamAllocation streamAllocation, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.streamAllocation = streamAllocation;
        this.source = bufferedSource;
        this.sink = bufferedSink;
    }

    private void detachTimeout(ForwardingTimeout forwardingTimeout) {
        Timeout timeout = forwardingTimeout.delegate();
        forwardingTimeout.setDelegate(Timeout.NONE);
        timeout.clearDeadline();
        timeout.clearTimeout();
    }

    private Source getTransferStream(Response response) throws IOException {
        if (!HttpEngine.hasBody(response)) {
            return this.newFixedLengthSource(0);
        }
        if ("chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) {
            return this.newChunkedSource(this.httpEngine);
        }
        long l2 = OkHeaders.contentLength(response);
        if (l2 != -1) {
            return this.newFixedLengthSource(l2);
        }
        return this.newUnknownLengthSource();
    }

    @Override
    public void cancel() {
        RealConnection realConnection = this.streamAllocation.connection();
        if (realConnection != null) {
            realConnection.cancel();
        }
    }

    @Override
    public Sink createRequestBody(Request request, long l2) throws IOException {
        if ("chunked".equalsIgnoreCase(request.header("Transfer-Encoding"))) {
            return this.newChunkedSink();
        }
        if (l2 != -1) {
            return this.newFixedLengthSink(l2);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override
    public void finishRequest() throws IOException {
        this.sink.flush();
    }

    public boolean isClosed() {
        if (this.state == 6) {
            return true;
        }
        return false;
    }

    public Sink newChunkedSink() {
        if (this.state != 1) {
            throw new IllegalStateException("state: " + this.state);
        }
        this.state = 2;
        return new ChunkedSink(this, null);
    }

    public Source newChunkedSource(HttpEngine httpEngine) throws IOException {
        if (this.state != 4) {
            throw new IllegalStateException("state: " + this.state);
        }
        this.state = 5;
        return (Http1xStream)this.new ChunkedSource(httpEngine);
    }

    public Sink newFixedLengthSink(long l2) {
        if (this.state != 1) {
            throw new IllegalStateException("state: " + this.state);
        }
        this.state = 2;
        return new FixedLengthSink((Http1xStream)this, l2, null);
    }

    public Source newFixedLengthSource(long l2) throws IOException {
        if (this.state != 4) {
            throw new IllegalStateException("state: " + this.state);
        }
        this.state = 5;
        return (Http1xStream)this.new FixedLengthSource(l2);
    }

    public Source newUnknownLengthSource() throws IOException {
        if (this.state != 4) {
            throw new IllegalStateException("state: " + this.state);
        }
        if (this.streamAllocation == null) {
            throw new IllegalStateException("streamAllocation == null");
        }
        this.state = 5;
        this.streamAllocation.noNewStreams();
        return new UnknownLengthSource(this, null);
    }

    @Override
    public ResponseBody openResponseBody(Response response) throws IOException {
        Source source = super.getTransferStream(response);
        return new RealResponseBody(response.headers(), Okio.buffer(source));
    }

    public Headers readHeaders() throws IOException {
        String string2;
        Headers.Builder builder = new Headers.Builder();
        while ((string2 = this.source.readUtf8LineStrict()).length() != 0) {
            Internal.instance.addLenient(builder, string2);
        }
        return builder.build();
    }

    public Response.Builder readResponse() throws IOException {
        if (this.state != 1 && this.state != 3) {
            throw new IllegalStateException("state: " + this.state);
        }
        try {
            Response.Builder builder;
            do {
                StatusLine statusLine = StatusLine.parse(this.source.readUtf8LineStrict());
                builder = new Response.Builder().protocol(statusLine.protocol).code(statusLine.code).message(statusLine.message).headers(this.readHeaders());
            } while (statusLine.code == 100);
            this.state = 4;
            return builder;
        }
        catch (EOFException var1_3) {
            IOException iOException = new IOException("unexpected end of stream on " + this.streamAllocation);
            iOException.initCause((Throwable)var1_3);
            throw iOException;
        }
    }

    @Override
    public Response.Builder readResponseHeaders() throws IOException {
        return this.readResponse();
    }

    @Override
    public void setHttpEngine(HttpEngine httpEngine) {
        this.httpEngine = httpEngine;
    }

    public void writeRequest(Headers headers, String string2) throws IOException {
        if (this.state != 0) {
            throw new IllegalStateException("state: " + this.state);
        }
        this.sink.writeUtf8(string2).writeUtf8("\r\n");
        int n2 = headers.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.sink.writeUtf8(headers.name(i2)).writeUtf8(": ").writeUtf8(headers.value(i2)).writeUtf8("\r\n");
        }
        this.sink.writeUtf8("\r\n");
        this.state = 1;
    }

    @Override
    public void writeRequestBody(RetryableSink retryableSink) throws IOException {
        if (this.state != 1) {
            throw new IllegalStateException("state: " + this.state);
        }
        this.state = 3;
        retryableSink.writeToSocket(this.sink);
    }

    @Override
    public void writeRequestHeaders(Request request) throws IOException {
        this.httpEngine.writingRequestHeaders();
        String string2 = RequestLine.get(request, this.httpEngine.getConnection().route().proxy().type());
        this.writeRequest(request.headers(), string2);
    }

    abstract class AbstractSource
    implements Source {
        protected boolean closed;
        final /* synthetic */ Http1xStream this$0;
        protected final ForwardingTimeout timeout;

        private AbstractSource(Http1xStream http1xStream) {
            this.this$0 = http1xStream;
            this.timeout = new ForwardingTimeout(this.this$0.source.timeout());
        }

        /* synthetic */ AbstractSource(Http1xStream http1xStream,  var2_2) {
            super(http1xStream);
        }

        /*
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        protected final void endOfInput(boolean bl2) throws IOException {
            if (this.this$0.state == 6) {
                return;
            }
            if (this.this$0.state != 5) {
                throw new IllegalStateException("state: " + this.this$0.state);
            }
            this.this$0.detachTimeout(this.timeout);
            this.this$0.state = 6;
            if (this.this$0.streamAllocation == null) return;
            StreamAllocation streamAllocation = this.this$0.streamAllocation;
            boolean bl3 = !bl2;
            streamAllocation.streamFinished(bl3, this.this$0);
        }

        @Override
        public Timeout timeout() {
            return this.timeout;
        }
    }

    final class ChunkedSink
    implements Sink {
        private boolean closed;
        final /* synthetic */ Http1xStream this$0;
        private final ForwardingTimeout timeout;

        private ChunkedSink(Http1xStream http1xStream) {
            this.this$0 = http1xStream;
            this.timeout = new ForwardingTimeout(this.this$0.sink.timeout());
        }

        /* synthetic */ ChunkedSink(Http1xStream http1xStream,  var2_2) {
            super(http1xStream);
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void close() throws IOException {
            ChunkedSink chunkedSink = this;
            synchronized (chunkedSink) {
                boolean bl2 = this.closed;
                if (!bl2) {
                    this.closed = true;
                    this.this$0.sink.writeUtf8("0\r\n\r\n");
                    this.this$0.detachTimeout(this.timeout);
                    this.this$0.state = 3;
                }
                return;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void flush() throws IOException {
            ChunkedSink chunkedSink = this;
            synchronized (chunkedSink) {
                boolean bl2 = this.closed;
                if (!bl2) {
                    this.this$0.sink.flush();
                }
                return;
            }
        }

        @Override
        public Timeout timeout() {
            return this.timeout;
        }

        @Override
        public void write(Buffer buffer, long l2) throws IOException {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            if (l2 == 0) {
                return;
            }
            this.this$0.sink.writeHexadecimalUnsignedLong(l2);
            this.this$0.sink.writeUtf8("\r\n");
            this.this$0.sink.write(buffer, l2);
            this.this$0.sink.writeUtf8("\r\n");
        }
    }

    class ChunkedSource
    extends AbstractSource {
        private static final long NO_CHUNK_YET = -1;
        private long bytesRemainingInChunk;
        private boolean hasMoreChunks;
        private final HttpEngine httpEngine;

        ChunkedSource(HttpEngine httpEngine) throws IOException {
            super(Http1xStream.this, null);
            this.bytesRemainingInChunk = -1;
            this.hasMoreChunks = true;
            this.httpEngine = httpEngine;
        }

        private void readChunkSize() throws IOException {
            if (this.bytesRemainingInChunk != -1) {
                Http1xStream.this.source.readUtf8LineStrict();
            }
            try {
                this.bytesRemainingInChunk = Http1xStream.this.source.readHexadecimalUnsignedLong();
                String string2 = Http1xStream.this.source.readUtf8LineStrict().trim();
                if (this.bytesRemainingInChunk < 0 || !string2.isEmpty() && !string2.startsWith(";")) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + string2 + "\"");
                }
            }
            catch (NumberFormatException var1_2) {
                throw new ProtocolException(var1_2.getMessage());
            }
            if (this.bytesRemainingInChunk == 0) {
                this.hasMoreChunks = false;
                this.httpEngine.receiveHeaders(Http1xStream.this.readHeaders());
                this.endOfInput(true);
            }
        }

        @Override
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            if (this.hasMoreChunks && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                this.endOfInput(false);
            }
            this.closed = true;
        }

        @Override
        public long read(Buffer buffer, long l2) throws IOException {
            long l3;
            if (l2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + l2);
            }
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            if (!this.hasMoreChunks) {
                return -1;
            }
            if (this.bytesRemainingInChunk == 0 || this.bytesRemainingInChunk == -1) {
                super.readChunkSize();
                if (!this.hasMoreChunks) {
                    return -1;
                }
            }
            if ((l3 = Http1xStream.this.source.read(buffer, Math.min((long)l2, (long)this.bytesRemainingInChunk))) == -1) {
                this.endOfInput(false);
                throw new ProtocolException("unexpected end of stream");
            }
            this.bytesRemainingInChunk -= l3;
            return l3;
        }
    }

    final class FixedLengthSink
    implements Sink {
        private long bytesRemaining;
        private boolean closed;
        final /* synthetic */ Http1xStream this$0;
        private final ForwardingTimeout timeout;

        private FixedLengthSink(Http1xStream http1xStream, long l2) {
            this.this$0 = http1xStream;
            this.timeout = new ForwardingTimeout(this.this$0.sink.timeout());
            this.bytesRemaining = l2;
        }

        /* synthetic */ FixedLengthSink(Http1xStream http1xStream, long l2,  var4) {
            super(http1xStream, l2);
        }

        @Override
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            if (this.bytesRemaining > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            this.this$0.detachTimeout(this.timeout);
            this.this$0.state = 3;
        }

        @Override
        public void flush() throws IOException {
            if (this.closed) {
                return;
            }
            this.this$0.sink.flush();
        }

        @Override
        public Timeout timeout() {
            return this.timeout;
        }

        @Override
        public void write(Buffer buffer, long l2) throws IOException {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            Util.checkOffsetAndCount(buffer.size(), 0, l2);
            if (l2 > this.bytesRemaining) {
                throw new ProtocolException("expected " + this.bytesRemaining + " bytes but received " + l2);
            }
            this.this$0.sink.write(buffer, l2);
            this.bytesRemaining -= l2;
        }
    }

    class FixedLengthSource
    extends AbstractSource {
        private long bytesRemaining;

        public FixedLengthSource(long l2) throws IOException {
            super(Http1xStream.this, null);
            this.bytesRemaining = l2;
            if (this.bytesRemaining == 0) {
                this.endOfInput(true);
            }
        }

        @Override
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            if (this.bytesRemaining != 0 && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                this.endOfInput(false);
            }
            this.closed = true;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public long read(Buffer buffer, long l2) throws IOException {
            if (l2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + l2);
            }
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            if (this.bytesRemaining == 0) {
                return -1;
            }
            long l3 = Http1xStream.this.source.read(buffer, Math.min((long)this.bytesRemaining, (long)l2));
            if (l3 == -1) {
                this.endOfInput(false);
                throw new ProtocolException("unexpected end of stream");
            }
            this.bytesRemaining -= l3;
            if (this.bytesRemaining != 0) return l3;
            this.endOfInput(true);
            return l3;
        }
    }

    class UnknownLengthSource
    extends AbstractSource {
        private boolean inputExhausted;
        final /* synthetic */ Http1xStream this$0;

        private UnknownLengthSource(Http1xStream http1xStream) {
            this.this$0 = http1xStream;
            super(http1xStream, null);
        }

        /* synthetic */ UnknownLengthSource(Http1xStream http1xStream,  var2_2) {
            super(http1xStream);
        }

        @Override
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            if (!this.inputExhausted) {
                this.endOfInput(false);
            }
            this.closed = true;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public long read(Buffer buffer, long l2) throws IOException {
            if (l2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + l2);
            }
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            if (this.inputExhausted) {
                return -1;
            }
            long l3 = this.this$0.source.read(buffer, l2);
            if (l3 != -1) return l3;
            this.inputExhausted = true;
            this.endOfInput(true);
            return -1;
        }
    }

}

