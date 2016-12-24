/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 */
import android.content.Context;

public class ali<T>
extends alh<T> {
    private T a;

    public ali() {
        this(null);
    }

    public ali(alj<T> alj2) {
        super(alj2);
    }

    @Override
    protected T a(Context context) {
        return this.a;
    }

    @Override
    protected void a(Context context, T t2) {
        this.a = t2;
    }
}

