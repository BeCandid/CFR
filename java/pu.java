/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.app.Activity
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.FragmentActivity
 *  android.support.v4.app.FragmentManager
 *  java.lang.Object
 *  java.util.HashSet
 */
import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import java.util.HashSet;

public class pu
extends Fragment {
    private jz a;
    private final pi b;
    private final ps c;
    private final HashSet<pu> d;
    private pu e;

    public pu() {
        this(new pi());
    }

    @SuppressLint(value={"ValidFragment"})
    public pu(pi pi2) {
        this.c = new a((pu)this, null);
        this.d = new HashSet();
        this.b = pi2;
    }

    private void a(pu pu2) {
        this.d.add((Object)pu2);
    }

    private void b(pu pu2) {
        this.d.remove((Object)pu2);
    }

    pi a() {
        return this.b;
    }

    public void a(jz jz2) {
        this.a = jz2;
    }

    public jz b() {
        return this.a;
    }

    public ps c() {
        return this.c;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.e = pr.a().a(this.getActivity().getSupportFragmentManager());
        if (this.e != this) {
            this.e.a((pu)this);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.b.c();
    }

    public void onDetach() {
        super.onDetach();
        if (this.e != null) {
            this.e.b(this);
            this.e = null;
        }
    }

    public void onLowMemory() {
        super.onLowMemory();
        if (this.a != null) {
            this.a.a();
        }
    }

    public void onStart() {
        super.onStart();
        this.b.a();
    }

    public void onStop() {
        super.onStop();
        this.b.b();
    }

    class a
    implements ps {
        final /* synthetic */ pu a;

        private a(pu pu2) {
            this.a = pu2;
        }

        /* synthetic */ a(pu pu2,  var2_2) {
            super(pu2);
        }
    }

}

