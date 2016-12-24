/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.File
 *  java.io.FilenameFilter
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.InterruptedException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.LinkedList
 *  java.util.List
 *  java.util.Map
 */
import android.content.Context;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class ts {
    static final Map<String, String> a;
    private static final FilenameFilter b;
    private static final short[] c;
    private final Object d = new Object();
    private final tg e;
    private Thread f;

    static {
        b = new FilenameFilter(){

            public boolean accept(File file, String string2) {
                if (string2.endsWith(".cls") && !string2.contains((CharSequence)"Session")) {
                    return true;
                }
                return false;
            }
        };
        a = Collections.singletonMap((Object)"X-CRASHLYTICS-INVALID-SESSION", (Object)"1");
        c = new short[]{10, 20, 30, 60, 120, 300};
    }

    public ts(tg tg2) {
        if (tg2 == null) {
            throw new IllegalArgumentException("createReportCall must not be null.");
        }
        this.e = tg2;
    }

    static /* synthetic */ short[] b() {
        return c;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    List<tr> a() {
        Object object;
        File[] arrfile;
        akx.h().a("CrashlyticsCore", "Checking for crash reports...");
        Object object2 = object = this.d;
        synchronized (object2) {
            arrfile = sz.e().w().listFiles(b);
        }
        LinkedList linkedList = new LinkedList();
        for (File file : arrfile) {
            akx.h().a("CrashlyticsCore", "Found crash report " + file.getPath());
            linkedList.add((Object)new tu(file));
        }
        if (linkedList.isEmpty()) {
            akx.h().a("CrashlyticsCore", "No reports found.");
        }
        return linkedList;
    }

    public void a(float f2) {
        void var3_2 = this;
        synchronized (var3_2) {
            if (this.f == null) {
                this.f = new Thread((Runnable)(ts)this.new a(f2), "Crashlytics Report Uploader");
                this.f.start();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    boolean a(tr tr2) {
        Object object;
        Object object2 = object = this.d;
        synchronized (object2) {
            try {
                Context context = sz.e().E();
                tf tf2 = new tf(new alr().a(context), tr2);
                boolean bl2 = this.e.a(tf2);
                alf alf2 = akx.h();
                StringBuilder stringBuilder = new StringBuilder().append("Crashlytics report upload ");
                String string2 = bl2 ? "complete: " : "FAILED: ";
                alf2.c("CrashlyticsCore", stringBuilder.append(string2).append(tr2.b()).toString());
                boolean bl3 = false;
                if (!bl2) return bl3;
                tr2.a();
                return true;
            }
            catch (Exception var4_11) {
                akx.h().e("CrashlyticsCore", "Error occurred sending report " + tr2, (Throwable)var4_11);
                return false;
            }
        }
    }

    class a
    extends als {
        private final float b;

        a(float f2) {
            this.b = f2;
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        private void b() {
            akx.h().a("CrashlyticsCore", "Starting report processing in " + this.b + " second(s)...");
            if (this.b > 0.0f) {
                Thread.sleep((long)((long)(1000.0f * this.b)));
            }
            var1_1 = sz.e();
            var2_2 = var1_1.o();
            var3_3 = ts.this.a();
            if (var2_2.a()) {
                return;
            }
            ** GOTO lbl14
            catch (InterruptedException var17_4) {
                Thread.currentThread().interrupt();
                return;
            }
lbl14: // 1 sources:
            if (!var3_3.isEmpty() && !var1_1.z()) {
                akx.h().a("CrashlyticsCore", "User declined to send. Removing " + var3_3.size() + " Report(s).");
                var15_5 = var3_3.iterator();
                while (var15_5.hasNext()) {
                    ((tr)var15_5.next()).a();
                }
                return;
            }
            var4_6 = 0;
            while (var3_3.isEmpty() == false) {
                if (sz.e().o().a()) return;
                {
                    akx.h().a("CrashlyticsCore", "Attempting to send " + var3_3.size() + " report(s)");
                    for (tr var13_8 : var3_3) {
                        ts.this.a(var13_8);
                    }
                    var3_3 = ts.this.a();
                    if (var3_3.isEmpty()) continue;
                    var6_12 = ts.b();
                    var7_11 = var4_6 + 1;
                    var8_7 = var6_12[Math.min((int)var4_6, (int)(-1 + ts.b().length))];
                    akx.h().a("CrashlyticsCore", "Report submisson: scheduling delayed retry in " + var8_7 + " seconds");
                    var10_10 = 1000 * var8_7;
                    try {
                        Thread.sleep((long)var10_10);
                        var4_6 = var7_11;
                        continue;
                    }
                    catch (InterruptedException var12_13) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void a() {
            try {
                this.b();
            }
            catch (Exception var1_1) {
                akx.h().e("CrashlyticsCore", "An unexpected error occurred while attempting to upload crash reports.", (Throwable)var1_1);
            }
            ts.this.f = null;
        }
    }

}

