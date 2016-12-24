/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.os.ParcelFileDescriptor
 *  com.bumptech.glide.load.DecodeFormat
 *  java.io.File
 *  java.io.InputStream
 *  java.lang.Object
 */
import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.DecodeFormat;
import java.io.File;
import java.io.InputStream;

public class nv
implements py<ParcelFileDescriptor, Bitmap> {
    private final kp<File, Bitmap> a;
    private final nw b;
    private final nq c;
    private final km<ParcelFileDescriptor> d;

    public nv(ln ln2, DecodeFormat decodeFormat) {
        this.a = new ok<Bitmap>(new od(ln2, decodeFormat));
        this.b = new nw(ln2, decodeFormat);
        this.c = new nq();
        this.d = nl.b();
    }

    @Override
    public kp<File, Bitmap> a() {
        return this.a;
    }

    @Override
    public kp<ParcelFileDescriptor, Bitmap> b() {
        return this.b;
    }

    @Override
    public km<ParcelFileDescriptor> c() {
        return this.d;
    }

    @Override
    public kq<Bitmap> d() {
        return this.c;
    }
}

