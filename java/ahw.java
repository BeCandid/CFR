/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.Context;
import android.text.TextUtils;

public final class ahw {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;

    /*
     * Enabled aggressive block sorting
     */
    private ahw(String string2, String string3, String string4, String string5, String string6, String string7) {
        boolean bl2 = !zv.a(string2);
        xz.a(bl2, (Object)"ApplicationId must be set.");
        this.b = string2;
        this.a = string3;
        this.c = string4;
        this.d = string5;
        this.e = string6;
        this.f = string7;
    }

    public static ahw a(Context context) {
        yf yf2 = new yf(context);
        String string2 = yf2.a("google_app_id");
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return null;
        }
        return new ahw(string2, yf2.a("google_api_key"), yf2.a("firebase_database_url"), yf2.a("ga_trackingId"), yf2.a("gcm_defaultSenderId"), yf2.a("google_storage_bucket"));
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.e;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        if (!(object instanceof ahw)) {
            return false;
        }
        ahw ahw2 = (ahw)object;
        if (!zc.a((Object)this.b, (Object)ahw2.b)) return false;
        if (!zc.a((Object)this.a, (Object)ahw2.a)) return false;
        if (!zc.a((Object)this.c, (Object)ahw2.c)) return false;
        if (!zc.a((Object)this.d, (Object)ahw2.d)) return false;
        if (!zc.a((Object)this.e, (Object)ahw2.e)) return false;
        if (!zc.a((Object)this.f, (Object)ahw2.f)) return false;
        return true;
    }

    public int hashCode() {
        Object[] arrobject = new Object[]{this.b, this.a, this.c, this.d, this.e, this.f};
        return zc.a(arrobject);
    }

    public String toString() {
        return zc.a((Object)this).a("applicationId", this.b).a("apiKey", this.a).a("databaseUrl", this.c).a("gcmSenderId", this.e).a("storageBucket", this.f).toString();
    }
}

