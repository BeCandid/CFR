/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.net.Uri
 *  android.os.ParcelFileDescriptor
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;

public class nc
extends mw<ParcelFileDescriptor>
implements mz<Uri> {
    public nc(Context context, mr<mj, ParcelFileDescriptor> mr2) {
        super(context, mr2);
    }

    @Override
    protected ku<ParcelFileDescriptor> a(Context context, Uri uri) {
        return new kw(context, uri);
    }

    @Override
    protected ku<ParcelFileDescriptor> a(Context context, String string2) {
        return new kv(context.getApplicationContext().getAssets(), string2);
    }

    public static class a
    implements ms<Uri, ParcelFileDescriptor> {
        @Override
        public mr<Uri, ParcelFileDescriptor> a(Context context, mi mi2) {
            return new nc(context, mi2.a(mj.class, ParcelFileDescriptor.class));
        }

        @Override
        public void a() {
        }
    }

}

