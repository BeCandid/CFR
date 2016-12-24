/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
public final class aqq
implements apn {
    static final apn g = new apn(){

        @Override
        public void a(long l2) {
        }
    };
    long a;
    apn b;
    boolean c;
    long d;
    long e;
    apn f;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        do {
            long l2;
            apn apn2;
            long l3;
            aqq aqq2 = this;
            synchronized (aqq2) {
                l2 = this.d;
                l3 = this.e;
                apn2 = this.f;
                if (l2 == 0 && l3 == 0 && apn2 == null) {
                    this.c = false;
                    return;
                }
                this.d = 0;
                this.e = 0;
                this.f = null;
            }
            long l4 = this.a;
            if (l4 != Long.MAX_VALUE) {
                long l5 = l4 + l2;
                if (l5 < 0 || l5 == Long.MAX_VALUE) {
                    this.a = l4 = Long.MAX_VALUE;
                } else {
                    long l6 = l5 - l3;
                    if (l6 < 0) {
                        throw new IllegalStateException("more produced than requested");
                    }
                    l4 = l6;
                    this.a = l6;
                }
            }
            if (apn2 != null) {
                if (apn2 == g) {
                    this.b = null;
                    continue;
                }
                this.b = apn2;
                apn2.a(l4);
                continue;
            }
            apn apn3 = this.b;
            if (apn3 == null || l2 == 0) continue;
            apn3.a(l2);
        } while (true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    @Override
    public void a(long l2) {
        if (l2 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (l2 == 0) {
            return;
        }
        void var10_2 = this;
        // MONITORENTER : var10_2
        if (this.c) {
            this.d = l2 + this.d;
            // MONITOREXIT : var10_2
            return;
        }
        this.c = true;
        // MONITOREXIT : var10_2
        try {
            long l3 = l2 + this.a;
            if (l3 < 0) {
                l3 = Long.MAX_VALUE;
            }
            this.a = l3;
            apn apn2 = this.b;
            if (apn2 != null) {
                apn2.a(l2);
            }
            this.a();
            if (true) return;
            var10_2 = this;
        }
        catch (Throwable var4_5) {
            if (false) throw var4_5;
            var10_2 = this;
            // MONITORENTER : var10_2
            this.c = false;
            // MONITOREXIT : var10_2
            throw var4_5;
        }
        this.c = false;
        // MONITOREXIT : var10_2
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void a(apn apn2) {
        void var6_2 = this;
        // MONITORENTER : var6_2
        if (this.c) {
            if (apn2 == null) {
                apn2 = g;
            }
            this.f = apn2;
            // MONITOREXIT : var6_2
            return;
        }
        this.c = true;
        // MONITOREXIT : var6_2
        try {
            this.b = apn2;
            if (apn2 != null) {
                apn2.a(this.a);
            }
            this.a();
            if (true) return;
            var6_2 = this;
        }
        catch (Throwable var3_3) {
            if (false) throw var3_3;
            var6_2 = this;
            // MONITORENTER : var6_2
            this.c = false;
            // MONITOREXIT : var6_2
            throw var3_3;
        }
        this.c = false;
        // MONITOREXIT : var6_2
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void b(long var1) {
        if (var1 <= 0) {
            throw new IllegalArgumentException("n > 0 required");
        }
        var11_2 = this;
        // MONITORENTER : var11_2
        if (this.c) {
            this.e = var1 + this.e;
            // MONITOREXIT : var11_2
            return;
        }
        this.c = true;
        // MONITOREXIT : var11_2
        try {
            var6_3 = this.a;
            ** if (var6_3 == Long.MAX_VALUE) goto lbl-1000
        }
        catch (Throwable var4_5) {
            if (false != false) throw var4_5;
            var11_2 = this;
            // MONITORENTER : var11_2
            this.c = false;
            // MONITOREXIT : var11_2
            throw var4_5;
        }
lbl-1000: // 1 sources:
        {
            var9_4 = var6_3 - var1;
            if (var9_4 < 0) {
                throw new IllegalStateException("more items arrived than were requested");
            }
            this.a = var9_4;
        }
lbl-1000: // 2 sources:
        {
        }
        this.a();
        if (true != false) return;
        var11_2 = this;
        // MONITORENTER : var11_2
        this.c = false;
        // MONITOREXIT : var11_2
    }

}

