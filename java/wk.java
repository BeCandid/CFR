/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ComponentName
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.FragmentActivity
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  java.lang.ClassLoader
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONException
 *  org.json.JSONObject
 */
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.login.CustomTabLoginMethodHandler;
import com.facebook.login.LoginClient;
import com.facebook.login.LoginMethodHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class wk
extends Fragment {
    private String a;
    private LoginClient b;
    private LoginClient.Request c;
    private boolean d;
    private String e;

    private void a(Activity activity) {
        ComponentName componentName = activity.getCallingActivity();
        if (componentName == null) {
            return;
        }
        this.a = componentName.getPackageName();
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(LoginClient.Result result) {
        this.c = null;
        int n2 = result.a == LoginClient.Result.Code.b ? 0 : -1;
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.facebook.LoginFragment:Result", (Parcelable)result);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        if (this.isAdded()) {
            this.getActivity().setResult(n2, intent);
            this.getActivity().finish();
        }
    }

    public String a() {
        return this.e;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean a(Bundle bundle) {
        try {
            String string2 = bundle.getString("state");
            if (string2 != null) return new JSONObject(string2).getString("7_challenge").equals((Object)this.e);
            return false;
        }
        catch (JSONException var2_4) {
            return false;
        }
    }

    public LoginClient b() {
        return this.b;
    }

    public void onActivityResult(int n2, int n3, Intent intent) {
        super.onActivityResult(n2, n3, intent);
        this.b.a(n2, n3, intent);
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        boolean bl2 = bundle != null;
        this.d = bl2;
        if (bundle != null) {
            this.b = (LoginClient)bundle.getParcelable("loginClient");
            this.b.a((Fragment)this);
            this.e = bundle.getString("challenge");
        } else {
            this.b = new LoginClient((Fragment)this);
            this.e = we.a(20);
        }
        this.b.a(new LoginClient.b(){

            @Override
            public void a(LoginClient.Result result) {
                wk.this.a(result);
            }
        });
        FragmentActivity fragmentActivity = this.getActivity();
        if (fragmentActivity == null) {
            return;
        }
        super.a((Activity)fragmentActivity);
        if (fragmentActivity.getIntent() == null) return;
        Intent intent = fragmentActivity.getIntent();
        intent.setExtrasClassLoader(LoginClient.Request.class.getClassLoader());
        this.c = (LoginClient.Request)intent.getParcelableExtra("request");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final View view = layoutInflater.inflate(uu.e.com_facebook_login_fragment, viewGroup, false);
        this.b.a(new LoginClient.a(){

            @Override
            public void a() {
                view.findViewById(uu.d.com_facebook_login_activity_progress_bar).setVisibility(0);
            }

            @Override
            public void b() {
                view.findViewById(uu.d.com_facebook_login_activity_progress_bar).setVisibility(8);
            }
        });
        return view;
    }

    public void onDestroy() {
        this.b.f();
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        this.getActivity().findViewById(uu.d.com_facebook_login_activity_progress_bar).setVisibility(8);
    }

    public void onResume() {
        FragmentActivity fragmentActivity;
        super.onResume();
        if (this.a == null) {
            Log.e((String)"LoginFragment", (String)"Cannot call LoginFragment with a null calling package. This can occur if the launchMode of the caller is singleInstance.");
            this.getActivity().finish();
            return;
        }
        if (this.d && (fragmentActivity = this.getActivity()) instanceof FacebookActivity && this.b.g() instanceof CustomTabLoginMethodHandler) {
            ((FacebookActivity)fragmentActivity).a(null, new FacebookOperationCanceledException());
        }
        this.d = true;
        this.b.a(this.c);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("loginClient", (Parcelable)this.b);
        bundle.putString("challenge", this.e);
    }

}

