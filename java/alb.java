/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  io.fabric.sdk.android.InitializationException
 *  io.fabric.sdk.android.services.concurrency.Priority
 *  io.fabric.sdk.android.services.concurrency.UnmetDependencyException
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.Void
 */
import io.fabric.sdk.android.InitializationException;
import io.fabric.sdk.android.services.concurrency.Priority;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;

class alb<Result>
extends ame<Void, Void, Result> {
    final alc<Result> a;

    public alb(alc<Result> alc2) {
        this.a = alc2;
    }

    private amb a(String string2) {
        amb amb2 = new amb(this.a.b() + "." + string2, "KitInitialization");
        amb2.a();
        return amb2;
    }

    protected /* varargs */ Result a(Void ... arrvoid) {
        amb amb2 = super.a("doInBackground");
        boolean bl2 = this.e();
        Result Result2 = null;
        if (!bl2) {
            Result2 = this.a.f();
        }
        amb2.b();
        return Result2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    protected void a() {
        super.a();
        amb amb2 = this.a("onPreExecute");
        try {
            boolean bl2 = this.a.a_();
            return;
        }
        catch (UnmetDependencyException var6_3) {
            throw var6_3;
        }
        catch (Exception var2_5) {
            akx.h().e("Fabric", "Failure onPreExecute()", (Throwable)var2_5);
            return;
        }
        finally {
            amb2.b();
            if (false) return;
            this.a(true);
        }
    }

    protected void a(Result Result2) {
        this.a.a(Result2);
        this.a.h.a(Result2);
    }

    @Override
    public Priority b() {
        return Priority.c;
    }

    protected void b(Result Result2) {
        this.a.b(Result2);
        InitializationException initializationException = new InitializationException(this.a.b() + " Initialization was cancelled");
        this.a.h.a((Exception)initializationException);
    }
}

