/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Parcelable
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.Intent;
import android.os.Parcelable;
import com.facebook.Profile;

public final class ur {
    private static volatile ur a;
    private final bn b;
    private final uq c;
    private Profile d;

    ur(bn bn2, uq uq2) {
        wf.a(bn2, "localBroadcastManager");
        wf.a(uq2, "profileCache");
        this.b = bn2;
        this.c = uq2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static ur a() {
        if (a != null) return a;
        reference var1 = ur.class;
        // MONITORENTER : ur.class
        if (a == null) {
            a = new ur(bn.a(ul.f()), new uq());
        }
        // MONITOREXIT : var1
        return a;
    }

    private void a(Profile profile, Profile profile2) {
        Intent intent = new Intent("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_PROFILE", (Parcelable)profile);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_PROFILE", (Parcelable)profile2);
        this.b.a(intent);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(Profile profile, boolean bl2) {
        Profile profile2 = this.d;
        this.d = profile;
        if (bl2) {
            if (profile != null) {
                this.c.a(profile);
            } else {
                this.c.b();
            }
        }
        if (!we.a(profile2, profile)) {
            super.a(profile2, profile);
        }
    }

    public void a(Profile profile) {
        super.a(profile, true);
    }

    public Profile b() {
        return this.d;
    }

    boolean c() {
        Profile profile = this.c.a();
        boolean bl2 = false;
        if (profile != null) {
            this.a(profile, false);
            bl2 = true;
        }
        return bl2;
    }
}

