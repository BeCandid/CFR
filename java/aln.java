/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 */
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

public class aln {
    private final Context a;
    private final ani b;

    public aln(Context context) {
        this.a = context.getApplicationContext();
        this.b = new anj(context, "TwitterAdvertisingInfoPreferences");
    }

    private void a(final alm alm2) {
        new Thread((Runnable)new als(){

            @Override
            public void a() {
                alm alm22 = aln.this.e();
                if (!alm2.equals(alm22)) {
                    akx.h().a("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
                    aln.this.b(alm22);
                }
            }
        }).start();
    }

    @SuppressLint(value={"CommitPrefEdits"})
    private void b(alm alm2) {
        if (super.c(alm2)) {
            this.b.a(this.b.b().putString("advertising_id", alm2.a).putBoolean("limit_ad_tracking_enabled", alm2.b));
            return;
        }
        this.b.a(this.b.b().remove("advertising_id").remove("limit_ad_tracking_enabled"));
    }

    private boolean c(alm alm2) {
        if (alm2 != null && !TextUtils.isEmpty((CharSequence)alm2.a)) {
            return true;
        }
        return false;
    }

    private alm e() {
        alm alm2 = this.c().a();
        if (!this.c(alm2)) {
            alm alm3 = this.d().a();
            if (!this.c(alm3)) {
                akx.h().a("Fabric", "AdvertisingInfo not present");
                return alm3;
            }
            akx.h().a("Fabric", "Using AdvertisingInfo from Service Provider");
            return alm3;
        }
        akx.h().a("Fabric", "Using AdvertisingInfo from Reflection Provider");
        return alm2;
    }

    public alm a() {
        alm alm2 = this.b();
        if (this.c(alm2)) {
            akx.h().a("Fabric", "Using AdvertisingInfo from Preference Store");
            this.a(alm2);
            return alm2;
        }
        alm alm3 = this.e();
        this.b(alm3);
        return alm3;
    }

    protected alm b() {
        return new alm(this.b.a().getString("advertising_id", ""), this.b.a().getBoolean("limit_ad_tracking_enabled", false));
    }

    public alq c() {
        return new alo(this.a);
    }

    public alq d() {
        return new alp(this.a);
    }

}

