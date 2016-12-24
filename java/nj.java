/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.net.Uri
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.InputStream;

public class nj
extends mw<InputStream>
implements ng<Uri> {
    public nj(Context context, mr<mj, InputStream> mr2) {
        super(context, mr2);
    }

    @Override
    protected ku<InputStream> a(Context context, Uri uri) {
        return new la(context, uri);
    }

    @Override
    protected ku<InputStream> a(Context context, String string2) {
        return new kz(context.getApplicationContext().getAssets(), string2);
    }

    public static class a
    implements ms<Uri, InputStream> {
        @Override
        public mr<Uri, InputStream> a(Context context, mi mi2) {
            return new nj(context, mi2.a(mj.class, InputStream.class));
        }

        @Override
        public void a() {
        }
    }

}

