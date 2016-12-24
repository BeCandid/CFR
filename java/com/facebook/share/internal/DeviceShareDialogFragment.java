/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.support.v4.app.DialogFragment
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.FragmentActivity
 *  android.support.v4.app.FragmentManager
 *  android.support.v4.app.FragmentTransaction
 *  android.text.Html
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.ProgressBar
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.concurrent.ScheduledFuture
 *  java.util.concurrent.ScheduledThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.facebook.share.internal;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceShareDialogFragment
extends DialogFragment {
    private static ScheduledThreadPoolExecutor f;
    private ProgressBar a;
    private TextView b;
    private Dialog c;
    private volatile RequestState d;
    private volatile ScheduledFuture e;
    private ShareContent g;

    private void a() {
        if (this.isAdded()) {
            this.getFragmentManager().beginTransaction().remove((Fragment)this).commit();
        }
    }

    private void a(int n2, Intent intent) {
        if (this.isAdded()) {
            FragmentActivity fragmentActivity = this.getActivity();
            fragmentActivity.setResult(n2, intent);
            fragmentActivity.finish();
        }
    }

    private void a(FacebookRequestError facebookRequestError) {
        super.a();
        Intent intent = new Intent();
        intent.putExtra("error", (Parcelable)facebookRequestError);
        super.a(-1, intent);
    }

    private void a(RequestState requestState) {
        this.d = requestState;
        this.b.setText((CharSequence)requestState.a());
        this.b.setVisibility(0);
        this.a.setVisibility(8);
        this.e = DeviceShareDialogFragment.d().schedule(new Runnable(){

            public void run() {
                DeviceShareDialogFragment.this.c.dismiss();
            }
        }, requestState.b(), TimeUnit.SECONDS);
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private Bundle b() {
        ShareContent shareContent = this.g;
        if (shareContent == null) {
            return null;
        }
        if (shareContent instanceof ShareLinkContent) {
            return xa.a((ShareLinkContent)shareContent);
        }
        if (!(shareContent instanceof ShareOpenGraphContent)) return null;
        return xa.a((ShareOpenGraphContent)shareContent);
    }

    private void c() {
        Bundle bundle = this.b();
        if (bundle == null || bundle.size() == 0) {
            this.a(new FacebookRequestError(0, "", "Failed to get share content"));
        }
        bundle.putString("access_token", wf.b() + "|" + wf.c());
        new GraphRequest(null, "device/share", bundle, HttpMethod.b, new GraphRequest.b(){

            @Override
            public void onCompleted(uo uo2) {
                FacebookRequestError facebookRequestError = uo2.a();
                if (facebookRequestError != null) {
                    DeviceShareDialogFragment.this.a(facebookRequestError);
                    return;
                }
                JSONObject jSONObject = uo2.b();
                RequestState requestState = new RequestState();
                try {
                    requestState.a(jSONObject.getString("user_code"));
                    requestState.a(jSONObject.getLong("expires_in"));
                }
                catch (JSONException var5_5) {
                    DeviceShareDialogFragment.this.a(new FacebookRequestError(0, "", "Malformed server response"));
                    return;
                }
                DeviceShareDialogFragment.this.a(requestState);
            }
        }).j();
    }

    private static ScheduledThreadPoolExecutor d() {
        reference var2 = DeviceShareDialogFragment.class;
        synchronized (DeviceShareDialogFragment.class) {
            if (f == null) {
                f = new ScheduledThreadPoolExecutor(1);
            }
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = f;
            // ** MonitorExit[var2] (shouldn't be in output)
            return scheduledThreadPoolExecutor;
        }
    }

    public void a(ShareContent shareContent) {
        this.g = shareContent;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        this.c = new Dialog((Context)this.getActivity(), uu.g.com_facebook_auth_dialog);
        View view = this.getActivity().getLayoutInflater().inflate(uu.e.com_facebook_device_auth_dialog_fragment, null);
        this.a = (ProgressBar)view.findViewById(uu.d.progress_bar);
        this.b = (TextView)view.findViewById(uu.d.confirmation_code);
        ((Button)view.findViewById(uu.d.cancel_button)).setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                DeviceShareDialogFragment.this.c.dismiss();
            }
        });
        ((TextView)view.findViewById(uu.d.com_facebook_device_auth_instructions)).setText((CharSequence)Html.fromHtml((String)this.getString(uu.f.com_facebook_device_auth_instructions)));
        ((TextView)view.findViewById(uu.d.com_facebook_device_dialog_title)).setText((CharSequence)this.getString(uu.f.com_facebook_share_button_text));
        this.c.setContentView(view);
        super.c();
        return this.c;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RequestState requestState;
        View view = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (bundle != null && (requestState = (RequestState)bundle.getParcelable("request_state")) != null) {
            super.a(requestState);
        }
        return view;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.e != null) {
            this.e.cancel(true);
        }
        super.a(-1, new Intent());
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.d != null) {
            bundle.putParcelable("request_state", (Parcelable)this.d);
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
        private long b;

        RequestState() {
        }

        protected RequestState(Parcel parcel) {
            this.a = parcel.readString();
            this.b = parcel.readLong();
        }

        public String a() {
            return this.a;
        }

        public void a(long l2) {
            this.b = l2;
        }

        public void a(String string2) {
            this.a = string2;
        }

        public long b() {
            return this.b;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int n2) {
            parcel.writeString(this.a);
            parcel.writeLong(this.b);
        }

    }

}

