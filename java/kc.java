/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.File
 *  java.io.IOException
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.nio.charset.Charset
 */
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

final class kc {
    static final Charset a = Charset.forName((String)"US-ASCII");
    static final Charset b = Charset.forName((String)"UTF-8");

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static void a(Closeable closeable) {
        if (closeable == null) return;
        try {
            closeable.close();
            return;
        }
        catch (RuntimeException var2_1) {
            throw var2_1;
        }
        catch (Exception var1_2) {
            return;
        }
    }

    static void a(File file) throws IOException {
        File[] arrfile = file.listFiles();
        if (arrfile == null) {
            throw new IOException("not a readable directory: " + (Object)file);
        }
        for (File file2 : arrfile) {
            if (file2.isDirectory()) {
                kc.a(file2);
            }
            if (file2.delete()) continue;
            throw new IOException("failed to delete file: " + (Object)file2);
        }
    }
}

