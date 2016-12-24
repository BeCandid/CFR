/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Fragment
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.support.v4.app.Fragment
 *  com.facebook.login.LoginManager
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Set
 *  java.util.UUID
 */
import android.app.Activity;
import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookActivity;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginClient;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginMethodHandler;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class wm {
    private static final Set<String> a = wm.a();
    private static volatile wm b;
    private LoginBehavior c = LoginBehavior.a;
    private DefaultAudience d = DefaultAudience.c;

    wm() {
        wf.a();
    }

    private Intent a(LoginClient.Request request) {
        Intent intent = new Intent();
        intent.setClass(ul.f(), (Class)FacebookActivity.class);
        intent.setAction(request.b().toString());
        Bundle bundle = new Bundle();
        bundle.putParcelable("request", (Parcelable)request);
        intent.putExtras(bundle);
        return intent;
    }

    private static Set<String> a() {
        return Collections.unmodifiableSet((Set)new HashSet<String>(){});
    }

    static wn a(LoginClient.Request request, AccessToken accessToken) {
        Set<String> set = request.a();
        HashSet hashSet = new HashSet(accessToken.d());
        if (request.f()) {
            hashSet.retainAll(set);
        }
        HashSet hashSet2 = new HashSet(set);
        hashSet2.removeAll((Collection)hashSet);
        return new wn(accessToken, (Set<String>)hashSet, (Set<String>)hashSet2);
    }

    private void a(Context context, LoginClient.Request request) {
        wl wl2 = c.b(context);
        if (wl2 != null && request != null) {
            wl2.a(request);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(Context context, LoginClient.Result.Code code, Map<String, String> map, Exception exception, boolean bl2, LoginClient.Request request) {
        wl wl2 = c.b(context);
        if (wl2 == null) {
            return;
        }
        if (request == null) {
            wl2.b("fb_mobile_login_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.");
            return;
        }
        HashMap hashMap = new HashMap();
        String string2 = bl2 ? "1" : "0";
        hashMap.put((Object)"try_login_activity", (Object)string2);
        wl2.a(request.e(), (Map<String, String>)hashMap, code, map, exception);
    }

    public static void a(Intent intent, Bundle bundle) {
        LoginClient.Request request = (LoginClient.Request)intent.getExtras().getParcelable("request");
        intent.putExtra("com.facebook.LoginFragment:Result", (Parcelable)LoginClient.Result.a(request, LoginMethodHandler.a(request.a(), bundle, AccessTokenSource.f, request.d())));
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(AccessToken accessToken, LoginClient.Request request, FacebookException facebookException, boolean bl2, uk<wn> uk2) {
        if (accessToken != null) {
            AccessToken.a(accessToken);
            Profile.b();
        }
        if (uk2 == null) return;
        {
            wn wn2 = accessToken != null ? wm.a(request, accessToken) : null;
            if (bl2 || wn2 != null && wn2.b().size() == 0) {
                uk2.onCancel();
                return;
            } else {
                if (facebookException != null) {
                    uk2.onError(facebookException);
                    return;
                }
                if (accessToken == null) return;
                {
                    uk2.onSuccess(wn2);
                    return;
                }
            }
        }
    }

    private void a(vq vq2, Collection<String> collection) {
        super.b(collection);
        LoginClient.Request request = this.a(collection);
        super.a(new b(vq2), request);
    }

    private void a(wo wo2, LoginClient.Request request) throws FacebookException {
        super.a((Context)wo2.a(), request);
        CallbackManagerImpl.a(CallbackManagerImpl.RequestCodeOffset.a.a(), new CallbackManagerImpl.a(){

            @Override
            public boolean a(int n2, Intent intent) {
                return wm.this.a(n2, intent);
            }
        });
        if (!super.b(wo2, request)) {
            FacebookException facebookException = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
            super.a((Context)wo2.a(), LoginClient.Result.Code.c, null, (Exception)facebookException, false, request);
            throw facebookException;
        }
    }

    private boolean a(Intent intent) {
        if (ul.f().getPackageManager().resolveActivity(intent, 0) == null) {
            return false;
        }
        return true;
    }

    public static boolean a(String string2) {
        if (string2 != null && (string2.startsWith("publish") || string2.startsWith("manage") || a.contains((Object)string2))) {
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void b(Collection<String> collection) {
        String string2;
        if (collection == null) {
            return;
        }
        Iterator iterator = collection.iterator();
        do {
            if (!iterator.hasNext()) return;
        } while (!wm.a(string2 = (String)iterator.next()));
        throw new FacebookException(String.format((String)"Cannot pass a publish or manage permission (%s) to a request for read authorization", (Object[])new Object[]{string2}));
    }

    private void b(vq vq2, Collection<String> collection) {
        super.c(collection);
        LoginClient.Request request = this.a(collection);
        super.a(new b(vq2), request);
    }

    private boolean b(wo wo2, LoginClient.Request request) {
        Intent intent = super.a(request);
        if (!super.a(intent)) {
            return false;
        }
        try {
            wo2.a(intent, LoginClient.d());
            return true;
        }
        catch (ActivityNotFoundException var4_4) {
            return false;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static wm c() {
        if (b != null) return b;
        reference var1 = wm.class;
        // MONITORENTER : wm.class
        if (b == null) {
            b = new wm();
        }
        // MONITOREXIT : var1
        return b;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void c(Collection<String> collection) {
        String string2;
        if (collection == null) {
            return;
        }
        Iterator iterator = collection.iterator();
        do {
            if (!iterator.hasNext()) return;
        } while (wm.a(string2 = (String)iterator.next()));
        throw new FacebookException(String.format((String)"Cannot pass a read permission (%s) to a request for publish authorization", (Object[])new Object[]{string2}));
    }

    /*
     * Enabled aggressive block sorting
     */
    protected LoginClient.Request a(Collection<String> collection) {
        LoginBehavior loginBehavior = this.c;
        HashSet hashSet = collection != null ? new HashSet(collection) : new HashSet();
        LoginClient.Request request = new LoginClient.Request(loginBehavior, Collections.unmodifiableSet((Set)hashSet), this.d, ul.i(), UUID.randomUUID().toString());
        boolean bl2 = AccessToken.a() != null;
        request.a(bl2);
        return request;
    }

    public wm a(DefaultAudience defaultAudience) {
        this.d = defaultAudience;
        return this;
    }

    public wm a(LoginBehavior loginBehavior) {
        this.c = loginBehavior;
        return this;
    }

    public void a(Activity activity, Collection<String> collection) {
        super.b(collection);
        LoginClient.Request request = this.a(collection);
        super.a(new a(activity), request);
    }

    public void a(Fragment fragment, Collection<String> collection) {
        super.a(new vq(fragment), collection);
    }

    public void a(android.support.v4.app.Fragment fragment, Collection<String> collection) {
        super.a(new vq(fragment), collection);
    }

    public void a(uj uj2, final uk<wn> uk2) {
        if (!(uj2 instanceof CallbackManagerImpl)) {
            throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
        }
        ((CallbackManagerImpl)uj2).b(CallbackManagerImpl.RequestCodeOffset.a.a(), new CallbackManagerImpl.a(){

            @Override
            public boolean a(int n2, Intent intent) {
                return wm.this.a(n2, intent, uk2);
            }
        });
    }

    boolean a(int n2, Intent intent) {
        return this.a(n2, intent, null);
    }

    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    boolean a(int var1, Intent var2_3, uk<wn> var3_2) {
        var4_4 = LoginClient.Result.Code.c;
        if (var2_3 == null) ** GOTO lbl36
        var10_5 = (LoginClient.Result)var2_3.getParcelableExtra("com.facebook.LoginFragment:Result");
        var5_6 = null;
        var6_7 = null;
        var7_8 = null;
        var8_9 = null;
        var9_10 = false;
        if (var10_5 == null) ** GOTO lbl19
        var7_8 = var10_5.e;
        var4_4 = var10_5.a;
        if (var1 != -1) ** GOTO lbl28
        if (var10_5.a != LoginClient.Result.Code.a) ** GOTO lbl24
        var8_9 = var10_5.b;
lbl15: // 4 sources:
        do {
            var5_6 = var10_5.f;
lbl17: // 2 sources:
            do {
                if (var6_7 != null || var8_9 != null || var9_10) ** GOTO lbl21
lbl19: // 3 sources:
                do {
                    var6_7 = new FacebookException("Unexpected call to LoginManager.onActivityResult");
lbl21: // 2 sources:
                    super.a(null, var4_4, var5_6, (Exception)var6_7, true, var7_8);
                    super.a(var8_9, var7_8, var6_7, var9_10, var3_2);
                    return true;
                    break;
                } while (true);
                break;
            } while (true);
            break;
        } while (true);
lbl24: // 1 sources:
        var6_7 = new FacebookAuthorizationException(var10_5.c);
        var8_9 = null;
        var9_10 = false;
        ** GOTO lbl15
lbl28: // 1 sources:
        var6_7 = null;
        var8_9 = null;
        var9_10 = false;
        if (var1 != 0) ** GOTO lbl15
        var9_10 = true;
        var6_7 = null;
        var8_9 = null;
        ** while (true)
lbl36: // 1 sources:
        var5_6 = null;
        var6_7 = null;
        var7_8 = null;
        var8_9 = null;
        var9_10 = false;
        ** while (var1 != 0)
lbl42: // 1 sources:
        var9_10 = true;
        var4_4 = LoginClient.Result.Code.b;
        var5_6 = null;
        var6_7 = null;
        var7_8 = null;
        var8_9 = null;
        ** while (true)
    }

    public void b(Activity activity, Collection<String> collection) {
        super.c(collection);
        LoginClient.Request request = this.a(collection);
        super.a(new a(activity), request);
    }

    public void b(Fragment fragment, Collection<String> collection) {
        super.b(new vq(fragment), collection);
    }

    public void b(android.support.v4.app.Fragment fragment, Collection<String> collection) {
        super.b(new vq(fragment), collection);
    }

    public void d() {
        AccessToken.a(null);
        Profile.a(null);
    }

    static class a
    implements wo {
        private final Activity a;

        a(Activity activity) {
            wf.a((Object)activity, "activity");
            this.a = activity;
        }

        @Override
        public Activity a() {
            return this.a;
        }

        @Override
        public void a(Intent intent, int n2) {
            this.a.startActivityForResult(intent, n2);
        }
    }

    static class b
    implements wo {
        private final vq a;

        b(vq vq2) {
            wf.a(vq2, "fragment");
            this.a = vq2;
        }

        @Override
        public Activity a() {
            return this.a.c();
        }

        @Override
        public void a(Intent intent, int n2) {
            this.a.a(intent, n2);
        }
    }

    static class c {
        private static volatile wl a;

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        private static wl b(Context context) {
            reference var3_1 = c.class;
            synchronized (c.class) {
                if (context == null) {
                    context = ul.f();
                }
                if (context == null) {
                    return null;
                }
                if (a != null) return a;
                a = new wl(context, ul.i());
                return a;
            }
        }
    }

}

