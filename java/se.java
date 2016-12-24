/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  io.fabric.sdk.android.services.network.HttpMethod
 *  io.fabric.sdk.android.services.network.HttpRequest
 *  java.io.File
 *  java.lang.String
 *  java.util.List
 */
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.File;
import java.util.List;

class se
extends all
implements amv {
    private final String b;

    public se(alc alc2, String string2, String string3, anb anb2, String string4) {
        super(alc2, string2, string3, anb2, HttpMethod.b);
        this.b = string4;
    }

    @Override
    public boolean a(List<File> list) {
        HttpRequest httpRequest = this.b().a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.a()).a("X-CRASHLYTICS-API-KEY", this.b);
        int n2 = 0;
        for (File file : list) {
            httpRequest.a("session_analytics_file_" + n2, file.getName(), "application/vnd.crashlytics.android.events", file);
            ++n2;
        }
        akx.h().a("Answers", "Sending " + list.size() + " analytics files to " + this.a());
        int n3 = httpRequest.b();
        akx.h().a("Answers", "Response code for analytics file send is " + n3);
        if (alz.a(n3) == 0) {
            return true;
        }
        return false;
    }
}

