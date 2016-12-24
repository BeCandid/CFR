/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Fragment
 *  android.app.FragmentManager
 *  android.app.FragmentTransaction
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.Message
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.FragmentActivity
 *  android.support.v4.app.FragmentManager
 *  android.support.v4.app.FragmentTransaction
 *  android.util.Log
 *  com.bumptech.glide.manager.RequestManagerFragment
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 */
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import com.bumptech.glide.manager.RequestManagerFragment;
import java.util.HashMap;
import java.util.Map;

public class pr
implements Handler.Callback {
    private static final pr c = new pr();
    final Map<android.app.FragmentManager, RequestManagerFragment> a = new HashMap();
    final Map<FragmentManager, pu> b = new HashMap();
    private volatile jz d;
    private final Handler e;

    pr() {
        this.e = new Handler(Looper.getMainLooper(), (Handler.Callback)this);
    }

    public static pr a() {
        return c;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private jz b(Context context) {
        if (this.d == null) {
            void var3_2 = this;
            synchronized (var3_2) {
                if (this.d == null) {
                    this.d = new jz(context.getApplicationContext(), new pj(), new pn());
                }
            }
        }
        return this.d;
    }

    @TargetApi(value=17)
    private static void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    @TargetApi(value=17)
    public RequestManagerFragment a(android.app.FragmentManager fragmentManager) {
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment)fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (requestManagerFragment == null && (requestManagerFragment = (RequestManagerFragment)this.a.get((Object)fragmentManager)) == null) {
            requestManagerFragment = new RequestManagerFragment();
            this.a.put((Object)fragmentManager, (Object)requestManagerFragment);
            fragmentManager.beginTransaction().add((android.app.Fragment)requestManagerFragment, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.e.obtainMessage(1, (Object)fragmentManager).sendToTarget();
        }
        return requestManagerFragment;
    }

    @TargetApi(value=11)
    public jz a(Activity activity) {
        if (ri.c() || Build.VERSION.SDK_INT < 11) {
            return this.a(activity.getApplicationContext());
        }
        pr.b(activity);
        return this.a((Context)activity, activity.getFragmentManager());
    }

    public jz a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (ri.b() && !(context instanceof Application)) {
            if (context instanceof FragmentActivity) {
                return this.a((FragmentActivity)context);
            }
            if (context instanceof Activity) {
                return this.a((Activity)context);
            }
            if (context instanceof ContextWrapper) {
                return this.a(((ContextWrapper)context).getBaseContext());
            }
        }
        return super.b(context);
    }

    @TargetApi(value=11)
    jz a(Context context, android.app.FragmentManager fragmentManager) {
        RequestManagerFragment requestManagerFragment = this.a(fragmentManager);
        jz jz2 = requestManagerFragment.b();
        if (jz2 == null) {
            jz2 = new jz(context, requestManagerFragment.a(), requestManagerFragment.c());
            requestManagerFragment.a(jz2);
        }
        return jz2;
    }

    jz a(Context context, FragmentManager fragmentManager) {
        pu pu2 = this.a(fragmentManager);
        jz jz2 = pu2.b();
        if (jz2 == null) {
            jz2 = new jz(context, pu2.a(), pu2.c());
            pu2.a(jz2);
        }
        return jz2;
    }

    public jz a(FragmentActivity fragmentActivity) {
        if (ri.c()) {
            return this.a(fragmentActivity.getApplicationContext());
        }
        pr.b((Activity)fragmentActivity);
        return this.a((Context)fragmentActivity, fragmentActivity.getSupportFragmentManager());
    }

    pu a(FragmentManager fragmentManager) {
        pu pu2 = (pu)fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (pu2 == null && (pu2 = (pu)((Object)this.b.get((Object)fragmentManager))) == null) {
            pu2 = new pu();
            this.b.put((Object)fragmentManager, (Object)pu2);
            fragmentManager.beginTransaction().add((Fragment)pu2, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.e.obtainMessage(2, (Object)fragmentManager).sendToTarget();
        }
        return pu2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean handleMessage(Message message) {
        boolean bl2 = true;
        Object object = null;
        android.app.FragmentManager fragmentManager = null;
        switch (message.what) {
            default: {
                return false;
            }
            case 1: {
                android.app.FragmentManager fragmentManager2;
                fragmentManager = fragmentManager2 = (android.app.FragmentManager)message.obj;
                object = this.a.remove((Object)fragmentManager2);
                break;
            }
            case 2: {
                FragmentManager fragmentManager3;
                fragmentManager = fragmentManager3 = (FragmentManager)message.obj;
                object = this.b.remove((Object)fragmentManager3);
            }
        }
        if (!bl2) return bl2;
        if (object != null) return bl2;
        if (!Log.isLoggable((String)"RMRetriever", (int)5)) return bl2;
        Log.w((String)"RMRetriever", (String)("Failed to remove expected request manager fragment, manager: " + (Object)fragmentManager));
        return bl2;
    }
}

