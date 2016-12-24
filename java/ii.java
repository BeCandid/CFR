/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  rx.exceptions.CompositeException
 */
import java.io.IOException;
import rx.exceptions.CompositeException;

public class ii
implements apz<Throwable> {
    String a;

    public ii(String string2) {
        this.a = string2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(Throwable throwable) {
        if (!(throwable instanceof IOException) && throwable instanceof CompositeException) {
            ix.a().a(new in.ap());
        }
        rj.a(throwable);
    }

    @Override
    public /* synthetic */ void call(Object object) {
        this.a((Throwable)object);
    }
}

