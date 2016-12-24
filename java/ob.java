/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.os.ParcelFileDescriptor
 *  java.io.File
 *  java.io.InputStream
 *  java.lang.Object
 */
import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.InputStream;

public class ob
implements py<mm, Bitmap> {
    private final oa a;
    private final kp<File, Bitmap> b;
    private final kq<Bitmap> c;
    private final mn d;

    public ob(py<InputStream, Bitmap> py2, py<ParcelFileDescriptor, Bitmap> py3) {
        this.c = py2.d();
        this.d = new mn(py2.c(), py3.c());
        this.b = py2.a();
        this.a = new oa(py2.b(), py3.b());
    }

    @Override
    public kp<File, Bitmap> a() {
        return this.b;
    }

    @Override
    public kp<mm, Bitmap> b() {
        return this.a;
    }

    @Override
    public km<mm> c() {
        return this.d;
    }

    @Override
    public kq<Bitmap> d() {
        return this.c;
    }
}

