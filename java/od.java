/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  com.bumptech.glide.load.DecodeFormat
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 */
import android.graphics.Bitmap;
import com.bumptech.glide.load.DecodeFormat;
import java.io.IOException;
import java.io.InputStream;

public class od
implements kp<InputStream, Bitmap> {
    private final nu a;
    private ln b;
    private DecodeFormat c;
    private String d;

    public od(ln ln2, DecodeFormat decodeFormat) {
        super(nu.a, ln2, decodeFormat);
    }

    public od(nu nu2, ln ln2, DecodeFormat decodeFormat) {
        this.a = nu2;
        this.b = ln2;
        this.c = decodeFormat;
    }

    @Override
    public String a() {
        if (this.d == null) {
            this.d = "StreamBitmapDecoder.com.bumptech.glide.load.resource.bitmap" + this.a.a() + this.c.name();
        }
        return this.d;
    }

    @Override
    public lj<Bitmap> a(InputStream inputStream, int n2, int n3) {
        return nr.a(this.a.a(inputStream, this.b, n2, n3, this.c), this.b);
    }
}

