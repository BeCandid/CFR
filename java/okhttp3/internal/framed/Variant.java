/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package okhttp3.internal.framed;

import okhttp3.Protocol;
import okhttp3.internal.framed.FrameReader;
import okhttp3.internal.framed.FrameWriter;
import okio.BufferedSink;
import okio.BufferedSource;

public interface Variant {
    public Protocol getProtocol();

    public FrameReader newReader(BufferedSource var1, boolean var2);

    public FrameWriter newWriter(BufferedSink var1, boolean var2);
}

