/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package okhttp3.internal.http;

import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okhttp3.internal.http.OkHeaders;
import okio.BufferedSource;

public final class RealResponseBody
extends ResponseBody {
    private final Headers headers;
    private final BufferedSource source;

    public RealResponseBody(Headers headers, BufferedSource bufferedSource) {
        this.headers = headers;
        this.source = bufferedSource;
    }

    @Override
    public long contentLength() {
        return OkHeaders.contentLength(this.headers);
    }

    @Override
    public MediaType contentType() {
        String string2 = this.headers.get("Content-Type");
        if (string2 != null) {
            return MediaType.parse(string2);
        }
        return null;
    }

    @Override
    public BufferedSource source() {
        return this.source;
    }
}

