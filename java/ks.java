/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetManager
 *  android.util.Log
 *  com.bumptech.glide.Priority
 *  java.io.IOException
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.Priority;
import java.io.IOException;

public abstract class ks<T>
implements ku<T> {
    private final String a;
    private final AssetManager b;
    private T c;

    public ks(AssetManager assetManager, String string2) {
        this.b = assetManager;
        this.a = string2;
    }

    protected abstract T a(AssetManager var1, String var2) throws IOException;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public void a() {
        if (this.c == null) {
            return;
        }
        try {
            this.a(this.c);
            return;
        }
        catch (IOException var1_1) {
            if (!Log.isLoggable((String)"AssetUriFetcher", (int)2)) return;
            Log.v((String)"AssetUriFetcher", (String)"Failed to close data", (Throwable)var1_1);
            return;
        }
    }

    protected abstract void a(T var1) throws IOException;

    @Override
    public T b(Priority priority) throws Exception {
        this.c = this.a(this.b, this.a);
        return this.c;
    }

    @Override
    public String b() {
        return this.a;
    }

    @Override
    public void c() {
    }
}

