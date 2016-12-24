/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.util.Log
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.lang.String
 */
import android.graphics.Bitmap;
import android.util.Log;
import java.io.OutputStream;

public class nq
implements kq<Bitmap> {
    private Bitmap.CompressFormat a;
    private int b;

    public nq() {
        this(null, 90);
    }

    public nq(Bitmap.CompressFormat compressFormat, int n2) {
        this.a = compressFormat;
        this.b = n2;
    }

    private Bitmap.CompressFormat a(Bitmap bitmap) {
        if (this.a != null) {
            return this.a;
        }
        if (bitmap.hasAlpha()) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    @Override
    public String a() {
        return "BitmapEncoder.com.bumptech.glide.load.resource.bitmap";
    }

    @Override
    public boolean a(lj<Bitmap> lj2, OutputStream outputStream) {
        Bitmap bitmap = lj2.b();
        long l2 = re.a();
        Bitmap.CompressFormat compressFormat = super.a(bitmap);
        bitmap.compress(compressFormat, this.b, outputStream);
        if (Log.isLoggable((String)"BitmapEncoder", (int)2)) {
            Log.v((String)"BitmapEncoder", (String)("Compressed with type: " + (Object)compressFormat + " of size " + ri.a(bitmap) + " in " + re.a(l2)));
        }
        return true;
    }
}

