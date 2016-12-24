/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.os.ParcelFileDescriptor
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;

public class nb
extends mv<ParcelFileDescriptor>
implements mz<String> {
    public nb(mr<Uri, ParcelFileDescriptor> mr2) {
        super(mr2);
    }

    public static class a
    implements ms<String, ParcelFileDescriptor> {
        @Override
        public mr<String, ParcelFileDescriptor> a(Context context, mi mi2) {
            return new nb(mi2.a(Uri.class, ParcelFileDescriptor.class));
        }

        @Override
        public void a() {
        }
    }

}

