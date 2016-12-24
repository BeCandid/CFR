/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  java.io.File
 *  java.io.InputStream
 *  java.lang.Object
 */
import android.graphics.Bitmap;
import java.io.File;
import java.io.InputStream;

public class pc
implements py<mm, ow> {
    private final kp<File, ow> a;
    private final kp<mm, ow> b;
    private final kq<ow> c;
    private final km<mm> d;

    public pc(py<mm, Bitmap> py2, py<InputStream, on> py3, ln ln2) {
        oy oy2 = new oy(py2.b(), py3.b(), ln2);
        this.a = new ok<ow>(new pa(oy2));
        this.b = oy2;
        this.c = new oz(py2.d(), py3.d());
        this.d = py2.c();
    }

    @Override
    public kp<File, ow> a() {
        return this.a;
    }

    @Override
    public kp<mm, ow> b() {
        return this.b;
    }

    @Override
    public km<mm> c() {
        return this.d;
    }

    @Override
    public kq<ow> d() {
        return this.c;
    }
}

