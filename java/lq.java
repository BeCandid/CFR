/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.annotation.TargetApi
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashSet
 *  java.util.Set
 */
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class lq
implements ln {
    private static final Bitmap.Config a = Bitmap.Config.ARGB_8888;
    private final lr b;
    private final Set<Bitmap.Config> c;
    private final int d;
    private final a e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;

    public lq(int n2) {
        super(n2, lq.e(), lq.f());
    }

    lq(int n2, lr lr2, Set<Bitmap.Config> set) {
        this.d = n2;
        this.f = n2;
        this.b = lr2;
        this.c = set;
        this.e = new b(null);
    }

    private void b() {
        this.b(this.f);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void b(int n2) {
        void var6_2 = this;
        synchronized (var6_2) {
            do {
                if (this.g <= n2) return;
                Bitmap bitmap = this.b.a();
                if (bitmap == null) {
                    if (Log.isLoggable((String)"LruBitmapPool", (int)5)) {
                        Log.w((String)"LruBitmapPool", (String)"Size mismatch, resetting");
                        super.d();
                    }
                    this.g = 0;
                    return;
                }
                this.e.b(bitmap);
                this.g -= this.b.c(bitmap);
                bitmap.recycle();
                this.k = 1 + this.k;
                if (Log.isLoggable((String)"LruBitmapPool", (int)3)) {
                    Log.d((String)"LruBitmapPool", (String)("Evicting bitmap=" + this.b.b(bitmap)));
                }
                super.c();
                continue;
                break;
            } while (true);
            finally {
            }
        }
    }

    private void c() {
        if (Log.isLoggable((String)"LruBitmapPool", (int)2)) {
            this.d();
        }
    }

    private void d() {
        Log.v((String)"LruBitmapPool", (String)("Hits=" + this.h + ", misses=" + this.i + ", puts=" + this.j + ", evictions=" + this.k + ", currentSize=" + this.g + ", maxSize=" + this.f + "\nStrategy=" + this.b));
    }

    private static lr e() {
        if (Build.VERSION.SDK_INT >= 19) {
            return new lt();
        }
        return new ll();
    }

    private static Set<Bitmap.Config> f() {
        HashSet hashSet = new HashSet();
        hashSet.addAll((Collection)Arrays.asList((Object[])Bitmap.Config.values()));
        if (Build.VERSION.SDK_INT >= 19) {
            hashSet.add((Object)null);
        }
        return Collections.unmodifiableSet((Set)hashSet);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public Bitmap a(int n2, int n3, Bitmap.Config config) {
        void var6_4 = this;
        synchronized (var6_4) {
            Bitmap bitmap = this.b(n2, n3, config);
            if (bitmap != null) {
                bitmap.eraseColor(0);
            }
            return bitmap;
        }
    }

    @Override
    public void a() {
        if (Log.isLoggable((String)"LruBitmapPool", (int)3)) {
            Log.d((String)"LruBitmapPool", (String)"clearMemory");
        }
        this.b(0);
    }

    /*
     * Enabled aggressive block sorting
     */
    @SuppressLint(value={"InlinedApi"})
    @Override
    public void a(int n2) {
        if (Log.isLoggable((String)"LruBitmapPool", (int)3)) {
            Log.d((String)"LruBitmapPool", (String)("trimMemory, level=" + n2));
        }
        if (n2 >= 60) {
            this.a();
            return;
        } else {
            if (n2 < 40) return;
            {
                super.b(this.f / 2);
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public boolean a(Bitmap bitmap) {
        void var7_2 = this;
        synchronized (var7_2) {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (!bitmap.isMutable() || this.b.c(bitmap) > this.f || !this.c.contains((Object)bitmap.getConfig())) {
                if (!Log.isLoggable((String)"LruBitmapPool", (int)2)) return false;
                Log.v((String)"LruBitmapPool", (String)("Reject bitmap from pool, bitmap: " + this.b.b(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.c.contains((Object)bitmap.getConfig())));
                return false;
            }
            int n2 = this.b.c(bitmap);
            this.b.a(bitmap);
            this.e.a(bitmap);
            this.j = 1 + this.j;
            this.g = n2 + this.g;
            if (Log.isLoggable((String)"LruBitmapPool", (int)2)) {
                Log.v((String)"LruBitmapPool", (String)("Put bitmap in pool=" + this.b.b(bitmap)));
            }
            super.c();
            super.b();
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @TargetApi(value=12)
    @Override
    public Bitmap b(int n2, int n3, Bitmap.Config config) {
        void var10_4 = this;
        synchronized (var10_4) {
            lr lr2 = this.b;
            Bitmap.Config config2 = config != null ? config : a;
            Bitmap bitmap = lr2.a(n2, n3, config2);
            if (bitmap == null) {
                if (Log.isLoggable((String)"LruBitmapPool", (int)3)) {
                    Log.d((String)"LruBitmapPool", (String)("Missing bitmap=" + this.b.b(n2, n3, config)));
                }
                this.i = 1 + this.i;
            } else {
                this.h = 1 + this.h;
                this.g -= this.b.c(bitmap);
                this.e.b(bitmap);
                if (Build.VERSION.SDK_INT >= 12) {
                    bitmap.setHasAlpha(true);
                }
            }
            if (Log.isLoggable((String)"LruBitmapPool", (int)2)) {
                Log.v((String)"LruBitmapPool", (String)("Get bitmap=" + this.b.b(n2, n3, config)));
            }
            super.c();
            return bitmap;
        }
    }

    static interface a {
        public void a(Bitmap var1);

        public void b(Bitmap var1);
    }

    static class b
    implements a {
        private b() {
        }

        /* synthetic */ b( var1) {
        }

        @Override
        public void a(Bitmap bitmap) {
        }

        @Override
        public void b(Bitmap bitmap) {
        }
    }

}

