/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Fragment
 *  android.content.Intent
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.FragmentActivity
 *  java.lang.Object
 */
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;

public class vq {
    private android.support.v4.app.Fragment a;
    private Fragment b;

    public vq(Fragment fragment) {
        wf.a((Object)fragment, "fragment");
        this.b = fragment;
    }

    public vq(android.support.v4.app.Fragment fragment) {
        wf.a((Object)fragment, "fragment");
        this.a = fragment;
    }

    public Fragment a() {
        return this.b;
    }

    public void a(Intent intent, int n2) {
        if (this.a != null) {
            this.a.startActivityForResult(intent, n2);
            return;
        }
        this.b.startActivityForResult(intent, n2);
    }

    public android.support.v4.app.Fragment b() {
        return this.a;
    }

    public final Activity c() {
        if (this.a != null) {
            return this.a.getActivity();
        }
        return this.b.getActivity();
    }
}

