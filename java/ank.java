/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  io.fabric.sdk.android.services.common.CommonUtils
 *  io.fabric.sdk.android.services.network.HttpMethod
 *  io.fabric.sdk.android.services.network.HttpRequest
 *  java.io.Closeable
 *  java.io.InputStream
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Collection
 *  java.util.Locale
 */
import android.content.Context;
import android.content.res.Resources;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Collection;
import java.util.Locale;

abstract class ank
extends all {
    public ank(alc alc2, String string2, String string3, anb anb2, HttpMethod httpMethod) {
        super(alc2, string2, string3, anb2, httpMethod);
    }

    private HttpRequest a(HttpRequest httpRequest, ann ann2) {
        return httpRequest.a("X-CRASHLYTICS-API-KEY", ann2.a).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.a());
    }

    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private HttpRequest b(HttpRequest var1, ann var2_2) {
        var3_3 = var1.e("app[identifier]", var2_2.b).e("app[name]", var2_2.f).e("app[display_version]", var2_2.c).e("app[build_version]", var2_2.d).a("app[source]", (Number)var2_2.g).e("app[minimum_sdk_version]", var2_2.h).e("app[built_sdk_version]", var2_2.i);
        if (!CommonUtils.c((String)var2_2.e)) {
            var3_3.e("app[instance_identifier]", var2_2.e);
        }
        if (var2_2.j != null) {
            var8_4 = null;
            var8_4 = this.a.E().getResources().openRawResource(var2_2.j.b);
            var3_3.e("app[icon][hash]", var2_2.j.a).a("app[icon][data]", "icon.png", "application/octet-stream", var8_4).a("app[icon][width]", (Number)var2_2.j.c).a("app[icon][height]", (Number)var2_2.j.d);
        }
lbl9: // 5 sources:
        while (var2_2.k != null) {
            for (ale var5_7 : var2_2.k) {
                var3_3.e(this.a(var5_7), var5_7.b());
                var3_3.e(this.b(var5_7), var5_7.c());
            }
            return var3_3;
        }
        return var3_3;
        catch (Resources.NotFoundException var10_5) {
            akx.h().e("Fabric", "Failed to find app icon with resource ID: " + var2_2.j.b, (Throwable)var10_5);
        }
        finally {
            CommonUtils.a((Closeable)var8_4, (String)"Failed to close app icon InputStream.");
        }
        ** GOTO lbl9
    }

    String a(ale ale2) {
        Locale locale = Locale.US;
        Object[] arrobject = new Object[]{ale2.a()};
        return String.format((Locale)locale, (String)"app[build][libraries][%s][version]", (Object[])arrobject);
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean a(ann ann2) {
        HttpRequest httpRequest = super.b(super.a(this.b(), ann2), ann2);
        akx.h().a("Fabric", "Sending app info to " + this.a());
        if (ann2.j != null) {
            akx.h().a("Fabric", "App icon hash is " + ann2.j.a);
            akx.h().a("Fabric", "App icon size is " + ann2.j.c + "x" + ann2.j.d);
        }
        int n2 = httpRequest.b();
        String string2 = "POST".equals((Object)httpRequest.p()) ? "Create" : "Update";
        akx.h().a("Fabric", string2 + " app request ID: " + httpRequest.b("X-REQUEST-ID"));
        akx.h().a("Fabric", "Result was " + n2);
        if (alz.a(n2) == 0) {
            return true;
        }
        return false;
    }

    String b(ale ale2) {
        Locale locale = Locale.US;
        Object[] arrobject = new Object[]{ale2.a()};
        return String.format((Locale)locale, (String)"app[build][libraries][%s][type]", (Object[])arrobject);
    }
}

