/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  io.fabric.sdk.android.services.common.CommonUtils
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import io.fabric.sdk.android.services.common.CommonUtils;

public class anx {
    public final String a;
    public final int b;
    public final int c;
    public final int d;

    public anx(String string2, int n2, int n3, int n4) {
        this.a = string2;
        this.b = n2;
        this.c = n3;
        this.d = n4;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static anx a(Context context, String string2) {
        anx anx2 = null;
        if (string2 == null) return anx2;
        try {
            int n2 = CommonUtils.l((Context)context);
            akx.h().a("Fabric", "App icon resource ID is " + n2);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource((Resources)context.getResources(), (int)n2, (BitmapFactory.Options)options);
            anx anx3 = new anx(string2, n2, options.outWidth, options.outHeight);
            return anx3;
        }
        catch (Exception exception) {
            akx.h().e("Fabric", "Failed to load icon", (Throwable)exception);
            return null;
        }
    }
}

