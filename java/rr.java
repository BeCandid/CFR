/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  java.lang.Object
 *  java.lang.String
 */
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

class rr {
    private final ani a;

    rr(ani ani2) {
        this.a = ani2;
    }

    public static rr a(Context context) {
        return new rr(new anj(context, "settings"));
    }

    @SuppressLint(value={"CommitPrefEdits"})
    public void a() {
        this.a.a(this.a.b().putBoolean("analytics_launched", true));
    }

    @SuppressLint(value={"CommitPrefEdits"})
    public boolean b() {
        return this.a.a().getBoolean("analytics_launched", false);
    }
}

