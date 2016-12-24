/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 */
import android.graphics.Bitmap;
import java.io.IOException;

class ot
implements kp<kd, Bitmap> {
    private final ln a;

    public ot(ln ln2) {
        this.a = ln2;
    }

    @Override
    public String a() {
        return "GifFrameResourceDecoder.com.bumptech.glide.load.resource.gif";
    }

    @Override
    public lj<Bitmap> a(kd kd2, int n2, int n3) {
        return nr.a(kd2.f(), this.a);
    }
}

