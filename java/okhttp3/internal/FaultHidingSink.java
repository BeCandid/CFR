/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 */
package okhttp3.internal;

import java.io.IOException;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

class FaultHidingSink
extends ForwardingSink {
    private boolean hasErrors;

    public FaultHidingSink(Sink sink) {
        super(sink);
    }

    @Override
    public void close() throws IOException {
        if (this.hasErrors) {
            return;
        }
        try {
            super.close();
            return;
        }
        catch (IOException var1_1) {
            this.hasErrors = true;
            this.onException(var1_1);
            return;
        }
    }

    @Override
    public void flush() throws IOException {
        if (this.hasErrors) {
            return;
        }
        try {
            super.flush();
            return;
        }
        catch (IOException var1_1) {
            this.hasErrors = true;
            this.onException(var1_1);
            return;
        }
    }

    protected void onException(IOException iOException) {
    }

    @Override
    public void write(Buffer buffer, long l2) throws IOException {
        if (this.hasErrors) {
            buffer.skip(l2);
            return;
        }
        try {
            super.write(buffer, l2);
            return;
        }
        catch (IOException var4_3) {
            this.hasErrors = true;
            this.onException(var4_3);
            return;
        }
    }
}

