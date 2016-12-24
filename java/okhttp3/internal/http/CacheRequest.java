/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 */
package okhttp3.internal.http;

import java.io.IOException;
import okio.Sink;

public interface CacheRequest {
    public void abort();

    public Sink body() throws IOException;
}

