/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Map
 */
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class tu
implements tr {
    private final File a;
    private final Map<String, String> b;

    public tu(File file) {
        super(file, Collections.emptyMap());
    }

    public tu(File file, Map<String, String> map) {
        this.a = file;
        this.b = new HashMap(map);
        if (this.a.length() == 0) {
            this.b.putAll(ts.a);
        }
    }

    @Override
    public boolean a() {
        akx.h().a("CrashlyticsCore", "Removing report at " + this.a.getPath());
        return this.a.delete();
    }

    @Override
    public String b() {
        return this.d().getName();
    }

    @Override
    public String c() {
        String string2 = this.b();
        return string2.substring(0, string2.lastIndexOf(46));
    }

    @Override
    public File d() {
        return this.a;
    }

    @Override
    public Map<String, String> e() {
        return Collections.unmodifiableMap(this.b);
    }
}

