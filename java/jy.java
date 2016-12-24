/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  com.bumptech.glide.load.DecodeFormat
 *  com.bumptech.glide.load.engine.executor.FifoPriorityThreadPoolExecutor
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runtime
 *  java.util.concurrent.ExecutorService
 */
import android.content.Context;
import android.os.Build;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.executor.FifoPriorityThreadPoolExecutor;
import java.util.concurrent.ExecutorService;

public class jy {
    private final Context a;
    private lc b;
    private ln c;
    private mb d;
    private ExecutorService e;
    private ExecutorService f;
    private DecodeFormat g;
    private lu.a h;

    public jy(Context context) {
        this.a = context.getApplicationContext();
    }

    /*
     * Enabled aggressive block sorting
     */
    jx a() {
        if (this.e == null) {
            this.e = new FifoPriorityThreadPoolExecutor(Math.max((int)1, (int)Runtime.getRuntime().availableProcessors()));
        }
        if (this.f == null) {
            this.f = new FifoPriorityThreadPoolExecutor(1);
        }
        mc mc2 = new mc(this.a);
        if (this.c == null) {
            this.c = Build.VERSION.SDK_INT >= 11 ? new lq(mc2.b()) : new lo();
        }
        if (this.d == null) {
            this.d = new ma(mc2.a());
        }
        if (this.h == null) {
            this.h = new lz(this.a);
        }
        if (this.b == null) {
            this.b = new lc(this.d, this.h, this.f, this.e);
        }
        if (this.g == null) {
            this.g = DecodeFormat.d;
        }
        return new jx(this.b, this.d, this.c, this.a, this.g);
    }
}

