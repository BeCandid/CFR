/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class mu
implements km<InputStream> {
    @Override
    public String a() {
        return "";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public boolean a(InputStream inputStream, OutputStream outputStream) {
        byte[] arrby = rb.a().b();
        try {
            try {
                int n2;
                while ((n2 = inputStream.read(arrby)) != -1) {
                    outputStream.write(arrby, 0, n2);
                }
                return true;
            }
            catch (IOException var6_5) {
                if (Log.isLoggable((String)"StreamEncoder", (int)3)) {
                    Log.d((String)"StreamEncoder", (String)"Failed to encode data onto the OutputStream", (Throwable)var6_5);
                }
                rb.a().a(arrby);
                return false;
            }
        }
        finally {
            rb.a().a(arrby);
        }
    }
}

