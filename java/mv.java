/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.text.TextUtils
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;

public class mv<T>
implements mr<String, T> {
    private final mr<Uri, T> a;

    public mv(mr<Uri, T> mr2) {
        this.a = mr2;
    }

    private static Uri a(String string2) {
        return Uri.fromFile((File)new File(string2));
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public ku<T> a(String string2, int n2, int n3) {
        Uri uri;
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return null;
        }
        if (string2.startsWith("/")) {
            uri = mv.a(string2);
            return this.a.a(uri, n2, n3);
        }
        uri = Uri.parse((String)string2);
        if (uri.getScheme() != null) return this.a.a(uri, n2, n3);
        uri = mv.a(string2);
        return this.a.a(uri, n2, n3);
    }
}

