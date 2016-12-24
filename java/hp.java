/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.FragmentManager
 *  android.support.v4.app.FragmentStatePagerAdapter
 *  android.util.SparseArray
 *  android.view.ViewGroup
 *  java.lang.Object
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

public abstract class hp
extends FragmentStatePagerAdapter {
    private SparseArray<Fragment> a = new SparseArray();

    public hp(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public Fragment b(int n2) {
        return (Fragment)this.a.get(n2);
    }

    public void destroyItem(ViewGroup viewGroup, int n2, Object object) {
        this.a.remove(n2);
        super.destroyItem(viewGroup, n2, object);
    }

    public Object instantiateItem(ViewGroup viewGroup, int n2) {
        Fragment fragment = (Fragment)super.instantiateItem(viewGroup, n2);
        this.a.put(n2, (Object)fragment);
        return fragment;
    }
}

