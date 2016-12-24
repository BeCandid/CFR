/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  com.bumptech.glide.load.DecodeFormat
 *  java.lang.Object
 */
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.DecodeFormat;

public final class mf {
    private final mb a;
    private final ln b;
    private final DecodeFormat c;
    private final Handler d = new Handler(Looper.getMainLooper());

    public mf(mb mb2, ln ln2, DecodeFormat decodeFormat) {
        this.a = mb2;
        this.b = ln2;
        this.c = decodeFormat;
    }
}

