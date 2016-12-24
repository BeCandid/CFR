/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.RectF
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.Log;

public final class oe {
    public static int a(int n2) {
        switch (n2) {
            default: {
                return 0;
            }
            case 5: 
            case 6: {
                return 90;
            }
            case 3: 
            case 4: {
                return 180;
            }
            case 7: 
            case 8: 
        }
        return 270;
    }

    private static Bitmap.Config a(Bitmap bitmap) {
        if (bitmap.getConfig() != null) {
            return bitmap.getConfig();
        }
        return Bitmap.Config.ARGB_8888;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static Bitmap a(Bitmap bitmap, Bitmap bitmap2, int n2, int n3) {
        float f2;
        float f3;
        if (bitmap2 == null) {
            return null;
        }
        if (bitmap2.getWidth() == n2) {
            if (bitmap2.getHeight() == n3) return bitmap2;
        }
        float f4 = 0.0f;
        Matrix matrix = new Matrix();
        if (n3 * bitmap2.getWidth() > n2 * bitmap2.getHeight()) {
            f2 = (float)n3 / (float)bitmap2.getHeight();
            f3 = 0.5f * ((float)n2 - f2 * (float)bitmap2.getWidth());
        } else {
            f2 = (float)n2 / (float)bitmap2.getWidth();
            f4 = 0.5f * ((float)n3 - f2 * (float)bitmap2.getHeight());
            f3 = 0.0f;
        }
        matrix.setScale(f2, f2);
        matrix.postTranslate((float)((int)(f3 + 0.5f)), (float)((int)(f4 + 0.5f)));
        Bitmap bitmap3 = bitmap != null ? bitmap : Bitmap.createBitmap((int)n2, (int)n3, (Bitmap.Config)oe.a(bitmap2));
        oe.a(bitmap2, bitmap3);
        new Canvas(bitmap3).drawBitmap(bitmap2, matrix, new Paint(6));
        return bitmap3;
    }

    public static Bitmap a(Bitmap bitmap, ln ln2, int n2) {
        Matrix matrix = new Matrix();
        oe.a(n2, matrix);
        if (matrix.isIdentity()) {
            return bitmap;
        }
        RectF rectF = new RectF(0.0f, 0.0f, (float)bitmap.getWidth(), (float)bitmap.getHeight());
        matrix.mapRect(rectF);
        int n3 = Math.round((float)rectF.width());
        int n4 = Math.round((float)rectF.height());
        Bitmap.Config config = oe.a(bitmap);
        Bitmap bitmap2 = ln2.a(n3, n4, config);
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap((int)n3, (int)n4, (Bitmap.Config)config);
        }
        matrix.postTranslate(- rectF.left, - rectF.top);
        new Canvas(bitmap2).drawBitmap(bitmap, matrix, new Paint(6));
        return bitmap2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static Bitmap a(Bitmap bitmap, ln ln2, int n2, int n3) {
        if (bitmap.getWidth() == n2 && bitmap.getHeight() == n3) {
            if (!Log.isLoggable((String)"TransformationUtils", (int)2)) return bitmap;
            {
                Log.v((String)"TransformationUtils", (String)"requested target size matches input, returning input");
            }
            return bitmap;
        }
        float f2 = Math.min((float)((float)n2 / (float)bitmap.getWidth()), (float)((float)n3 / (float)bitmap.getHeight()));
        int n4 = (int)(f2 * (float)bitmap.getWidth());
        int n5 = (int)(f2 * (float)bitmap.getHeight());
        if (bitmap.getWidth() == n4 && bitmap.getHeight() == n5) {
            if (!Log.isLoggable((String)"TransformationUtils", (int)2)) return bitmap;
            {
                Log.v((String)"TransformationUtils", (String)"adjusted target size matches input, returning input");
                return bitmap;
            }
        }
        Bitmap.Config config = oe.a(bitmap);
        Bitmap bitmap2 = ln2.a(n4, n5, config);
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap((int)n4, (int)n5, (Bitmap.Config)config);
        }
        oe.a(bitmap, bitmap2);
        if (Log.isLoggable((String)"TransformationUtils", (int)2)) {
            Log.v((String)"TransformationUtils", (String)("request: " + n2 + "x" + n3));
            Log.v((String)"TransformationUtils", (String)("toFit:   " + bitmap.getWidth() + "x" + bitmap.getHeight()));
            Log.v((String)"TransformationUtils", (String)("toReuse: " + bitmap2.getWidth() + "x" + bitmap2.getHeight()));
            Log.v((String)"TransformationUtils", (String)("minPct:   " + f2));
        }
        Canvas canvas = new Canvas(bitmap2);
        Matrix matrix = new Matrix();
        matrix.setScale(f2, f2);
        canvas.drawBitmap(bitmap, matrix, new Paint(6));
        return bitmap2;
    }

    static void a(int n2, Matrix matrix) {
        switch (n2) {
            default: {
                return;
            }
            case 2: {
                matrix.setScale(-1.0f, 1.0f);
                return;
            }
            case 3: {
                matrix.setRotate(180.0f);
                return;
            }
            case 4: {
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            }
            case 5: {
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            }
            case 6: {
                matrix.setRotate(90.0f);
                return;
            }
            case 7: {
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            }
            case 8: 
        }
        matrix.setRotate(-90.0f);
    }

    @TargetApi(value=12)
    public static void a(Bitmap bitmap, Bitmap bitmap2) {
        if (Build.VERSION.SDK_INT >= 12 && bitmap2 != null) {
            bitmap2.setHasAlpha(bitmap.hasAlpha());
        }
    }
}

