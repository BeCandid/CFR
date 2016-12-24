/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.support.v4.app.DialogFragment
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.FragmentActivity
 *  android.text.Html
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.ProgressBar
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Collection
 *  java.util.Date
 *  java.util.List
 *  java.util.Set
 *  java.util.concurrent.ScheduledFuture
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicBoolean
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.facebook.login;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.login.DeviceAuthMethodHandler;
import com.facebook.login.LoginClient;
import com.facebook.login.LoginMethodHandler;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceAuthDialog
extends DialogFragment {
    private ProgressBar a;
    private TextView b;
    private DeviceAuthMethodHandler c;
    private AtomicBoolean d = new AtomicBoolean();
    private volatile um e;
    private volatile ScheduledFuture f;
    private volatile RequestState g;
    private Dialog h;
    private boolean i = false;

    private void a() {
        this.g.b(new Date().getTime());
        this.e = this.c().j();
    }

    private void a(FacebookException facebookException) {
        if (!this.d.compareAndSet(false, true)) {
            return;
        }
        this.c.a((Exception)facebookException);
        this.h.dismiss();
    }

    private void a(RequestState requestState) {
        this.g = requestState;
        this.b.setText((CharSequence)requestState.a());
        this.b.setVisibility(0);
        this.a.setVisibility(8);
        if (requestState.d()) {
            super.b();
            return;
        }
        super.a();
    }

    private void a(final String string2) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id,permissions");
        new GraphRequest(new AccessToken(string2, ul.i(), "0", null, null, null, null, null), "me", bundle, HttpMethod.a, new GraphRequest.b(){

            @Override
            public void onCompleted(uo uo2) {
                String string22;
                we.e e2;
                if (DeviceAuthDialog.this.d.get()) {
                    return;
                }
                if (uo2.a() != null) {
                    DeviceAuthDialog.this.a(uo2.a().g());
                    return;
                }
                try {
                    JSONObject jSONObject = uo2.b();
                    string22 = jSONObject.getString("id");
                    e2 = we.a(jSONObject);
                }
                catch (JSONException var2_5) {
                    DeviceAuthDialog.this.a(new FacebookException((Throwable)var2_5));
                    return;
                }
                DeviceAuthDialog.this.c.a(string2, ul.i(), string22, (Collection<String>)e2.a(), (Collection<String>)e2.b(), AccessTokenSource.i, null, null);
                DeviceAuthDialog.this.h.dismiss();
            }
        }).j();
    }

    private void b() {
        this.f = DeviceAuthMethodHandler.c().schedule(new Runnable(){

            public void run() {
                DeviceAuthDialog.this.a();
            }
        }, this.g.c(), TimeUnit.SECONDS);
    }

    private GraphRequest c() {
        Bundle bundle = new Bundle();
        bundle.putString("code", this.g.b());
        return new GraphRequest(null, "device/login_status", bundle, HttpMethod.b, new GraphRequest.b(){

            @Override
            public void onCompleted(uo uo2) {
                if (DeviceAuthDialog.this.d.get()) {
                    return;
                }
                FacebookRequestError facebookRequestError = uo2.a();
                if (facebookRequestError != null) {
                    switch (facebookRequestError.c()) {
                        default: {
                            DeviceAuthDialog.this.a(uo2.a().g());
                            return;
                        }
                        case 1349172: 
                        case 1349174: {
                            DeviceAuthDialog.this.b();
                            return;
                        }
                        case 1349152: 
                        case 1349173: 
                    }
                    DeviceAuthDialog.this.d();
                    return;
                }
                try {
                    JSONObject jSONObject = uo2.b();
                    DeviceAuthDialog.this.a(jSONObject.getString("access_token"));
                    return;
                }
                catch (JSONException var3_4) {
                    DeviceAuthDialog.this.a(new FacebookException((Throwable)var3_4));
                    return;
                }
            }
        });
    }

    private void d() {
        if (!this.d.compareAndSet(false, true)) {
            return;
        }
        if (this.c != null) {
            this.c.c_();
        }
        this.h.dismiss();
    }

    public void a(LoginClient.Request request) {
        Bundle bundle = new Bundle();
        bundle.putString("scope", TextUtils.join((CharSequence)",", request.a()));
        String string2 = request.g();
        if (string2 != null) {
            bundle.putString("redirect_uri", string2);
        }
        bundle.putString("access_token", wf.b() + "|" + wf.c());
        new GraphRequest(null, "device/login", bundle, HttpMethod.b, new GraphRequest.b(){

            @Override
            public void onCompleted(uo uo2) {
                if (uo2.a() != null) {
                    DeviceAuthDialog.this.a(uo2.a().g());
                    return;
                }
                JSONObject jSONObject = uo2.b();
                RequestState requestState = new RequestState();
                try {
                    requestState.a(jSONObject.getString("user_code"));
                    requestState.b(jSONObject.getString("code"));
                    requestState.a(jSONObject.getLong("interval"));
                }
                catch (JSONException var4_4) {
                    DeviceAuthDialog.this.a(new FacebookException((Throwable)var4_4));
                    return;
                }
                DeviceAuthDialog.this.a(requestState);
            }
        }).j();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        this.h = new Dialog((Context)this.getActivity(), uu.g.com_facebook_auth_dialog);
        View view = this.getActivity().getLayoutInflater().inflate(uu.e.com_facebook_device_auth_dialog_fragment, null);
        this.a = (ProgressBar)view.findViewById(uu.d.progress_bar);
        this.b = (TextView)view.findViewById(uu.d.confirmation_code);
        ((Button)view.findViewById(uu.d.cancel_button)).setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                DeviceAuthDialog.this.d();
            }
        });
        ((TextView)view.findViewById(uu.d.com_facebook_device_auth_instructions)).setText((CharSequence)Html.fromHtml((String)this.getString(uu.f.com_facebook_device_auth_instructions)));
        this.h.setContentView(view);
        return this.h;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RequestState requestState;
        View view = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.c = (DeviceAuthMethodHandler)((wk)((FacebookActivity)this.getActivity()).a()).b().g();
        if (bundle != null && (requestState = (RequestState)bundle.getParcelable("request_state")) != null) {
            super.a(requestState);
        }
        return view;
    }

    public void onDestroy() {
        this.i = true;
        this.d.set(true);
        super.onDestroy();
        if (this.e != null) {
            this.e.cancel(true);
        }
        if (this.f != null) {
            this.f.cancel(true);
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (!this.i) {
            super.d();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.g != null) {
            bundle.putParcelable("request_state", (Parcelable)this.g);
        }
    }

    static class RequestState
    implements Parcelable {
        public static final Parcelable.Creator<RequestState> CREATOR = new Parcelable.Creator<RequestState>(){

            public RequestState a(Parcel parcel) {
                return new RequestState(parcel);
            }

            public RequestState[] a(int n2) {
                return new RequestState[n2];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return this.a(parcel);
            }

            public /* synthetic */ Object[] newArray(int n2) {
                return this.a(n2);
            }
        };
        private String a;
        private String b;
        private long c;
        private long d;

        RequestState() {
        }

        protected RequestState(Parcel parcel) {
            this.a = parcel.readString();
            this.b = parcel.readString();
            this.c = parcel.readLong();
            this.d = parcel.readLong();
        }

        public String a() {
            return this.a;
        }

        public void a(long l2) {
            this.c = l2;
        }

        public void a(String string2) {
            this.a = string2;
        }

        public String b() {
            return this.b;
        }

        public void b(long l2) {
            this.d = l2;
        }

        public void b(String string2) {
            this.b = string2;
        }

        public long c() {
            return this.c;
        }

        /*
         * Enabled aggressive block sorting
         */
        public boolean d() {
            if (this.d == 0 || new Date().getTime() - this.d - 1000 * this.c >= 0) {
                return false;
            }
            return true;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int n2) {
            parcel.writeString(this.a);
            parcel.writeString(this.b);
            parcel.writeLong(this.c);
            parcel.writeLong(this.d);
        }

    }

}

