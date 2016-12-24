/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.net.Uri
 *  android.util.Log
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;

public class mt<T>
implements mr<Integer, T> {
    private final mr<Uri, T> a;
    private final Resources b;

    public mt(Context context, mr<Uri, T> mr2) {
        super(context.getResources(), mr2);
    }

    public mt(Resources resources, mr<Uri, T> mr2) {
        this.b = resources;
        this.a = mr2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public ku<T> a(Integer n2, int n3, int n4) {
        Uri uri;
        try {
            Uri uri2;
            uri = uri2 = Uri.parse((String)("android.resource://" + this.b.getResourcePackageName(n2.intValue()) + '/' + this.b.getResourceTypeName(n2.intValue()) + '/' + this.b.getResourceEntryName(n2.intValue())));
            if (uri == null) return null;
        }
        catch (Resources.NotFoundException var4_6) {
            boolean bl2 = Log.isLoggable((String)"ResourceLoader", (int)5);
            uri = null;
            if (!bl2) return null;
            Log.w((String)"ResourceLoader", (String)("Received invalid resource id: " + (Object)n2), (Throwable)var4_6);
            return null;
        }
        return this.a.a(uri, n3, n4);
    }
}

