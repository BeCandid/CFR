/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  java.lang.Math
 *  java.lang.Object
 */
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class jq {
    /*
     * Enabled aggressive block sorting
     */
    public static Bitmap a(Bitmap bitmap, int n2) {
        if (bitmap == null) {
            return null;
        }
        int n3 = Math.max((int)bitmap.getWidth(), (int)bitmap.getHeight());
        Bitmap bitmap2 = Bitmap.createBitmap((int)n3, (int)n3, (Bitmap.Config)bitmap.getConfig());
        Canvas canvas = new Canvas(bitmap2);
        canvas.drawColor(n2);
        int n4 = bitmap.getHeight() > bitmap.getWidth() ? 0 : (bitmap.getWidth() - bitmap.getHeight()) / 2;
        int n5 = bitmap.getWidth() > bitmap.getHeight() ? 0 : (bitmap.getHeight() - bitmap.getWidth()) / 2;
        canvas.drawBitmap(bitmap, (float)n5, (float)n4, null);
        return bitmap2;
    }
}

