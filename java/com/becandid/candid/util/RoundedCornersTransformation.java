/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapShader
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.RectF
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.util.Log
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Math
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.Log;

public class RoundedCornersTransformation
implements kr<Bitmap> {
    private ln a;
    private int b;
    private int c;
    private int d;
    private CornerType e;

    public RoundedCornersTransformation(Context context, int n2, int n3) {
        super(context, n2, n3, CornerType.a);
    }

    public RoundedCornersTransformation(Context context, int n2, int n3, CornerType cornerType) {
        super(jx.a(context).a(), n2, n3, cornerType);
    }

    public RoundedCornersTransformation(ln ln2, int n2, int n3, CornerType cornerType) {
        this.a = ln2;
        this.b = n2;
        this.c = 2 * this.b;
        this.d = n3;
        this.e = cornerType;
    }

    private void a(Canvas canvas, Paint paint, float f2, float f3) {
        Log.d((String)"RCT", (String)("Draw round bitmap with size: " + f2 + "x" + f3));
        float f4 = f2 - (float)this.d;
        float f5 = f3 - (float)this.d;
        switch (.a[this.e.ordinal()]) {
            default: {
                canvas.drawRoundRect(new RectF((float)this.d, (float)this.d, f4, f5), (float)this.b, (float)this.b, paint);
                return;
            }
            case 1: {
                canvas.drawRoundRect(new RectF((float)this.d, (float)this.d, f4, f5), (float)this.b, (float)this.b, paint);
                return;
            }
            case 2: {
                super.b(canvas, paint, f4, f5);
                return;
            }
            case 3: {
                super.c(canvas, paint, f4, f5);
                return;
            }
            case 4: {
                super.d(canvas, paint, f4, f5);
                return;
            }
            case 5: {
                super.e(canvas, paint, f4, f5);
                return;
            }
            case 6: {
                super.f(canvas, paint, f4, f5);
                return;
            }
            case 7: {
                super.g(canvas, paint, f4, f5);
                return;
            }
            case 8: {
                super.h(canvas, paint, f4, f5);
                return;
            }
            case 9: {
                super.i(canvas, paint, f4, f5);
                return;
            }
            case 10: {
                super.j(canvas, paint, f4, f5);
                return;
            }
            case 11: {
                super.k(canvas, paint, f4, f5);
                return;
            }
            case 12: {
                super.l(canvas, paint, f4, f5);
                return;
            }
            case 13: {
                super.m(canvas, paint, f4, f5);
                return;
            }
            case 14: {
                super.n(canvas, paint, f4, f5);
                return;
            }
            case 15: 
        }
        super.o(canvas, paint, f4, f5);
    }

    private void b(Canvas canvas, Paint paint, float f2, float f3) {
        canvas.drawRoundRect(new RectF((float)this.d, (float)this.d, (float)(this.d + this.c), (float)(this.d + this.c)), (float)this.b, (float)this.b, paint);
        canvas.drawRect(new RectF((float)this.d, (float)(this.d + this.b), (float)(this.d + this.b), f3), paint);
        canvas.drawRect(new RectF((float)(this.d + this.b), (float)this.d, f2, f3), paint);
    }

    private void c(Canvas canvas, Paint paint, float f2, float f3) {
        canvas.drawRoundRect(new RectF(f2 - (float)this.c, (float)this.d, f2, (float)(this.d + this.c)), (float)this.b, (float)this.b, paint);
        canvas.drawRect(new RectF((float)this.d, (float)this.d, f2 - (float)this.b, f3), paint);
        canvas.drawRect(new RectF(f2 - (float)this.b, (float)(this.d + this.b), f2, f3), paint);
    }

    private void d(Canvas canvas, Paint paint, float f2, float f3) {
        canvas.drawRoundRect(new RectF((float)this.d, f3 - (float)this.c, (float)(this.d + this.c), f3), (float)this.b, (float)this.b, paint);
        canvas.drawRect(new RectF((float)this.d, (float)this.d, (float)(this.d + this.c), f3 - (float)this.b), paint);
        canvas.drawRect(new RectF((float)(this.d + this.b), (float)this.d, f2, f3), paint);
    }

    private void e(Canvas canvas, Paint paint, float f2, float f3) {
        canvas.drawRoundRect(new RectF(f2 - (float)this.c, f3 - (float)this.c, f2, f3), (float)this.b, (float)this.b, paint);
        canvas.drawRect(new RectF((float)this.d, (float)this.d, f2 - (float)this.b, f3), paint);
        canvas.drawRect(new RectF(f2 - (float)this.b, (float)this.d, f2, f3 - (float)this.b), paint);
    }

    private void f(Canvas canvas, Paint paint, float f2, float f3) {
        canvas.drawRoundRect(new RectF((float)this.d, (float)this.d, f2, (float)(this.d + this.c)), (float)this.b, (float)this.b, paint);
        canvas.drawRect(new RectF((float)this.d, (float)(this.d + this.b), f2, f3), paint);
    }

    private void g(Canvas canvas, Paint paint, float f2, float f3) {
        canvas.drawRoundRect(new RectF((float)this.d, f3 - (float)this.c, f2, f3), (float)this.b, (float)this.b, paint);
        canvas.drawRect(new RectF((float)this.d, (float)this.d, f2, f3 - (float)this.b), paint);
    }

    private void h(Canvas canvas, Paint paint, float f2, float f3) {
        canvas.drawRoundRect(new RectF((float)this.d, (float)this.d, (float)(this.d + this.c), f3), (float)this.b, (float)this.b, paint);
        canvas.drawRect(new RectF((float)(this.d + this.b), (float)this.d, f2, f3), paint);
    }

    private void i(Canvas canvas, Paint paint, float f2, float f3) {
        canvas.drawRoundRect(new RectF(f2 - (float)this.c, (float)this.d, f2, f3), (float)this.b, (float)this.b, paint);
        canvas.drawRect(new RectF((float)this.d, (float)this.d, f2 - (float)this.b, f3), paint);
    }

    private void j(Canvas canvas, Paint paint, float f2, float f3) {
        canvas.drawRoundRect(new RectF((float)this.d, f3 - (float)this.c, f2, f3), (float)this.b, (float)this.b, paint);
        canvas.drawRoundRect(new RectF(f2 - (float)this.c, (float)this.d, f2, f3), (float)this.b, (float)this.b, paint);
        canvas.drawRect(new RectF((float)this.d, (float)this.d, f2 - (float)this.b, f3 - (float)this.b), paint);
    }

    private void k(Canvas canvas, Paint paint, float f2, float f3) {
        canvas.drawRoundRect(new RectF((float)this.d, (float)this.d, (float)(this.d + this.c), f3), (float)this.b, (float)this.b, paint);
        canvas.drawRoundRect(new RectF((float)this.d, f3 - (float)this.c, f2, f3), (float)this.b, (float)this.b, paint);
        canvas.drawRect(new RectF((float)(this.d + this.b), (float)this.d, f2, f3 - (float)this.b), paint);
    }

    private void l(Canvas canvas, Paint paint, float f2, float f3) {
        canvas.drawRoundRect(new RectF((float)this.d, (float)this.d, f2, (float)(this.d + this.c)), (float)this.b, (float)this.b, paint);
        canvas.drawRoundRect(new RectF(f2 - (float)this.c, (float)this.d, f2, f3), (float)this.b, (float)this.b, paint);
        canvas.drawRect(new RectF((float)this.d, (float)(this.d + this.b), f2 - (float)this.b, f3), paint);
    }

    private void m(Canvas canvas, Paint paint, float f2, float f3) {
        canvas.drawRoundRect(new RectF((float)this.d, (float)this.d, f2, (float)(this.d + this.c)), (float)this.b, (float)this.b, paint);
        canvas.drawRoundRect(new RectF((float)this.d, (float)this.d, (float)(this.d + this.c), f3), (float)this.b, (float)this.b, paint);
        canvas.drawRect(new RectF((float)(this.d + this.b), (float)(this.d + this.b), f2, f3), paint);
    }

    private void n(Canvas canvas, Paint paint, float f2, float f3) {
        canvas.drawRoundRect(new RectF((float)this.d, (float)this.d, (float)(this.d + this.c), (float)(this.d + this.c)), (float)this.b, (float)this.b, paint);
        canvas.drawRoundRect(new RectF(f2 - (float)this.c, f3 - (float)this.c, f2, f3), (float)this.b, (float)this.b, paint);
        canvas.drawRect(new RectF((float)this.d, (float)(this.d + this.b), f2 - (float)this.c, f3), paint);
        canvas.drawRect(new RectF((float)(this.d + this.c), (float)this.d, f2, f3 - (float)this.b), paint);
    }

    private void o(Canvas canvas, Paint paint, float f2, float f3) {
        canvas.drawRoundRect(new RectF(f2 - (float)this.c, (float)this.d, f2, (float)(this.d + this.c)), (float)this.b, (float)this.b, paint);
        canvas.drawRoundRect(new RectF((float)this.d, f3 - (float)this.c, (float)(this.d + this.c), f3), (float)this.b, (float)this.b, paint);
        canvas.drawRect(new RectF((float)this.d, (float)this.d, f2 - (float)this.b, f3 - (float)this.b), paint);
        canvas.drawRect(new RectF((float)(this.d + this.b), (float)(this.d + this.b), f2, f3), paint);
    }

    @Override
    public String a() {
        return "RoundedTransformation(radius=" + this.b + ", margin=" + this.d + ", diameter=" + this.c + ", cornerType=" + this.e.name() + ")";
    }

    /*
     * Enabled aggressive block sorting
     */
    public lj<Bitmap> a(Bitmap bitmap, int n2, int n3) {
        int n4 = bitmap.getWidth();
        int n5 = bitmap.getHeight();
        Bitmap bitmap2 = this.a.a(n2, n3, Bitmap.Config.ARGB_8888);
        if (bitmap2 == null && n3 > 0 && n2 > 0) {
            bitmap2 = Bitmap.createBitmap((int)n2, (int)n3, (Bitmap.Config)Bitmap.Config.ARGB_8888);
        } else {
            bitmap2.eraseColor(0);
        }
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Matrix matrix = new Matrix();
        float f2 = (float)n2 / (float)n4;
        float f3 = (float)n3 / (float)n5;
        float f4 = Math.max((float)f2, (float)f3);
        matrix.setScale(f4, f4);
        float f5 = f2 > f3 ? 0.0f : 0.5f * ((float)n2 - f3 * (float)n4);
        matrix.postTranslate(f5, 0.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader((Shader)bitmapShader);
        super.a(canvas, paint, n2, n3);
        return nr.a(bitmap2, this.a);
    }

    @Override
    public lj<Bitmap> a(lj<Bitmap> lj2, int n2, int n3) {
        return this.a(lj2.b(), n2, n3);
    }

    public static final class CornerType
    extends Enum<CornerType> {
        public static final /* enum */ CornerType a = new CornerType();
        public static final /* enum */ CornerType b = new CornerType();
        public static final /* enum */ CornerType c = new CornerType();
        public static final /* enum */ CornerType d = new CornerType();
        public static final /* enum */ CornerType e = new CornerType();
        public static final /* enum */ CornerType f = new CornerType();
        public static final /* enum */ CornerType g = new CornerType();
        public static final /* enum */ CornerType h = new CornerType();
        public static final /* enum */ CornerType i = new CornerType();
        public static final /* enum */ CornerType j = new CornerType();
        public static final /* enum */ CornerType k = new CornerType();
        public static final /* enum */ CornerType l = new CornerType();
        public static final /* enum */ CornerType m = new CornerType();
        public static final /* enum */ CornerType n = new CornerType();
        public static final /* enum */ CornerType o = new CornerType();
        private static final /* synthetic */ CornerType[] p;

        static {
            CornerType[] arrcornerType = new CornerType[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o};
            p = arrcornerType;
        }

        private CornerType() {
            super(string2, n2);
        }

        public static CornerType valueOf(String string2) {
            return (CornerType)Enum.valueOf((Class)CornerType.class, (String)string2);
        }

        public static CornerType[] values() {
            return (CornerType[])p.clone();
        }
    }

}

