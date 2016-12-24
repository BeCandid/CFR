/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.AsyncTask
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.util.Log
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.Void
 *  java.net.HttpURLConnection
 *  java.util.List
 */
import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.facebook.GraphRequest;
import java.net.HttpURLConnection;
import java.util.List;

public class um
extends AsyncTask<Void, Void, List<uo>> {
    private static final String a = um.class.getCanonicalName();
    private final HttpURLConnection b;
    private final un c;
    private Exception d;

    public um(HttpURLConnection httpURLConnection, un un2) {
        this.c = un2;
        this.b = httpURLConnection;
    }

    public um(un un2) {
        super(null, un2);
    }

    protected /* varargs */ List<uo> a(Void ... arrvoid) {
        try {
            if (this.b == null) {
                return this.c.g();
            }
            List<uo> list = GraphRequest.a(this.b, this.c);
            return list;
        }
        catch (Exception var2_3) {
            this.d = var2_3;
            return null;
        }
    }

    protected void a(List<uo> list) {
        super.onPostExecute(list);
        if (this.d != null) {
            String string2 = a;
            Object[] arrobject = new Object[]{this.d.getMessage()};
            Log.d((String)string2, (String)String.format((String)"onPostExecute: exception encountered during request: %s", (Object[])arrobject));
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] arrobject) {
        return this.a((Void[])arrobject);
    }

    protected /* synthetic */ void onPostExecute(Object object) {
        this.a((List)object);
    }

    /*
     * Enabled aggressive block sorting
     */
    protected void onPreExecute() {
        super.onPreExecute();
        if (ul.b()) {
            Log.d((String)a, (String)String.format((String)"execute async task: %s", (Object[])new Object[]{this}));
        }
        if (this.c.c() == null) {
            Handler handler = Thread.currentThread() instanceof HandlerThread ? new Handler() : new Handler(Looper.getMainLooper());
            this.c.a(handler);
        }
    }

    public String toString() {
        return "{RequestAsyncTask: " + " connection: " + (Object)this.b + ", requests: " + (Object)((Object)this.c) + "}";
    }
}

