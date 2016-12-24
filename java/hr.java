/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.FragmentManager
 *  android.support.v4.app.FragmentPagerAdapter
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class hr
extends FragmentPagerAdapter {
    private static int a = 4;

    public hr(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public int getCount() {
        return a;
    }

    public Fragment getItem(int n2) {
        switch (n2) {
            default: {
                return null;
            }
            case 0: {
                return new if();
            }
            case 1: {
                return new ie();
            }
            case 2: {
                return new id();
            }
            case 3: 
        }
        return new ic();
    }
}

