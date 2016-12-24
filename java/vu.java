/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  java.io.BufferedInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.net.HttpURLConnection
 *  java.net.URL
 *  java.net.URLConnection
 */
import android.content.Context;
import android.net.Uri;
import com.facebook.LoggingBehavior;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

class vu {
    static final String a = vu.class.getSimpleName();
    private static volatile vp b;

    vu() {
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static InputStream a(Context context, HttpURLConnection httpURLConnection) throws IOException {
        int n2 = httpURLConnection.getResponseCode();
        InputStream inputStream = null;
        if (n2 != 200) return inputStream;
        Uri uri = Uri.parse((String)httpURLConnection.getURL().toString());
        inputStream = httpURLConnection.getInputStream();
        try {
            if (!vu.a(uri)) return inputStream;
            InputStream inputStream2 = vu.a(context).a(uri.toString(), (InputStream)new a(inputStream, httpURLConnection));
            return inputStream2;
        }
        catch (IOException var5_6) {
            return inputStream;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static InputStream a(Uri uri, Context context) {
        InputStream inputStream = null;
        if (uri == null) return inputStream;
        boolean bl2 = vu.a(uri);
        inputStream = null;
        if (!bl2) return inputStream;
        try {
            InputStream inputStream2 = vu.a(context).a(uri.toString());
            return inputStream2;
        }
        catch (IOException iOException) {
            vx.a(LoggingBehavior.d, 5, a, iOException.toString());
            return null;
        }
    }

    static vp a(Context context) throws IOException {
        reference var3_1 = vu.class;
        synchronized (vu.class) {
            if (b == null) {
                b = new vp(a, new vp.d());
            }
            vp vp2 = b;
            // ** MonitorExit[var3_1] (shouldn't be in output)
            return vp2;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private static boolean a(Uri uri) {
        String string2;
        if (uri != null && ((string2 = uri.getHost()).endsWith("fbcdn.net") || string2.startsWith("fbcdn") && string2.endsWith("akamaihd.net"))) {
            return true;
        }
        return false;
    }

    static class a
    extends BufferedInputStream {
        HttpURLConnection a;

        a(InputStream inputStream, HttpURLConnection httpURLConnection) {
            super(inputStream, 8192);
            this.a = httpURLConnection;
        }

        public void close() throws IOException {
            super.close();
            we.a((URLConnection)this.a);
        }
    }

}

