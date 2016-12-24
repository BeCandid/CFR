/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.List
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class zc {
    public static /* varargs */ int a(Object ... arrobject) {
        return Arrays.hashCode((Object[])arrobject);
    }

    public static a a(Object object) {
        return new a(object, null);
    }

    public static boolean a(Object object, Object object2) {
        if (object == object2 || object != null && object.equals(object2)) {
            return true;
        }
        return false;
    }

    public static final class a {
        private final List<String> a;
        private final Object b;

        private a(Object object) {
            this.b = xz.a(object);
            this.a = new ArrayList();
        }

        /* synthetic */ a(Object object,  var2_2) {
            super(object);
        }

        public a a(String string2, Object object) {
            List<String> list = this.a;
            String string3 = xz.a(string2);
            String string4 = String.valueOf((Object)String.valueOf((Object)object));
            list.add((Object)new StringBuilder(1 + String.valueOf((Object)string3).length() + String.valueOf((Object)string4).length()).append(string3).append("=").append(string4).toString());
            return this;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(100).append(this.b.getClass().getSimpleName()).append('{');
            int n2 = this.a.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                stringBuilder.append((String)this.a.get(i2));
                if (i2 >= n2 - 1) continue;
                stringBuilder.append(", ");
            }
            return stringBuilder.append('}').toString();
        }
    }

}

