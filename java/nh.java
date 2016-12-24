/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 */
import android.content.Context;
import android.net.Uri;
import java.io.InputStream;

public class nh
extends mt<InputStream>
implements ng<Integer> {
    public nh(Context context, mr<Uri, InputStream> mr2) {
        super(context, mr2);
    }

    public static class a
    implements ms<Integer, InputStream> {
        @Override
        public mr<Integer, InputStream> a(Context context, mi mi2) {
            return new nh(context, mi2.a(Uri.class, InputStream.class));
        }

        @Override
        public void a() {
        }
    }

}

