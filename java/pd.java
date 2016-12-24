/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  java.lang.Object
 *  java.lang.String
 */
import android.graphics.Bitmap;

public class pd
implements pf<ow, oh> {
    private final pf<Bitmap, ny> a;

    public pd(pf<Bitmap, ny> pf2) {
        this.a = pf2;
    }

    @Override
    public String a() {
        return "GifBitmapWrapperDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
    }

    @Override
    public lj<oh> a(lj<ow> lj2) {
        ow ow2 = lj2.b();
        lj<Bitmap> lj3 = ow2.b();
        if (lj3 != null) {
            return this.a.a(lj3);
        }
        return ow2.c();
    }
}

