/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.util.StateSet
 *  android.view.View
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  java.lang.Object
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 */
import android.util.StateSet;
import android.view.View;
import android.view.animation.Animation;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

final class z {
    private final ArrayList<a> a = new ArrayList();
    private a b = null;
    private Animation c = null;
    private WeakReference<View> d;
    private Animation.AnimationListener e;

    z() {
        this.e = new Animation.AnimationListener(){

            public void onAnimationEnd(Animation animation) {
                if (z.this.c == animation) {
                    z.this.c = null;
                }
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        };
    }

    private void a(a a2) {
        this.c = a2.b;
        View view = this.a();
        if (view != null) {
            view.startAnimation(this.c);
        }
    }

    private void c() {
        View view = this.a();
        int n2 = this.a.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            Animation animation = ((a)this.a.get((int)i2)).b;
            if (view.getAnimation() != animation) continue;
            view.clearAnimation();
        }
        this.d = null;
        this.b = null;
        this.c = null;
    }

    private void d() {
        if (this.c != null) {
            View view = this.a();
            if (view != null && view.getAnimation() == this.c) {
                view.clearAnimation();
            }
            this.c = null;
        }
    }

    View a() {
        if (this.d == null) {
            return null;
        }
        return (View)this.d.get();
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    void a(View view) {
        View view2 = this.a();
        if (view2 == view) {
            return;
        }
        if (view2 != null) {
            super.c();
        }
        if (view == null) return;
        this.d = new WeakReference((Object)view);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    void a(int[] var1) {
        var2_2 = this.a.size();
        var3_3 = 0;
        do {
            var4_4 = null;
            if (var3_3 >= var2_2) ** GOTO lbl9
            var6_5 = (a)this.a.get(var3_3);
            if (StateSet.stateSetMatches((int[])var6_5.a, (int[])var1)) {
                var4_4 = var6_5;
lbl9: // 2 sources:
                if (var4_4 != this.b) break;
                return;
            }
            ++var3_3;
        } while (true);
        if (this.b != null) {
            super.d();
        }
        this.b = var4_4;
        var5_6 = (View)this.d.get();
        if (var4_4 == null) return;
        if (var5_6 == null) return;
        if (var5_6.getVisibility() != 0) return;
        super.a(var4_4);
    }

    public void a(int[] arrn, Animation animation) {
        a a2 = new a(arrn, animation, null);
        animation.setAnimationListener(this.e);
        this.a.add((Object)a2);
    }

    public void b() {
        View view;
        if (this.c != null && (view = this.a()) != null && view.getAnimation() == this.c) {
            view.clearAnimation();
        }
    }

    static class a {
        final int[] a;
        final Animation b;

        private a(int[] arrn, Animation animation) {
            this.a = arrn;
            this.b = animation;
        }

        /* synthetic */ a(int[] arrn, Animation animation,  var3_2) {
            super(arrn, animation);
        }
    }

}

