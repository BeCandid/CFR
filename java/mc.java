/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.ActivityManager
 *  android.content.Context
 *  android.content.res.Resources
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.format.Formatter
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

public class mc {
    private final int a;
    private final int b;
    private final Context c;

    public mc(Context context) {
        super(context, (ActivityManager)context.getSystemService("activity"), new a(context.getResources().getDisplayMetrics()));
    }

    /*
     * Enabled aggressive block sorting
     */
    mc(Context context, ActivityManager activityManager, b b2) {
        this.c = context;
        int n2 = mc.a(activityManager);
        int n3 = 4 * (b2.a() * b2.b());
        int n4 = n3 * 4;
        int n5 = n3 * 2;
        if (n5 + n4 <= n2) {
            this.b = n5;
            this.a = n4;
        } else {
            int n6 = Math.round((float)((float)n2 / 6.0f));
            this.b = n6 * 2;
            this.a = n6 * 4;
        }
        if (Log.isLoggable((String)"MemorySizeCalculator", (int)3)) {
            StringBuilder stringBuilder = new StringBuilder().append("Calculated memory cache size: ").append(super.a(this.b)).append(" pool size: ").append(super.a(this.a)).append(" memory class limited? ");
            boolean bl2 = n5 + n4 > n2;
            Log.d((String)"MemorySizeCalculator", (String)stringBuilder.append(bl2).append(" max size: ").append(super.a(n2)).append(" memoryClass: ").append(activityManager.getMemoryClass()).append(" isLowMemoryDevice: ").append(mc.b(activityManager)).toString());
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static int a(ActivityManager activityManager) {
        float f2;
        int n2 = 1024 * (1024 * activityManager.getMemoryClass());
        boolean bl2 = mc.b(activityManager);
        float f3 = n2;
        if (bl2) {
            f2 = 0.33f;
            do {
                return Math.round((float)(f2 * f3));
                break;
            } while (true);
        }
        f2 = 0.4f;
        return Math.round((float)(f2 * f3));
    }

    private String a(int n2) {
        return Formatter.formatFileSize((Context)this.c, (long)n2);
    }

    @TargetApi(value=19)
    private static boolean b(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        if (Build.VERSION.SDK_INT < 11) {
            return true;
        }
        return false;
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.a;
    }

    static class a
    implements b {
        private final DisplayMetrics a;

        public a(DisplayMetrics displayMetrics) {
            this.a = displayMetrics;
        }

        @Override
        public int a() {
            return this.a.widthPixels;
        }

        @Override
        public int b() {
            return this.a.heightPixels;
        }
    }

    static interface b {
        public int a();

        public int b();
    }

}

