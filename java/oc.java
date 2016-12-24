/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  com.bumptech.glide.load.DecodeFormat
 *  java.io.File
 *  java.io.InputStream
 *  java.lang.Object
 */
import android.graphics.Bitmap;
import com.bumptech.glide.load.DecodeFormat;
import java.io.File;
import java.io.InputStream;

public class oc
implements py<InputStream, Bitmap> {
    private final od a;
    private final nq b;
    private final mu c = new mu();
    private final ok<Bitmap> d;

    public oc(ln ln2, DecodeFormat decodeFormat) {
        this.a = new od(ln2, decodeFormat);
        this.b = new nq();
        this.d = new ok(this.a);
    }

    @Override
    public kp<File, Bitmap> a() {
        return this.d;
    }

    @Override
    public kp<InputStream, Bitmap> b() {
        return this.a;
    }

    @Override
    public km<InputStream> c() {
        return this.c;
    }

    @Override
    public kq<Bitmap> d() {
        return this.b;
    }
}

