/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  java.io.File
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.Object
 */
import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.io.InputStream;

public class nf
extends mh<InputStream>
implements ng<File> {
    public nf(mr<Uri, InputStream> mr2) {
        super(mr2);
    }

    public static class a
    implements ms<File, InputStream> {
        @Override
        public mr<File, InputStream> a(Context context, mi mi2) {
            return new nf(mi2.a(Uri.class, InputStream.class));
        }

        @Override
        public void a() {
        }
    }

}

