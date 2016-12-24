/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.ParcelFileDescriptor
 *  android.util.Log
 *  com.bumptech.glide.Priority
 *  java.io.InputStream
 *  java.lang.Exception
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.Priority;
import java.io.InputStream;

public class ml<A>
implements mr<A, mm> {
    private final mr<A, InputStream> a;
    private final mr<A, ParcelFileDescriptor> b;

    public ml(mr<A, InputStream> mr2, mr<A, ParcelFileDescriptor> mr3) {
        if (mr2 == null && mr3 == null) {
            throw new NullPointerException("At least one of streamLoader and fileDescriptorLoader must be non null");
        }
        this.a = mr2;
        this.b = mr3;
    }

    @Override
    public ku<mm> a(A a2, int n2, int n3) {
        mr<A, InputStream> mr2 = this.a;
        ku<InputStream> ku2 = null;
        if (mr2 != null) {
            ku2 = this.a.a(a2, n2, n3);
        }
        mr<A, ParcelFileDescriptor> mr3 = this.b;
        ku<ParcelFileDescriptor> ku3 = null;
        if (mr3 != null) {
            ku3 = this.b.a(a2, n2, n3);
        }
        if (ku2 != null || ku3 != null) {
            return new a(ku2, ku3);
        }
        return null;
    }

    static class a
    implements ku<mm> {
        private final ku<InputStream> a;
        private final ku<ParcelFileDescriptor> b;

        public a(ku<InputStream> ku2, ku<ParcelFileDescriptor> ku3) {
            this.a = ku2;
            this.b = ku3;
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive exception aggregation
         */
        public mm a(Priority var1) throws Exception {
            var2_2 = this.a;
            var3_3 = null;
            if (var2_2 != null) {
                var3_3 = this.a.b(var1);
            }
            do {
                var4_4 = this.b;
                var5_5 = null;
                if (var4_4 != null) {
                    var5_5 = this.b.b(var1);
                }
                do {
                    return new mm(var3_3, var5_5);
                    break;
                } while (true);
                break;
            } while (true);
            catch (Exception var8_6) {
                if (Log.isLoggable((String)"IVML", (int)2)) {
                    Log.v((String)"IVML", (String)"Exception fetching input stream, trying ParcelFileDescriptor", (Throwable)var8_6);
                }
                var9_7 = this.b;
                var3_3 = null;
                if (var9_7 != null) ** continue;
                throw var8_6;
            }
            catch (Exception var6_8) {
                if (Log.isLoggable((String)"IVML", (int)2)) {
                    Log.v((String)"IVML", (String)"Exception fetching ParcelFileDescriptor", (Throwable)var6_8);
                }
                var5_5 = null;
                if (var3_3 != null) ** continue;
                throw var6_8;
            }
        }

        @Override
        public void a() {
            if (this.a != null) {
                this.a.a();
            }
            if (this.b != null) {
                this.b.a();
            }
        }

        @Override
        public /* synthetic */ Object b(Priority priority) throws Exception {
            return this.a(priority);
        }

        @Override
        public String b() {
            if (this.a != null) {
                return this.a.b();
            }
            return this.b.b();
        }

        @Override
        public void c() {
            if (this.a != null) {
                this.a.c();
            }
            if (this.b != null) {
                this.b.c();
            }
        }
    }

}

