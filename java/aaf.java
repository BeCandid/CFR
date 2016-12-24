/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  com.google.android.gms.common.GooglePlayServicesUtil
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Iterator
 *  java.util.LinkedList
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class aaf<T extends aae> {
    private T a;
    private Bundle b;
    private LinkedList<a> c;
    private final aai<T> d;

    public aaf() {
        this.d = new aai<T>(){

            @Override
            public void a(T t2) {
                aaf.this.a = t2;
                Iterator iterator = aaf.this.c.iterator();
                while (iterator.hasNext()) {
                    ((a)iterator.next()).a(aaf.this.a);
                }
                aaf.this.c.clear();
                aaf.this.b = null;
            }
        };
    }

    private void a(int n2) {
        while (!this.c.isEmpty() && ((a)this.c.getLast()).a() >= n2) {
            this.c.removeLast();
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(Bundle bundle, a a2) {
        if (this.a != null) {
            a2.a((aae)this.a);
            return;
        }
        if (this.c == null) {
            this.c = new LinkedList();
        }
        this.c.add((Object)a2);
        if (bundle != null) {
            if (this.b == null) {
                this.b = (Bundle)bundle.clone();
            } else {
                this.b.putAll(bundle);
            }
        }
        this.a(this.d);
    }

    public static void b(FrameLayout frameLayout) {
        Context context = frameLayout.getContext();
        final int n2 = GooglePlayServicesUtil.isGooglePlayServicesAvailable((Context)context);
        String string2 = ym.a(context, n2, GooglePlayServicesUtil.zzam((Context)context));
        String string3 = ym.c(context, n2);
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView((View)linearLayout);
        TextView textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
        textView.setText((CharSequence)string2);
        linearLayout.addView((View)textView);
        if (string3 != null) {
            Button button = new Button(context);
            button.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
            button.setText((CharSequence)string3);
            linearLayout.addView((View)button);
            button.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    Context.this.startActivity(GooglePlayServicesUtil.zzbC((int)n2));
                }
            });
        }
    }

    public View a(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final Bundle bundle) {
        final FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        super.a(bundle, new a(){

            @Override
            public int a() {
                return 2;
            }

            @Override
            public void a(aae aae2) {
                frameLayout.removeAllViews();
                frameLayout.addView(aaf.this.a.a(layoutInflater, viewGroup, bundle));
            }
        });
        if (this.a == null) {
            this.a(frameLayout);
        }
        return frameLayout;
    }

    public void a() {
        this.a(null, new a(){

            @Override
            public int a() {
                return 5;
            }

            @Override
            public void a(aae aae2) {
                aaf.this.a.a();
            }
        });
    }

    public abstract void a(aai<T> var1);

    public void a(final Activity activity, final Bundle bundle, final Bundle bundle2) {
        super.a(bundle2, new a(){

            @Override
            public int a() {
                return 0;
            }

            @Override
            public void a(aae aae2) {
                aaf.this.a.a(activity, bundle, bundle2);
            }
        });
    }

    public void a(final Bundle bundle) {
        super.a(bundle, new a(){

            @Override
            public int a() {
                return 1;
            }

            @Override
            public void a(aae aae2) {
                aaf.this.a.a(bundle);
            }
        });
    }

    protected void a(FrameLayout frameLayout) {
        aaf.b(frameLayout);
    }

    public void b() {
        if (this.a != null) {
            this.a.b();
            return;
        }
        this.a(5);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void b(Bundle bundle) {
        if (this.a != null) {
            this.a.b(bundle);
            return;
        } else {
            if (this.b == null) return;
            {
                bundle.putAll(this.b);
                return;
            }
        }
    }

    public void c() {
        if (this.a != null) {
            this.a.c();
            return;
        }
        this.a(2);
    }

    public void d() {
        if (this.a != null) {
            this.a.d();
            return;
        }
        this.a(1);
    }

    public void e() {
        if (this.a != null) {
            this.a.e();
        }
    }

    static interface a {
        public int a();

        public void a(aae var1);
    }

}

