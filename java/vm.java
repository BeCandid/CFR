/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Configuration
 *  android.os.Bundle
 *  android.os.Message
 *  android.support.v4.app.DialogFragment
 *  android.support.v4.app.FragmentActivity
 *  java.lang.Object
 *  java.lang.String
 */
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import com.facebook.FacebookException;

public class vm
extends DialogFragment {
    private Dialog a;

    private void a(Bundle bundle) {
        FragmentActivity fragmentActivity = this.getActivity();
        Intent intent = new Intent();
        if (bundle == null) {
            bundle = new Bundle();
        }
        intent.putExtras(bundle);
        fragmentActivity.setResult(-1, intent);
        fragmentActivity.finish();
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(Bundle bundle, FacebookException facebookException) {
        FragmentActivity fragmentActivity = this.getActivity();
        Intent intent = vz.a(fragmentActivity.getIntent(), bundle, facebookException);
        int n2 = facebookException == null ? -1 : 0;
        fragmentActivity.setResult(n2, intent);
        fragmentActivity.finish();
    }

    public void a(Dialog dialog) {
        this.a = dialog;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.a instanceof wg) {
            ((wg)this.a).d();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void onCreate(Bundle bundle) {
        wg wg2;
        super.onCreate(bundle);
        if (this.a != null) return;
        FragmentActivity fragmentActivity = this.getActivity();
        Bundle bundle2 = vz.d(fragmentActivity.getIntent());
        if (!bundle2.getBoolean("is_fallback", false)) {
            String string2 = bundle2.getString("action");
            Bundle bundle3 = bundle2.getBundle("params");
            if (we.a(string2)) {
                we.b("FacebookDialogFragment", "Cannot start a WebDialog with an empty/missing 'actionName'");
                fragmentActivity.finish();
                return;
            }
            wg2 = new wg.a((Context)fragmentActivity, string2, bundle3).a(new wg.c(){

                @Override
                public void a(Bundle bundle, FacebookException facebookException) {
                    vm.this.a(bundle, facebookException);
                }
            }).a();
        } else {
            String string3 = bundle2.getString("url");
            if (we.a(string3)) {
                we.b("FacebookDialogFragment", "Cannot start a fallback WebDialog with an empty/missing 'url'");
                fragmentActivity.finish();
                return;
            }
            Object[] arrobject = new Object[]{ul.i()};
            wg2 = new vo((Context)fragmentActivity, string3, String.format((String)"fb%s://bridge/", (Object[])arrobject));
            wg2.a(new wg.c(){

                @Override
                public void a(Bundle bundle, FacebookException facebookException) {
                    vm.this.a(bundle);
                }
            });
        }
        this.a = wg2;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.a == null) {
            super.a(null, null);
            this.setShowsDialog(false);
        }
        return this.a;
    }

    public void onDestroyView() {
        if (this.getDialog() != null && this.getRetainInstance()) {
            this.getDialog().setDismissMessage(null);
        }
        super.onDestroyView();
    }

}

