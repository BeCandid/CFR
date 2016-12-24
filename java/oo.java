/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.File
 *  java.io.InputStream
 *  java.lang.Object
 */
import android.content.Context;
import java.io.File;
import java.io.InputStream;

public class oo
implements py<InputStream, on> {
    private final ou a;
    private final ov b;
    private final mu c;
    private final ok<on> d;

    public oo(Context context, ln ln2) {
        this.a = new ou(context, ln2);
        this.d = new ok(this.a);
        this.b = new ov(ln2);
        this.c = new mu();
    }

    @Override
    public kp<File, on> a() {
        return this.d;
    }

    @Override
    public kp<InputStream, on> b() {
        return this.a;
    }

    @Override
    public km<InputStream> c() {
        return this.c;
    }

    @Override
    public kq<on> d() {
        return this.b;
    }
}

