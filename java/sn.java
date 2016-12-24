/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.Application
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  io.fabric.sdk.android.services.common.CommonUtils
 *  io.fabric.sdk.android.services.common.IdManager
 *  io.fabric.sdk.android.services.common.IdManager$DeviceIdentifierType
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.concurrent.ExecutorService
 */
import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.text.TextUtils;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.IdManager;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class sn
extends alc<Boolean>
implements alv {
    private final ali<String> a = new ali();
    private final ss b = new ss();
    private su c;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String a(Context context, String string2) {
        String string3;
        try {
            String string4 = this.a.a(context, this.b);
            boolean bl2 = "".equals((Object)string4);
            string3 = bl2 ? null : string4;
        }
        catch (Exception var3_9) {
            akx.h().e("Beta", "Failed to load the Beta device token", (Throwable)var3_9);
            string3 = null;
        }
        alf alf2 = akx.h();
        StringBuilder stringBuilder = new StringBuilder().append("Beta device token present: ");
        boolean bl3 = !TextUtils.isEmpty((CharSequence)string3);
        alf2.a("Beta", stringBuilder.append(bl3).toString());
        return string3;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private so a(Context context) {
        InputStream inputStream = null;
        so so2 = null;
        inputStream = context.getAssets().open("crashlytics-build.properties");
        so2 = null;
        if (inputStream != null) {
            so2 = so.a(inputStream);
            akx.h().a("Beta", so2.d + " build properties: " + so2.b + " (" + so2.a + ")" + " - " + so2.c);
        }
        if (inputStream == null) return so2;
        try {
            inputStream.close();
            return so2;
        }
        catch (IOException var8_4) {
            akx.h().e("Beta", "Error closing Beta build properties asset", (Throwable)var8_4);
            return so2;
        }
        catch (Exception exception) {
            try {
                akx.h().e("Beta", "Error reading Beta build properties", (Throwable)exception);
                if (inputStream == null) return so2;
            }
            catch (Throwable var4_7) {
                if (inputStream == null) throw var4_7;
                try {
                    inputStream.close();
                }
                catch (IOException var5_8) {
                    akx.h().e("Beta", "Error closing Beta build properties asset", (Throwable)var5_8);
                    throw var4_7;
                }
                throw var4_7;
            }
            try {
                inputStream.close();
                return so2;
            }
            catch (IOException var7_6) {
                akx.h().e("Beta", "Error closing Beta build properties asset", (Throwable)var7_6);
                return so2;
            }
        }
    }

    private anp h() {
        aoc aoc2 = aoa.a().b();
        if (aoc2 != null) {
            return aoc2.f;
        }
        return null;
    }

    @Override
    public String a() {
        return "1.2.1.139";
    }

    @TargetApi(value=14)
    su a(int n2, Application application) {
        if (n2 >= 14) {
            return new sm(this.F().e(), this.F().f());
        }
        return new st();
    }

    boolean a(anp anp2, so so2) {
        if (anp2 != null && !TextUtils.isEmpty((CharSequence)anp2.a) && so2 != null) {
            return true;
        }
        return false;
    }

    @TargetApi(value=14)
    @Override
    protected boolean a_() {
        Application application = (Application)this.E().getApplicationContext();
        this.c = this.a(Build.VERSION.SDK_INT, application);
        return true;
    }

    @Override
    public String b() {
        return "com.crashlytics.sdk.android:beta";
    }

    protected Boolean c() {
        akx.h().a("Beta", "Beta kit initializing...");
        Context context = this.E();
        IdManager idManager = this.D();
        if (TextUtils.isEmpty((CharSequence)this.a(context, idManager.j()))) {
            akx.h().a("Beta", "A Beta device token was not found for this app");
            return false;
        }
        akx.h().a("Beta", "Beta device token is present, checking for app updates.");
        anp anp2 = this.h();
        so so2 = this.a(context);
        if (this.a(anp2, so2)) {
            this.c.a(context, this, idManager, anp2, so2, new anj(this), new ama(), new ana(akx.h()));
        }
        return true;
    }

    @Override
    public Map<IdManager.DeviceIdentifierType, String> e() {
        String string2 = this.D().j();
        String string3 = this.a(this.E(), string2);
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty((CharSequence)string3)) {
            hashMap.put((Object)IdManager.DeviceIdentifierType.c, (Object)string3);
        }
        return hashMap;
    }

    @Override
    protected /* synthetic */ Object f() {
        return this.c();
    }

    String g() {
        return CommonUtils.b((Context)this.E(), (String)"com.crashlytics.ApiEndpoint");
    }
}

