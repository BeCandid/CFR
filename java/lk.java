/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.Message
 *  java.lang.Object
 */
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class lk {
    private boolean a;
    private final Handler b = new Handler(Looper.getMainLooper(), (Handler.Callback)new a(null));

    lk() {
    }

    public void a(lj<?> lj2) {
        ri.a();
        if (this.a) {
            this.b.obtainMessage(1, lj2).sendToTarget();
            return;
        }
        this.a = true;
        lj2.d();
        this.a = false;
    }

    static class a
    implements Handler.Callback {
        private a() {
        }

        /* synthetic */ a( var1) {
        }

        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                ((lj)message.obj).d();
                return true;
            }
            return false;
        }
    }

}

