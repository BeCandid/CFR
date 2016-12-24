/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
import java.io.File;
import java.io.IOException;

class tb {
    private final String a;
    private final ang b;

    public tb(String string2, ang ang2) {
        this.a = string2;
        this.b = ang2;
    }

    private File d() {
        return new File(this.b.a(), this.a);
    }

    public boolean a() {
        try {
            boolean bl2 = this.d().createNewFile();
            return bl2;
        }
        catch (IOException var1_2) {
            akx.h().e("CrashlyticsCore", "Error creating marker: " + this.a, (Throwable)var1_2);
            return false;
        }
    }

    public boolean b() {
        return this.d().exists();
    }

    public boolean c() {
        return this.d().delete();
    }
}

