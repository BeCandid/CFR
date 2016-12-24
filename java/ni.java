/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.Context;
import android.net.Uri;
import java.io.InputStream;

public class ni
extends mv<InputStream>
implements ng<String> {
    public ni(mr<Uri, InputStream> mr2) {
        super(mr2);
    }

    public static class a
    implements ms<String, InputStream> {
        @Override
        public mr<String, InputStream> a(Context context, mi mi2) {
            return new ni(mi2.a(Uri.class, InputStream.class));
        }

        @Override
        public void a() {
        }
    }

}

