/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  java.lang.Object
 *  java.lang.String
 */
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class vi {
    private Uri a;

    public vi(String string2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.a = we.a(wc.a(), wc.d() + "/" + "dialog/" + string2, bundle);
    }

    public void a(Activity activity) {
        b b2 = new b.a().a();
        b2.a.setPackage("com.android.chrome");
        b2.a(activity, this.a);
    }
}

