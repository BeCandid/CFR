/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.net.Uri
 *  android.util.Log
 *  com.bumptech.glide.Priority
 *  java.io.FileNotFoundException
 *  java.io.IOException
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.Priority;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class ky<T>
implements ku<T> {
    private final Uri a;
    private final Context b;
    private T c;

    public ky(Context context, Uri uri) {
        this.b = context.getApplicationContext();
        this.a = uri;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a() {
        if (this.c == null) return;
        try {
            this.a(this.c);
            return;
        }
        catch (IOException var1_1) {
            if (!Log.isLoggable((String)"LocalUriFetcher", (int)2)) return;
            Log.v((String)"LocalUriFetcher", (String)"failed to close data", (Throwable)var1_1);
            return;
        }
    }

    protected abstract void a(T var1) throws IOException;

    protected abstract T b(Uri var1, ContentResolver var2) throws FileNotFoundException;

    @Override
    public final T b(Priority priority) throws Exception {
        ContentResolver contentResolver = this.b.getContentResolver();
        this.c = this.b(this.a, contentResolver);
        return this.c;
    }

    @Override
    public String b() {
        return this.a.toString();
    }

    @Override
    public void c() {
    }
}

