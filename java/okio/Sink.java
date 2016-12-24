/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.Flushable
 *  java.io.IOException
 *  java.lang.Object
 */
package okio;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import okio.Buffer;
import okio.Timeout;

public interface Sink
extends Closeable,
Flushable {
    public void close() throws IOException;

    public void flush() throws IOException;

    public Timeout timeout();

    public void write(Buffer var1, long var2) throws IOException;
}

