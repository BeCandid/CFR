/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.lang.Object
 *  java.lang.System
 *  java.util.List
 */
import java.io.File;
import java.util.List;

class rs
implements amv {
    private final se a;
    private final sb b;

    rs(se se2, sb sb2) {
        this.a = se2;
        this.b = sb2;
    }

    public static rs a(se se2) {
        return new rs(se2, new sb(new amp(new sa(new amn(1000, 8), 0.1), new amm(5))));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public boolean a(List<File> list) {
        long l2 = System.nanoTime();
        boolean bl2 = this.b.a(l2);
        boolean bl3 = false;
        if (!bl2) return bl3;
        if (this.a.a(list)) {
            this.b.a();
            return true;
        }
        this.b.b(l2);
        return false;
    }
}

