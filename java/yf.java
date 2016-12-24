/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  com.google.android.gms.R
 *  com.google.android.gms.R$string
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.R;

public class yf {
    private final Resources a;
    private final String b;

    public yf(Context context) {
        xz.a(context);
        this.a = context.getResources();
        this.b = this.a.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
    }

    public String a(String string2) {
        int n2 = this.a.getIdentifier(string2, "string", this.b);
        if (n2 == 0) {
            return null;
        }
        return this.a.getString(n2);
    }
}

