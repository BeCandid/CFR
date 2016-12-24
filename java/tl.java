/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  io.fabric.sdk.android.services.common.CommonUtils
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Set
 */
import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.File;
import java.util.Set;

class tl {
    private static final a a = new a(null);
    private final Context b;
    private final ang c;
    private tk d;

    public tl(Context context, ang ang2) {
        super(context, ang2, null);
    }

    public tl(Context context, ang ang2, String string2) {
        this.b = context;
        this.c = ang2;
        this.d = a;
        this.a(string2);
    }

    private String a(File file) {
        String string2 = file.getName();
        int n2 = string2.lastIndexOf(".temp");
        if (n2 == -1) {
            return string2;
        }
        return string2.substring("crashlytics-userlog-".length(), n2);
    }

    private File b(String string2) {
        String string3 = "crashlytics-userlog-" + string2 + ".temp";
        return new File(super.d(), string3);
    }

    private boolean c() {
        return CommonUtils.a((Context)this.b, (String)"com.crashlytics.CollectCustomLogs", (boolean)true);
    }

    private File d() {
        File file = new File(this.c.a(), "log-files");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public sw a() {
        return this.d.a();
    }

    public void a(long l2, String string2) {
        this.d.a(l2, string2);
    }

    void a(File file, int n2) {
        this.d = new tq(file, n2);
    }

    public final void a(String string2) {
        this.d.b();
        this.d = a;
        if (string2 == null) {
            return;
        }
        if (!super.c()) {
            akx.h().a("CrashlyticsCore", "Preferences requested no custom logs. Aborting log file creation.");
            return;
        }
        this.a(super.b(string2), 65536);
    }

    public void a(Set<String> set) {
        File[] arrfile = super.d().listFiles();
        if (arrfile != null) {
            for (File file : arrfile) {
                if (set.contains((Object)super.a(file))) continue;
                file.delete();
            }
        }
    }

    public void b() {
        this.d.c();
    }

    static final class a
    implements tk {
        private a() {
        }

        /* synthetic */ a( var1) {
        }

        @Override
        public sw a() {
            return null;
        }

        @Override
        public void a(long l2, String string2) {
        }

        @Override
        public void b() {
        }

        @Override
        public void c() {
        }
    }

}

