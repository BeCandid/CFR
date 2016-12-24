/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.crashlytics.android.core.CrashlyticsMissingDependencyException
 *  io.fabric.sdk.android.services.common.CommonUtils
 *  java.lang.Object
 *  java.lang.String
 */
import android.util.Log;
import com.crashlytics.android.core.CrashlyticsMissingDependencyException;
import io.fabric.sdk.android.services.common.CommonUtils;

class sv {
    private final String a;
    private final boolean b;

    public sv(String string2, boolean bl2) {
        this.a = string2;
        this.b = bl2;
    }

    public void a(String string2, String string3) {
        if (CommonUtils.c((String)this.a) && this.b) {
            String string4 = this.b(string2, string3);
            Log.e((String)"CrashlyticsCore", (String)".");
            Log.e((String)"CrashlyticsCore", (String)".     |  | ");
            Log.e((String)"CrashlyticsCore", (String)".     |  |");
            Log.e((String)"CrashlyticsCore", (String)".     |  |");
            Log.e((String)"CrashlyticsCore", (String)".   \\ |  | /");
            Log.e((String)"CrashlyticsCore", (String)".    \\    /");
            Log.e((String)"CrashlyticsCore", (String)".     \\  /");
            Log.e((String)"CrashlyticsCore", (String)".      \\/");
            Log.e((String)"CrashlyticsCore", (String)".");
            Log.e((String)"CrashlyticsCore", (String)string4);
            Log.e((String)"CrashlyticsCore", (String)".");
            Log.e((String)"CrashlyticsCore", (String)".      /\\");
            Log.e((String)"CrashlyticsCore", (String)".     /  \\");
            Log.e((String)"CrashlyticsCore", (String)".    /    \\");
            Log.e((String)"CrashlyticsCore", (String)".   / |  | \\");
            Log.e((String)"CrashlyticsCore", (String)".     |  |");
            Log.e((String)"CrashlyticsCore", (String)".     |  |");
            Log.e((String)"CrashlyticsCore", (String)".     |  |");
            Log.e((String)"CrashlyticsCore", (String)".");
            throw new CrashlyticsMissingDependencyException(string4);
        }
        if (!this.b) {
            akx.h().a("CrashlyticsCore", "Configured not to require a build ID.");
        }
    }

    protected String b(String string2, String string3) {
        return "This app relies on Crashlytics. Please sign up for access at https://fabric.io/sign_up,\ninstall an Android build tool and ask a team member to invite you to this app's organization.";
    }
}

