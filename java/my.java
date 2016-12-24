/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.os.ParcelFileDescriptor
 *  java.io.File
 *  java.lang.Class
 *  java.lang.Object
 */
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.File;

public class my
extends mh<ParcelFileDescriptor>
implements mz<File> {
    public my(mr<Uri, ParcelFileDescriptor> mr2) {
        super(mr2);
    }

    public static class a
    implements ms<File, ParcelFileDescriptor> {
        @Override
        public mr<File, ParcelFileDescriptor> a(Context context, mi mi2) {
            return new my(mi2.a(Uri.class, ParcelFileDescriptor.class));
        }

        @Override
        public void a() {
        }
    }

}

