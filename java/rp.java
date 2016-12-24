/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Looper
 *  java.io.File
 *  java.io.IOException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.Context;
import android.os.Looper;
import java.io.File;
import java.io.IOException;

class rp {
    final Context a;
    final ang b;

    public rp(Context context, ang ang2) {
        this.a = context;
        this.b = ang2;
    }

    public sd a() throws IOException {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("AnswersFilesManagerProvider cannot be called on the main thread");
        }
        si si2 = new si();
        ama ama2 = new ama();
        File file = this.b.a();
        amw amw2 = new amw(this.a, file, "session_analytics.tap", "session_analytics_to_send");
        return new sd(this.a, si2, ama2, amw2);
    }
}

