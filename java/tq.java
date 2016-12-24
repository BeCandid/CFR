/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  io.fabric.sdk.android.services.common.CommonUtils
 *  java.io.Closeable
 *  java.io.File
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Locale
 */
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

class tq
implements tk {
    private final File a;
    private final int b;
    private aly c;

    public tq(File file, int n2) {
        this.a = file;
        this.b = n2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b(long l2, String string2) {
        if (this.c == null) return;
        {
            if (string2 == null) {
                string2 = "null";
            }
            try {
                int n2 = this.b / 4;
                if (string2.length() > n2) {
                    string2 = "..." + string2.substring(string2.length() - n2);
                }
                String string3 = string2.replaceAll("\r", " ").replaceAll("\n", " ");
                Locale locale = Locale.US;
                Object[] arrobject = new Object[]{l2, string3};
                byte[] arrby = String.format((Locale)locale, (String)"%d %s%n", (Object[])arrobject).getBytes("UTF-8");
                this.c.a(arrby);
                while (!this.c.b() && this.c.a() > this.b) {
                    this.c.c();
                }
                return;
            }
            catch (IOException var4_8) {
                akx.h().e("CrashlyticsCore", "There was a problem writing to the Crashlytics log.", (Throwable)var4_8);
                return;
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void d() {
        if (this.c != null) return;
        try {
            this.c = new aly(this.a);
            return;
        }
        catch (IOException var1_1) {
            akx.h().e("CrashlyticsCore", "Could not open log file: " + (Object)this.a, (Throwable)var1_1);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public sw a() {
        if (!this.a.exists()) {
            return null;
        }
        this.d();
        if (this.c == null) return null;
        final int[] arrn = new int[]{0};
        final byte[] arrby = new byte[this.c.a()];
        try {
            this.c.a(new aly.c(){

                @Override
                public void a(InputStream inputStream, int n2) throws IOException {
                    try {
                        inputStream.read(arrby, arrn[0], n2);
                        int[] arrn2 = arrn;
                        arrn2[0] = n2 + arrn2[0];
                        return;
                    }
                    finally {
                        inputStream.close();
                    }
                }
            });
        }
        catch (IOException var3_3) {
            akx.h().e("CrashlyticsCore", "A problem occurred while reading the Crashlytics log file.", (Throwable)var3_3);
            return sw.a(arrby, 0, arrn[0]);
        }
        return sw.a(arrby, 0, arrn[0]);
    }

    @Override
    public void a(long l2, String string2) {
        super.d();
        super.b(l2, string2);
    }

    @Override
    public void b() {
        CommonUtils.a((Closeable)this.c, (String)"There was a problem closing the Crashlytics log file.");
        this.c = null;
    }

    @Override
    public void c() {
        this.b();
        this.a.delete();
    }

}

