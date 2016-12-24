/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.FragmentActivity
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.facebook.login;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.login.CustomTabLoginMethodHandler;
import com.facebook.login.DefaultAudience;
import com.facebook.login.DeviceAuthMethodHandler;
import com.facebook.login.GetTokenLoginMethodHandler;
import com.facebook.login.KatanaProxyLoginMethodHandler;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginMethodHandler;
import com.facebook.login.WebViewLoginMethodHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginClient
implements Parcelable {
    public static final Parcelable.Creator<LoginClient> CREATOR = new Parcelable.Creator(){

        public LoginClient a(Parcel parcel) {
            return new LoginClient(parcel);
        }

        public LoginClient[] a(int n2) {
            return new LoginClient[n2];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.a(parcel);
        }

        public /* synthetic */ Object[] newArray(int n2) {
            return this.a(n2);
        }
    };
    LoginMethodHandler[] a;
    int b = -1;
    Fragment c;
    b d;
    a e;
    boolean f;
    Request g;
    Map<String, String> h;
    private wl i;

    public LoginClient(Parcel parcel) {
        Parcelable[] arrparcelable = parcel.readParcelableArray(LoginMethodHandler.class.getClassLoader());
        this.a = new LoginMethodHandler[arrparcelable.length];
        for (int i2 = 0; i2 < arrparcelable.length; ++i2) {
            this.a[i2] = (LoginMethodHandler)arrparcelable[i2];
            this.a[i2].a((LoginClient)this);
        }
        this.b = parcel.readInt();
        this.g = (Request)parcel.readParcelable(Request.class.getClassLoader());
        this.h = we.a(parcel);
    }

    public LoginClient(Fragment fragment) {
        this.c = fragment;
    }

    private void a(String string2, Result result, Map<String, String> map) {
        super.a(string2, result.a.a(), result.c, result.d, map);
    }

    private void a(String string2, String string3, String string4, String string5, Map<String, String> map) {
        if (this.g == null) {
            this.o().a("fb_mobile_login_method_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", string2);
            return;
        }
        this.o().a(this.g.e(), string2, string3, string4, string5, map);
    }

    private void a(String string2, String string3, boolean bl2) {
        if (this.h == null) {
            this.h = new HashMap();
        }
        if (this.h.containsKey((Object)string2) && bl2) {
            string3 = (String)this.h.get((Object)string2) + "," + string3;
        }
        this.h.put((Object)string2, (Object)string3);
    }

    private LoginMethodHandler[] c(Request request) {
        ArrayList arrayList = new ArrayList();
        LoginBehavior loginBehavior = request.b();
        if (loginBehavior.a()) {
            arrayList.add((Object)new GetTokenLoginMethodHandler((LoginClient)this));
            arrayList.add((Object)new KatanaProxyLoginMethodHandler((LoginClient)this));
        }
        if (loginBehavior.b()) {
            arrayList.add((Object)new CustomTabLoginMethodHandler((LoginClient)this));
            arrayList.add((Object)new WebViewLoginMethodHandler((LoginClient)this));
        }
        if (loginBehavior.c()) {
            arrayList.add((Object)new DeviceAuthMethodHandler((LoginClient)this));
        }
        Object[] arrobject = new LoginMethodHandler[arrayList.size()];
        arrayList.toArray(arrobject);
        return arrobject;
    }

    public static int d() {
        return CallbackManagerImpl.RequestCodeOffset.a.a();
    }

    private void d(Result result) {
        if (this.d != null) {
            this.d.a(result);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static String m() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("init", System.currentTimeMillis());
        }
        catch (JSONException var1_1) {
            return jSONObject.toString();
        }
        do {
            return jSONObject.toString();
            break;
        } while (true);
    }

    private void n() {
        this.b(Result.a(this.g, "Login attempt failed.", null));
    }

    private wl o() {
        if (this.i == null || !this.i.a().equals((Object)this.g.d())) {
            this.i = new wl((Context)this.b(), this.g.d());
        }
        return this.i;
    }

    int a(String string2) {
        return this.b().checkCallingOrSelfPermission(string2);
    }

    public Fragment a() {
        return this.c;
    }

    public void a(Fragment fragment) {
        if (this.c != null) {
            throw new FacebookException("Can't set fragment once it is already set.");
        }
        this.c = fragment;
    }

    public void a(Request request) {
        if (!this.e()) {
            this.b(request);
        }
    }

    void a(Result result) {
        if (result.b != null && AccessToken.a() != null) {
            this.c(result);
            return;
        }
        this.b(result);
    }

    public void a(a a2) {
        this.e = a2;
    }

    public void a(b b2) {
        this.d = b2;
    }

    public boolean a(int n2, int n3, Intent intent) {
        if (this.g != null) {
            return this.g().a(n2, n3, intent);
        }
        return false;
    }

    FragmentActivity b() {
        return this.c.getActivity();
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    void b(Request request) {
        if (request == null) {
            return;
        }
        if (this.g != null) {
            throw new FacebookException("Attempted to authorize while a request is pending.");
        }
        if (AccessToken.a() != null) {
            if (!this.h()) return;
        }
        this.g = request;
        this.a = super.c(request);
        this.i();
    }

    void b(Result result) {
        LoginMethodHandler loginMethodHandler = this.g();
        if (loginMethodHandler != null) {
            super.a(loginMethodHandler.a(), result, loginMethodHandler.a);
        }
        if (this.h != null) {
            result.f = this.h;
        }
        this.a = null;
        this.b = -1;
        this.g = null;
        this.h = null;
        super.d(result);
    }

    public Request c() {
        return this.g;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    void c(Result var1) {
        if (var1.b == null) {
            throw new FacebookException("Can't validate without a token");
        }
        var2_2 = AccessToken.a();
        var3_3 = var1.b;
        if (var2_2 == null || var3_3 == null) ** GOTO lbl-1000
        try {
            if (var2_2.i().equals((Object)var3_3.i())) {
                var6_4 = Result.a(this.g, var1.b);
            } else lbl-1000: // 2 sources:
            {
                var6_4 = var5_5 = Result.a(this.g, "User logged in as different Facebook user.", null);
            }
            this.b(var6_4);
            return;
        }
        catch (Exception var4_6) {
            this.b(Result.a(this.g, "Caught exception", var4_6.getMessage()));
            return;
        }
    }

    public int describeContents() {
        return 0;
    }

    boolean e() {
        if (this.g != null && this.b >= 0) {
            return true;
        }
        return false;
    }

    public void f() {
        if (this.b >= 0) {
            this.g().b();
        }
    }

    public LoginMethodHandler g() {
        if (this.b >= 0) {
            return this.a[this.b];
        }
        return null;
    }

    boolean h() {
        if (this.f) {
            return true;
        }
        if (this.a("android.permission.INTERNET") != 0) {
            FragmentActivity fragmentActivity = this.b();
            String string2 = fragmentActivity.getString(uu.f.com_facebook_internet_permission_error_title);
            String string3 = fragmentActivity.getString(uu.f.com_facebook_internet_permission_error_message);
            this.b(Result.a(this.g, string2, string3));
            return false;
        }
        this.f = true;
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    void i() {
        if (this.b >= 0) {
            this.a(this.g().a(), "skipped", null, null, this.g().a);
        }
        while (this.a != null && this.b < -1 + this.a.length) {
            this.b = 1 + this.b;
            if (!this.j()) continue;
            return;
        }
        if (this.g == null) {
            return;
        }
        this.n();
    }

    boolean j() {
        LoginMethodHandler loginMethodHandler = this.g();
        if (loginMethodHandler.d() && !this.h()) {
            this.a("no_internet_permission", "1", false);
            return false;
        }
        boolean bl2 = loginMethodHandler.a(this.g);
        if (bl2) {
            this.o().a(this.g.e(), loginMethodHandler.a());
            return bl2;
        }
        this.a("not_tried", loginMethodHandler.a(), true);
        return bl2;
    }

    void k() {
        if (this.e != null) {
            this.e.a();
        }
    }

    void l() {
        if (this.e != null) {
            this.e.b();
        }
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeParcelableArray(this.a, n2);
        parcel.writeInt(this.b);
        parcel.writeParcelable((Parcelable)this.g, n2);
        we.a(parcel, this.h);
    }

    public static class Request
    implements Parcelable {
        public static final Parcelable.Creator<Request> CREATOR = new Parcelable.Creator(){

            public Request a(Parcel parcel) {
                return new Request(parcel, null);
            }

            public Request[] a(int n2) {
                return new Request[n2];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return this.a(parcel);
            }

            public /* synthetic */ Object[] newArray(int n2) {
                return this.a(n2);
            }
        };
        private final LoginBehavior a;
        private Set<String> b;
        private final DefaultAudience c;
        private final String d;
        private final String e;
        private boolean f;
        private String g;

        /*
         * Enabled aggressive block sorting
         */
        private Request(Parcel parcel) {
            this.f = false;
            String string2 = parcel.readString();
            LoginBehavior loginBehavior = string2 != null ? LoginBehavior.valueOf(string2) : null;
            this.a = loginBehavior;
            ArrayList arrayList = new ArrayList();
            parcel.readStringList((List)arrayList);
            this.b = new HashSet((Collection)arrayList);
            String string3 = parcel.readString();
            DefaultAudience defaultAudience = null;
            if (string3 != null) {
                defaultAudience = DefaultAudience.valueOf(string3);
            }
            this.c = defaultAudience;
            this.d = parcel.readString();
            this.e = parcel.readString();
            boolean bl2 = parcel.readByte() != 0;
            this.f = bl2;
            this.g = parcel.readString();
        }

        /* synthetic */ Request(Parcel parcel, com.facebook.login.LoginClient$1 var2_2) {
            super(parcel);
        }

        /*
         * Enabled aggressive block sorting
         */
        public Request(LoginBehavior loginBehavior, Set<String> hashSet, DefaultAudience defaultAudience, String string2, String string3) {
            this.f = false;
            this.a = loginBehavior;
            if (hashSet == null) {
                hashSet = new HashSet();
            }
            this.b = hashSet;
            this.c = defaultAudience;
            this.d = string2;
            this.e = string3;
        }

        public Set<String> a() {
            return this.b;
        }

        public void a(String string2) {
            this.g = string2;
        }

        void a(Set<String> set) {
            wf.a(set, "permissions");
            this.b = set;
        }

        public void a(boolean bl2) {
            this.f = bl2;
        }

        public LoginBehavior b() {
            return this.a;
        }

        public DefaultAudience c() {
            return this.c;
        }

        public String d() {
            return this.d;
        }

        public int describeContents() {
            return 0;
        }

        public String e() {
            return this.e;
        }

        public boolean f() {
            return this.f;
        }

        String g() {
            return this.g;
        }

        boolean h() {
            Iterator iterator = this.b.iterator();
            while (iterator.hasNext()) {
                if (!wm.a((String)iterator.next())) continue;
                return true;
            }
            return false;
        }

        /*
         * Enabled aggressive block sorting
         */
        public void writeToParcel(Parcel parcel, int n2) {
            String string2 = this.a != null ? this.a.name() : null;
            parcel.writeString(string2);
            parcel.writeStringList((List)new ArrayList(this.b));
            DefaultAudience defaultAudience = this.c;
            String string3 = null;
            if (defaultAudience != null) {
                string3 = this.c.name();
            }
            parcel.writeString(string3);
            parcel.writeString(this.d);
            parcel.writeString(this.e);
            byte by2 = this.f ? 1 : 0;
            parcel.writeByte(by2);
            parcel.writeString(this.g);
        }

    }

    public static class Result
    implements Parcelable {
        public static final Parcelable.Creator<Result> CREATOR = new Parcelable.Creator(){

            public Result a(Parcel parcel) {
                return new Result(parcel, null);
            }

            public Result[] a(int n2) {
                return new Result[n2];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return this.a(parcel);
            }

            public /* synthetic */ Object[] newArray(int n2) {
                return this.a(n2);
            }
        };
        public final Code a;
        public final AccessToken b;
        public final String c;
        final String d;
        public final Request e;
        public Map<String, String> f;

        private Result(Parcel parcel) {
            this.a = Code.valueOf(parcel.readString());
            this.b = (AccessToken)parcel.readParcelable(AccessToken.class.getClassLoader());
            this.c = parcel.readString();
            this.d = parcel.readString();
            this.e = (Request)parcel.readParcelable(Request.class.getClassLoader());
            this.f = we.a(parcel);
        }

        /* synthetic */ Result(Parcel parcel, com.facebook.login.LoginClient$1 var2_2) {
            super(parcel);
        }

        Result(Request request, Code code, AccessToken accessToken, String string2, String string3) {
            wf.a((Object)code, "code");
            this.e = request;
            this.b = accessToken;
            this.c = string2;
            this.a = code;
            this.d = string3;
        }

        public static Result a(Request request, AccessToken accessToken) {
            return new Result(request, Code.a, accessToken, null, null);
        }

        static Result a(Request request, String string2) {
            return new Result(request, Code.b, null, string2, null);
        }

        static Result a(Request request, String string2, String string3) {
            return Result.a(request, string2, string3, null);
        }

        static Result a(Request request, String string2, String string3, String string4) {
            String string5 = TextUtils.join((CharSequence)": ", we.b(new String[]{string2, string3}));
            return new Result(request, Code.c, null, string5, string4);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int n2) {
            parcel.writeString(this.a.name());
            parcel.writeParcelable((Parcelable)this.b, n2);
            parcel.writeString(this.c);
            parcel.writeString(this.d);
            parcel.writeParcelable((Parcelable)this.e, n2);
            we.a(parcel, this.f);
        }

        public static final class Code
        extends Enum<Code> {
            public static final /* enum */ Code a = new Code("success");
            public static final /* enum */ Code b = new Code("cancel");
            public static final /* enum */ Code c = new Code("error");
            private static final /* synthetic */ Code[] e;
            private final String d;

            static {
                Code[] arrcode = new Code[]{a, b, c};
                e = arrcode;
            }

            private Code(String string3) {
                super(string2, n2);
                this.d = string3;
            }

            public static Code valueOf(String string2) {
                return (Code)Enum.valueOf((Class)Code.class, (String)string2);
            }

            public static Code[] values() {
                return (Code[])e.clone();
            }

            public String a() {
                return this.d;
            }
        }

    }

    public static interface a {
        public void a();

        public void b();
    }

    public static interface b {
        public void a(Result var1);
    }

}

