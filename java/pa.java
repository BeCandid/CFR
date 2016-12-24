/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.ParcelFileDescriptor
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.ParcelFileDescriptor;
import java.io.IOException;
import java.io.InputStream;

public class pa
implements kp<InputStream, ow> {
    private final kp<mm, ow> a;

    public pa(kp<mm, ow> kp2) {
        this.a = kp2;
    }

    @Override
    public String a() {
        return this.a.a();
    }

    @Override
    public lj<ow> a(InputStream inputStream, int n2, int n3) throws IOException {
        return this.a.a(new mm(inputStream, null), n2, n3);
    }
}

