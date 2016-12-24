/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.os.ParcelFileDescriptor
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 */
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;

public class na
extends mt<ParcelFileDescriptor>
implements mz<Integer> {
    public na(Context context, mr<Uri, ParcelFileDescriptor> mr2) {
        super(context, mr2);
    }

    public static class a
    implements ms<Integer, ParcelFileDescriptor> {
        @Override
        public mr<Integer, ParcelFileDescriptor> a(Context context, mi mi2) {
            return new na(context, mi2.a(Uri.class, ParcelFileDescriptor.class));
        }

        @Override
        public void a() {
        }
    }

}

