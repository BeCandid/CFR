/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.support.v4.app.Fragment
 *  butterknife.Unbinder
 */
import android.content.Context;
import android.support.v4.app.Fragment;
import butterknife.Unbinder;

public abstract class ht
extends Fragment {
    public Context a;
    public Unbinder b;
    public boolean c;

    public void a() {
        if (this.c) {
            return;
        }
        this.c = true;
    }

    public abstract void b();

    public abstract void c();

    public void onDestroyView() {
        super.onDestroyView();
        if (this.b != null) {
            this.b.unbind();
        }
    }
}

