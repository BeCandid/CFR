/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  java.lang.String
 *  java.util.Collection
 */
import android.net.Uri;
import com.facebook.login.LoginClient;
import java.util.Collection;

public class wi
extends wm {
    private static volatile wi b;
    private Uri a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static wi a() {
        if (b != null) return b;
        reference var1 = wi.class;
        // MONITORENTER : wi.class
        if (b == null) {
            b = new wi();
        }
        // MONITOREXIT : var1
        return b;
    }

    @Override
    protected LoginClient.Request a(Collection<String> collection) {
        LoginClient.Request request = super.a(collection);
        Uri uri = this.b();
        if (uri != null) {
            request.a(uri.toString());
        }
        return request;
    }

    public void a(Uri uri) {
        this.a = uri;
    }

    public Uri b() {
        return this.a;
    }
}

