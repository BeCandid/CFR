/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
public class aoc {
    public final ano a;
    public final anz b;
    public final any c;
    public final anw d;
    public final anl e;
    public final anp f;
    public final long g;
    public final int h;
    public final int i;

    public aoc(long l2, ano ano2, anz anz2, any any2, anw anw2, anl anl2, anp anp2, int n2, int n3) {
        this.g = l2;
        this.a = ano2;
        this.b = anz2;
        this.c = any2;
        this.d = anw2;
        this.h = n2;
        this.i = n3;
        this.e = anl2;
        this.f = anp2;
    }

    public boolean a(long l2) {
        if (this.g < l2) {
            return true;
        }
        return false;
    }
}

