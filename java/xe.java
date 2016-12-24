/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnDismissListener
 *  android.os.Bundle
 *  android.support.v4.app.DialogFragment
 *  android.support.v4.app.FragmentManager
 *  java.lang.Object
 *  java.lang.String
 */
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;

public class xe
extends DialogFragment {
    private Dialog a = null;
    private DialogInterface.OnCancelListener b = null;

    public static xe a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        xe xe2 = new xe();
        Dialog dialog2 = xz.a(dialog, (Object)"Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        xe2.a = dialog2;
        if (onCancelListener != null) {
            xe2.b = onCancelListener;
        }
        return xe2;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.b != null) {
            this.b.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.a == null) {
            this.setShowsDialog(false);
        }
        return this.a;
    }

    public void show(FragmentManager fragmentManager, String string2) {
        super.show(fragmentManager, string2);
    }
}

