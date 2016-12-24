/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.res.Resources;
import android.graphics.Bitmap;

public class pe
implements pf<Bitmap, ny> {
    private final Resources a;
    private final ln b;

    public pe(Resources resources, ln ln2) {
        this.a = resources;
        this.b = ln2;
    }

    @Override
    public String a() {
        return "GlideBitmapDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
    }

    @Override
    public lj<ny> a(lj<Bitmap> lj2) {
        return new nz(new ny(this.a, lj2.b()), this.b);
    }
}

