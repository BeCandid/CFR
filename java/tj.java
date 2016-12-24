/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  io.fabric.sdk.android.services.common.CommonUtils
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;

class tj {
    private final Context a;
    private final any b;

    public tj(Context context, any any2) {
        this.a = context;
        this.b = any2;
    }

    private String a(String string2, String string3) {
        return super.b(CommonUtils.b((Context)this.a, (String)string2), string3);
    }

    private boolean a(String string2) {
        if (string2 == null || string2.length() == 0) {
            return true;
        }
        return false;
    }

    private String b(String string2, String string3) {
        if (super.a(string2)) {
            return string3;
        }
        return string2;
    }

    public String a() {
        return this.a("com.crashlytics.CrashSubmissionPromptTitle", this.b.a);
    }

    public String b() {
        return this.a("com.crashlytics.CrashSubmissionPromptMessage", this.b.b);
    }

    public String c() {
        return this.a("com.crashlytics.CrashSubmissionSendTitle", this.b.c);
    }

    public String d() {
        return this.a("com.crashlytics.CrashSubmissionAlwaysSendTitle", this.b.g);
    }

    public String e() {
        return this.a("com.crashlytics.CrashSubmissionCancelTitle", this.b.e);
    }
}

