/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.Context;
import android.net.Uri;

public abstract class mw<T>
implements mr<Uri, T> {
    private final Context a;
    private final mr<mj, T> b;

    public mw(Context context, mr<mj, T> mr2) {
        this.a = context;
        this.b = mr2;
    }

    private static boolean a(String string2) {
        if ("file".equals((Object)string2) || "content".equals((Object)string2) || "android.resource".equals((Object)string2)) {
            return true;
        }
        return false;
    }

    protected abstract ku<T> a(Context var1, Uri var2);

    protected abstract ku<T> a(Context var1, String var2);

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public final ku<T> a(Uri uri, int n2, int n3) {
        String string2 = uri.getScheme();
        if (mw.a(string2)) {
            if (!mg.a(uri)) return this.a(this.a, uri);
            String string3 = mg.b(uri);
            return this.a(this.a, string3);
        }
        mr<mj, T> mr2 = this.b;
        ku<T> ku2 = null;
        if (mr2 == null) return ku2;
        if ("http".equals((Object)string2)) return this.b.a(new mj(uri.toString()), n2, n3);
        boolean bl2 = "https".equals((Object)string2);
        ku2 = null;
        if (!bl2) return ku2;
        return this.b.a(new mj(uri.toString()), n2, n3);
    }
}

