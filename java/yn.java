/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.Activity
 *  android.content.ActivityNotFoundException
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.support.v4.app.Fragment
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.String
 */
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;

public abstract class yn
implements DialogInterface.OnClickListener {
    public static yn a(abj abj2, final Intent intent, final int n2) {
        return new yn(){

            @TargetApi(value=11)
            @Override
            public void a() {
                abj.this.startActivityForResult(intent, n2);
            }
        };
    }

    public static yn a(Activity activity, final Intent intent, final int n2) {
        return new yn(){

            @Override
            public void a() {
                Activity.this.startActivityForResult(intent, n2);
            }
        };
    }

    public static yn a(Fragment fragment, final Intent intent, final int n2) {
        return new yn(){

            @Override
            public void a() {
                Fragment.this.startActivityForResult(intent, n2);
            }
        };
    }

    public abstract void a();

    public void onClick(DialogInterface dialogInterface, int n2) {
        try {
            this.a();
            dialogInterface.dismiss();
            return;
        }
        catch (ActivityNotFoundException var3_3) {
            Log.e((String)"DialogRedirect", (String)"Can't redirect to app settings for Google Play services");
            return;
        }
    }

}

