/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.crashlytics.android.answers.SessionEvent
 *  java.io.IOException
 *  java.lang.String
 *  java.util.UUID
 */
import android.content.Context;
import com.crashlytics.android.answers.SessionEvent;
import java.io.IOException;
import java.util.UUID;

class sd
extends amr<SessionEvent> {
    private anl g;

    sd(Context context, si si2, alu alu2, ams ams2) throws IOException {
        super(context, si2, alu2, ams2, 100);
    }

    @Override
    protected String a() {
        UUID uUID = UUID.randomUUID();
        return "sa" + "_" + uUID.toString() + "_" + this.c.a() + ".tap";
    }

    @Override
    void a(anl anl2) {
        this.g = anl2;
    }

    @Override
    protected int b() {
        if (this.g == null) {
            return super.b();
        }
        return this.g.e;
    }

    @Override
    protected int c() {
        if (this.g == null) {
            return super.c();
        }
        return this.g.c;
    }
}

