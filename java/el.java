/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  android.view.MenuItem$OnActionExpandListener
 *  java.lang.Object
 */
import android.view.MenuItem;

class el {
    public static MenuItem a(MenuItem menuItem, b b2) {
        return menuItem.setOnActionExpandListener((MenuItem.OnActionExpandListener)new a(b2));
    }

    public static boolean a(MenuItem menuItem) {
        return menuItem.expandActionView();
    }

    public static boolean b(MenuItem menuItem) {
        return menuItem.isActionViewExpanded();
    }

    static class a
    implements MenuItem.OnActionExpandListener {
        private b a;

        public a(b b2) {
            this.a = b2;
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.a.b(menuItem);
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.a.a(menuItem);
        }
    }

    static interface b {
        public boolean a(MenuItem var1);

        public boolean b(MenuItem var1);
    }

}

