/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.graphics.Point
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.Display
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnPreDrawListener
 *  android.view.WindowManager
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class qz<T extends View, Z>
extends qp<Z> {
    private static boolean a = false;
    private static Integer b = null;
    private final a c;
    public final T view;

    public qz(T t2) {
        if (t2 == null) {
            throw new NullPointerException("View must not be null!");
        }
        this.view = t2;
        this.c = new a((View)t2);
    }

    private Object a() {
        if (b == null) {
            return this.view.getTag();
        }
        return this.view.getTag(b.intValue());
    }

    private void a(Object object) {
        if (b == null) {
            a = true;
            this.view.setTag(object);
            return;
        }
        this.view.setTag(b.intValue(), object);
    }

    public static void setTagId(int n2) {
        if (b != null || a) {
            throw new IllegalArgumentException("You cannot set the tag id more than once or change the tag id after the first request has been made");
        }
        b = n2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public qd getRequest() {
        Object object = this.a();
        qd qd2 = null;
        if (object == null) return qd2;
        if (!(object instanceof qd)) throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
        return (qd)object;
    }

    @Override
    public void getSize(qw qw2) {
        this.c.a(qw2);
    }

    public T getView() {
        return this.view;
    }

    @Override
    public void setRequest(qd qd2) {
        super.a(qd2);
    }

    public String toString() {
        return "Target for: " + this.view;
    }

    static class qz$a {
        private final View a;
        private final List<qw> b = new ArrayList();
        private a c;
        private Point d;

        public qz$a(View view) {
            this.a = view;
        }

        private int a(int n2, boolean bl2) {
            if (n2 == -2) {
                Point point = super.d();
                if (bl2) {
                    return point.y;
                }
                return point.x;
            }
            return n2;
        }

        /*
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        private void a() {
            if (this.b.isEmpty()) {
                return;
            }
            int n2 = this.c();
            int n3 = this.b();
            if (!this.a(n2)) return;
            if (!this.a(n3)) return;
            this.a(n2, n3);
            ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this.c);
            }
            this.c = null;
        }

        private void a(int n2, int n3) {
            Iterator iterator = this.b.iterator();
            while (iterator.hasNext()) {
                ((qw)iterator.next()).a(n2, n3);
            }
            this.b.clear();
        }

        private boolean a(int n2) {
            if (n2 > 0 || n2 == -2) {
                return true;
            }
            return false;
        }

        private int b() {
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            if (this.a(this.a.getHeight())) {
                return this.a.getHeight();
            }
            if (layoutParams != null) {
                return this.a(layoutParams.height, true);
            }
            return 0;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        private int c() {
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            if (this.a(this.a.getWidth())) {
                return this.a.getWidth();
            }
            int n2 = 0;
            if (layoutParams == null) return n2;
            return this.a(layoutParams.width, false);
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @TargetApi(value=13)
        private Point d() {
            if (this.d != null) {
                return this.d;
            }
            Display display = ((WindowManager)this.a.getContext().getSystemService("window")).getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 13) {
                this.d = new Point();
                display.getSize(this.d);
                do {
                    return this.d;
                    break;
                } while (true);
            }
            this.d = new Point(display.getWidth(), display.getHeight());
            return this.d;
        }

        /*
         * Enabled aggressive block sorting
         */
        public void a(qw qw2) {
            int n2 = super.c();
            int n3 = super.b();
            if (super.a(n2) && super.a(n3)) {
                qw2.a(n2, n3);
                return;
            } else {
                if (!this.b.contains((Object)qw2)) {
                    this.b.add((Object)qw2);
                }
                if (this.c != null) return;
                {
                    ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
                    this.c = new a((qz$a)this);
                    viewTreeObserver.addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this.c);
                    return;
                }
            }
        }

        static class a
        implements ViewTreeObserver.OnPreDrawListener {
            private final WeakReference<qz$a> a;

            public a(qz$a a2) {
                this.a = new WeakReference((Object)a2);
            }

            public boolean onPreDraw() {
                qz$a a2;
                if (Log.isLoggable((String)"ViewTarget", (int)2)) {
                    Log.v((String)"ViewTarget", (String)("OnGlobalLayoutListener called listener=" + this));
                }
                if ((a2 = (qz$a)this.a.get()) != null) {
                    a2.a();
                }
                return true;
            }
        }

    }

}

