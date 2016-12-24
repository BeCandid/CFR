/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  io.fabric.sdk.android.services.network.HttpMethod
 *  io.fabric.sdk.android.services.network.HttpRequest
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class th
extends all
implements tg {
    public th(alc alc2, String string2, String string3, anb anb2) {
        super(alc2, string2, string3, anb2, HttpMethod.b);
    }

    private HttpRequest a(HttpRequest httpRequest, tf tf2) {
        HttpRequest httpRequest2 = httpRequest.a("X-CRASHLYTICS-API-KEY", tf2.a).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", sz.e().a());
        Iterator iterator = tf2.b.e().entrySet().iterator();
        while (iterator.hasNext()) {
            httpRequest2 = httpRequest2.a((Map.Entry)iterator.next());
        }
        return httpRequest2;
    }

    private HttpRequest b(HttpRequest httpRequest, tf tf2) {
        tr tr2 = tf2.b;
        return httpRequest.a("report[file]", tr2.b(), "application/octet-stream", tr2.d()).e("report[identifier]", tr2.c());
    }

    @Override
    public boolean a(tf tf2) {
        HttpRequest httpRequest = super.b(super.a(this.b(), tf2), tf2);
        akx.h().a("CrashlyticsCore", "Sending report to: " + this.a());
        int n2 = httpRequest.b();
        akx.h().a("CrashlyticsCore", "Create report request ID: " + httpRequest.b("X-REQUEST-ID"));
        akx.h().a("CrashlyticsCore", "Result was: " + n2);
        if (alz.a(n2) == 0) {
            return true;
        }
        return false;
    }
}

