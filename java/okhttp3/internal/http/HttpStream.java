/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 */
package okhttp3.internal.http;

import java.io.IOException;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpEngine;
import okhttp3.internal.http.RetryableSink;
import okio.Sink;

public interface HttpStream {
    public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

    public void cancel();

    public Sink createRequestBody(Request var1, long var2) throws IOException;

    public void finishRequest() throws IOException;

    public ResponseBody openResponseBody(Response var1) throws IOException;

    public Response.Builder readResponseHeaders() throws IOException;

    public void setHttpEngine(HttpEngine var1);

    public void writeRequestBody(RetryableSink var1) throws IOException;

    public void writeRequestHeaders(Request var1) throws IOException;
}

