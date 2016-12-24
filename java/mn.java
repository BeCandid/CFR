/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.ParcelFileDescriptor
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.ParcelFileDescriptor;
import java.io.InputStream;
import java.io.OutputStream;

public class mn
implements km<mm> {
    private final km<InputStream> a;
    private final km<ParcelFileDescriptor> b;
    private String c;

    public mn(km<InputStream> km2, km<ParcelFileDescriptor> km3) {
        this.a = km2;
        this.b = km3;
    }

    @Override
    public String a() {
        if (this.c == null) {
            this.c = this.a.a() + this.b.a();
        }
        return this.c;
    }

    @Override
    public boolean a(mm mm2, OutputStream outputStream) {
        if (mm2.a() != null) {
            return this.a.a(mm2.a(), outputStream);
        }
        return this.b.a(mm2.b(), outputStream);
    }
}

