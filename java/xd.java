/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.app.Dialog
 *  android.app.PendingIntent
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.res.Resources
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.ProgressBar
 *  com.google.android.gms.R
 *  com.google.android.gms.R$string
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.GooglePlayServicesUtil
 *  com.google.android.gms.common.api.GoogleApiActivity
 *  com.google.android.gms.internal.zzol
 *  com.google.android.gms.internal.zzol$a
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import com.google.android.gms.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.internal.zzol;

public class xd
extends aaa {
    public static final int a;
    private static final xd c;

    static {
        c = new xd();
        a = aaa.b;
    }

    xd() {
    }

    public static xd a() {
        return c;
    }

    @Override
    public int a(Context context) {
        return super.a(context);
    }

    public Dialog a(Activity activity, int n2, int n3) {
        return GooglePlayServicesUtil.getErrorDialog((int)n2, (Activity)activity, (int)n3);
    }

    public Dialog a(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar((Context)activity, null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder((Context)activity);
        builder.setView((View)progressBar);
        String string2 = GooglePlayServicesUtil.zzam((Context)activity);
        builder.setMessage((CharSequence)activity.getResources().getString(R.string.common_google_play_services_updating_text, new Object[]{string2}));
        builder.setTitle(R.string.common_google_play_services_updating_title);
        builder.setPositiveButton((CharSequence)"", null);
        AlertDialog alertDialog = builder.create();
        GooglePlayServicesUtil.zza((Activity)activity, (DialogInterface.OnCancelListener)onCancelListener, (String)"GooglePlayServicesUpdatingDialog", (Dialog)alertDialog);
        return alertDialog;
    }

    @Override
    public PendingIntent a(Context context, int n2, int n3) {
        return super.a(context, n2, n3);
    }

    @Override
    public PendingIntent a(Context context, int n2, int n3, String string2) {
        return super.a(context, n2, n3, string2);
    }

    public PendingIntent a(Context context, ConnectionResult connectionResult) {
        if (connectionResult.a()) {
            return connectionResult.d();
        }
        int n2 = connectionResult.c();
        if (zq.a(context) && n2 == 2) {
            n2 = 42;
        }
        return this.a(context, n2, 0);
    }

    @Override
    public Intent a(Context context, int n2, String string2) {
        return super.a(context, n2, string2);
    }

    public zzol a(Context context, zzol.a a2) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        zzol zzol2 = new zzol(a2);
        context.registerReceiver((BroadcastReceiver)zzol2, intentFilter);
        zzol2.a(context);
        if (!this.a(context, "com.google.android.gms")) {
            a2.a();
            zzol2.a();
            zzol2 = null;
        }
        return zzol2;
    }

    public void a(Context context, ConnectionResult connectionResult, int n2) {
        PendingIntent pendingIntent = this.a(context, connectionResult);
        if (pendingIntent != null) {
            GooglePlayServicesUtil.zza((int)connectionResult.c(), (Context)context, (PendingIntent)GoogleApiActivity.a((Context)context, (PendingIntent)pendingIntent, (int)n2));
        }
    }

    @Override
    public final boolean a(int n2) {
        return super.a(n2);
    }

    public boolean a(Activity activity, int n2, int n3, DialogInterface.OnCancelListener onCancelListener) {
        return GooglePlayServicesUtil.showErrorDialogFragment((int)n2, (Activity)activity, (int)n3, (DialogInterface.OnCancelListener)onCancelListener);
    }

    public boolean a(Activity activity, abj abj2, int n2, int n3, DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialog = GooglePlayServicesUtil.zza((int)n2, (Activity)activity, (yn)yn.a(abj2, this.a((Context)activity, n2, "d"), n3), (DialogInterface.OnCancelListener)onCancelListener);
        if (dialog == null) {
            return false;
        }
        GooglePlayServicesUtil.zza((Activity)activity, (DialogInterface.OnCancelListener)onCancelListener, (String)"GooglePlayServicesErrorDialog", (Dialog)dialog);
        return true;
    }

    public boolean b(Activity activity, int n2, int n3) {
        return GooglePlayServicesUtil.showErrorDialogFragment((int)n2, (Activity)activity, (int)n3);
    }
}

