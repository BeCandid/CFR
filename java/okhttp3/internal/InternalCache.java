/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 */
package okhttp3.internal;

import java.io.IOException;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http.CacheRequest;
import okhttp3.internal.http.CacheStrategy;

public interface InternalCache {
    public Response get(Request var1) throws IOException;

    public CacheRequest put(Response var1) throws IOException;

    public void remove(Request var1) throws IOException;

    public void trackConditionalCacheHit();

    public void trackResponse(CacheStrategy var1);

    public void update(Response var1, Response var2) throws IOException;
}

