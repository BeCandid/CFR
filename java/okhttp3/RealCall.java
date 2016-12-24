/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.IllegalStateException
 *  java.lang.Long
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.ProtocolException
 *  java.util.List
 *  java.util.logging.Level
 *  java.util.logging.Logger
 */
package okhttp3;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Connection;
import okhttp3.Dispatcher;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.Internal;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.http.HttpEngine;
import okhttp3.internal.http.RequestException;
import okhttp3.internal.http.RetryableSink;
import okhttp3.internal.http.RouteException;
import okhttp3.internal.http.StreamAllocation;
import okio.Sink;

final class RealCall
implements Call {
    volatile boolean canceled;
    private final OkHttpClient client;
    HttpEngine engine;
    private boolean executed;
    Request originalRequest;

    protected RealCall(OkHttpClient okHttpClient, Request request) {
        this.client = okHttpClient;
        this.originalRequest = request;
    }

    private Response getResponseWithInterceptorChain(boolean bl2) throws IOException {
        return (RealCall)this.new ApplicationInterceptorChain(0, this.originalRequest, bl2).proceed(this.originalRequest);
    }

    /*
     * Enabled aggressive block sorting
     */
    private String toLoggableString() {
        String string2 = this.canceled ? "canceled call" : "call";
        HttpUrl httpUrl = this.originalRequest.url().resolve("/...");
        return string2 + " to " + httpUrl;
    }

    @Override
    public void cancel() {
        this.canceled = true;
        if (this.engine != null) {
            this.engine.cancel();
        }
    }

    @Override
    public void enqueue(Callback callback) {
        this.enqueue(callback, false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void enqueue(Callback callback, boolean bl2) {
        void var4_3 = this;
        synchronized (var4_3) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        this.client.dispatcher().enqueue(new AsyncCall((RealCall)this, callback, bl2, null));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public Response execute() throws IOException {
        RealCall realCall = this;
        synchronized (realCall) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        try {
            this.client.dispatcher().executed(this);
            Response response = this.getResponseWithInterceptorChain(false);
            if (response != null) return response;
            {
                throw new IOException("Canceled");
            }
        }
        finally {
            this.client.dispatcher().finished(this);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    Response getResponse(Request var1, boolean var2_2) throws IOException {
        var3_3 = var1.body();
        if (var3_3 != null) {
            var15_4 = var1.newBuilder();
            var16_5 = var3_3.contentType();
            if (var16_5 != null) {
                var15_4.header("Content-Type", var16_5.toString());
            }
            if ((var17_6 = var3_3.contentLength()) != -1) {
                var15_4.header("Content-Length", Long.toString((long)var17_6));
                var15_4.removeHeader("Transfer-Encoding");
            } else {
                var15_4.header("Transfer-Encoding", "chunked");
                var15_4.removeHeader("Content-Length");
            }
            var1 = var15_4.build();
        }
        this.engine = new HttpEngine(this.client, var1, false, false, var2_2, null, null, null);
        var4_7 = 0;
        do lbl-1000: // 6 sources:
        {
            if (this.canceled) {
                this.engine.releaseStreamAllocation();
                throw new IOException("Canceled");
            }
            var5_9 = true;
            try {
                this.engine.sendRequest();
                this.engine.readResponse();
                var12_12 = this.engine.getResponse();
            }
            catch (RequestException var11_16) {
                throw var11_16.getCause();
            }
            catch (RouteException var9_11) {
                var10_14 = this.engine.recover(var9_11.getLastConnectException(), null);
                if (var10_14 == null) throw var9_11.getLastConnectException();
                var5_9 = false;
                this.engine = var10_14;
            }
            catch (IOException var6_10) {
                var7_15 = this.engine.recover(var6_10, null);
                if (var7_15 == null) throw var6_10;
                var5_9 = false;
                this.engine = var7_15;
            }
            finally {
                if (!var5_9) ** GOTO lbl-1000
                this.engine.close().release();
            }
            var13_8 = this.engine.followUpRequest();
            if (var13_8 == null) {
                if (var2_2 != false) return var12_12;
                this.engine.releaseStreamAllocation();
                return var12_12;
            }
            ** GOTO lbl49
            continue;
lbl49: // 1 sources:
            var14_13 = this.engine.close();
            if (++var4_7 > 20) {
                var14_13.release();
                throw new ProtocolException("Too many follow-up requests: " + var4_7);
            }
            if (!this.engine.sameConnection(var13_8.url())) {
                var14_13.release();
                var14_13 = null;
            }
            this.engine = new HttpEngine(this.client, var13_8, false, false, var2_2, var14_13, null, var12_12);
        } while (true);
    }

    @Override
    public boolean isCanceled() {
        return this.canceled;
    }

    @Override
    public boolean isExecuted() {
        RealCall realCall = this;
        synchronized (realCall) {
            boolean bl2 = this.executed;
            return bl2;
        }
    }

    @Override
    public Request request() {
        return this.originalRequest;
    }

    Object tag() {
        return this.originalRequest.tag();
    }

    class ApplicationInterceptorChain
    implements Interceptor.Chain {
        private final boolean forWebSocket;
        private final int index;
        private final Request request;

        ApplicationInterceptorChain(int n2, Request request, boolean bl2) {
            this.index = n2;
            this.request = request;
            this.forWebSocket = bl2;
        }

        @Override
        public Connection connection() {
            return null;
        }

        @Override
        public Response proceed(Request request) throws IOException {
            Response response;
            if (this.index < RealCall.this.client.interceptors().size()) {
                ApplicationInterceptorChain applicationInterceptorChain = new ApplicationInterceptorChain(1 + this.index, request, this.forWebSocket);
                Interceptor interceptor = (Interceptor)RealCall.this.client.interceptors().get(this.index);
                response = interceptor.intercept(applicationInterceptorChain);
                if (response == null) {
                    throw new NullPointerException("application interceptor " + interceptor + " returned null");
                }
            } else {
                response = RealCall.this.getResponse(request, this.forWebSocket);
            }
            return response;
        }

        @Override
        public Request request() {
            return this.request;
        }
    }

    final class AsyncCall
    extends NamedRunnable {
        private final boolean forWebSocket;
        private final Callback responseCallback;
        final /* synthetic */ RealCall this$0;

        private AsyncCall(RealCall realCall, Callback callback, boolean bl2) {
            this.this$0 = realCall;
            Object[] arrobject = new Object[]{realCall.originalRequest.url().toString()};
            super("OkHttp %s", arrobject);
            this.responseCallback = callback;
            this.forWebSocket = bl2;
        }

        /* synthetic */ AsyncCall(RealCall realCall, Callback callback, boolean bl2,  var4) {
            super(realCall, callback, bl2);
        }

        void cancel() {
            this.this$0.cancel();
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        protected void execute() {
            boolean bl2 = false;
            try {
                Response response = this.this$0.getResponseWithInterceptorChain(this.forWebSocket);
                if (this.this$0.canceled) {
                    bl2 = true;
                    this.responseCallback.onFailure(this.this$0, new IOException("Canceled"));
                    do {
                        return;
                        break;
                    } while (true);
                }
                bl2 = true;
                this.responseCallback.onResponse(this.this$0, response);
                return;
            }
            catch (IOException var3_3) {
                if (bl2) {
                    Internal.logger.log(Level.INFO, "Callback failure for " + this.this$0.toLoggableString(), (Throwable)var3_3);
                    do {
                        return;
                        break;
                    } while (true);
                }
                this.responseCallback.onFailure(this.this$0, var3_3);
                return;
            }
            finally {
                this.this$0.client.dispatcher().finished(this);
            }
        }

        RealCall get() {
            return this.this$0;
        }

        String host() {
            return this.this$0.originalRequest.url().host();
        }

        Request request() {
            return this.this$0.originalRequest;
        }

        Object tag() {
            return this.this$0.originalRequest.tag();
        }
    }

}

