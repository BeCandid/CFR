/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  java.lang.String
 */
import android.graphics.Bitmap;

public class nt
extends ns {
    public nt(ln ln2) {
        super(ln2);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    protected Bitmap a(ln ln2, Bitmap bitmap, int n2, int n3) {
        Bitmap.Config config = bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
        Bitmap bitmap2 = ln2.a(n2, n3, config);
        Bitmap bitmap3 = oe.a(bitmap2, bitmap, n2, n3);
        if (bitmap2 != null && bitmap2 != bitmap3 && !ln2.a(bitmap2)) {
            bitmap2.recycle();
        }
        return bitmap3;
    }

    @Override
    public String a() {
        return "CenterCrop.com.bumptech.glide.load.resource.bitmap";
    }
}

