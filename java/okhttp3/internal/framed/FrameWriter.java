/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.IOException
 *  java.lang.Object
 *  java.util.List
 */
package okhttp3.internal.framed;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import okhttp3.internal.framed.ErrorCode;
import okhttp3.internal.framed.Header;
import okhttp3.internal.framed.Settings;
import okio.Buffer;

public interface FrameWriter
extends Closeable {
    public void ackSettings(Settings var1) throws IOException;

    public void connectionPreface() throws IOException;

    public void data(boolean var1, int var2, Buffer var3, int var4) throws IOException;

    public void flush() throws IOException;

    public void goAway(int var1, ErrorCode var2, byte[] var3) throws IOException;

    public void headers(int var1, List<Header> var2) throws IOException;

    public int maxDataLength();

    public void ping(boolean var1, int var2, int var3) throws IOException;

    public void pushPromise(int var1, int var2, List<Header> var3) throws IOException;

    public void rstStream(int var1, ErrorCode var2) throws IOException;

    public void settings(Settings var1) throws IOException;

    public void synReply(boolean var1, int var2, List<Header> var3) throws IOException;

    public void synStream(boolean var1, boolean var2, int var3, int var4, List<Header> var5) throws IOException;

    public void windowUpdate(int var1, long var2) throws IOException;
}

