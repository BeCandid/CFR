/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.CloneNotSupportedException
 *  java.lang.Object
 *  java.lang.String
 */
import java.io.IOException;

public abstract class aki {
    protected volatile int F = -1;

    public abstract aki b(akg var1) throws IOException;

    public aki c() throws CloneNotSupportedException {
        return (aki)super.clone();
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return this.c();
    }

    public String toString() {
        return akj.a(this);
    }
}

