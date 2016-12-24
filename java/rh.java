/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
public class rh {
    private Class<?> a;
    private Class<?> b;

    public rh() {
    }

    public rh(Class<?> class_, Class<?> class_2) {
        this.a(class_, class_2);
    }

    public void a(Class<?> class_, Class<?> class_2) {
        this.a = class_;
        this.b = class_2;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        rh rh2 = (rh)object;
        if (!this.a.equals(rh2.a)) {
            return false;
        }
        if (this.b.equals(rh2.b)) return true;
        return false;
    }

    public int hashCode() {
        return 31 * this.a.hashCode() + this.b.hashCode();
    }

    public String toString() {
        return "MultiClassKey{first=" + this.a + ", second=" + this.b + '}';
    }
}

