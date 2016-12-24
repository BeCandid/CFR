/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Properties
 */
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class so {
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    so(String string2, String string3, String string4, String string5) {
        this.a = string2;
        this.b = string3;
        this.c = string4;
        this.d = string5;
    }

    public static so a(InputStream inputStream) throws IOException {
        Properties properties = new Properties();
        properties.load(inputStream);
        return so.a(properties);
    }

    public static so a(Properties properties) {
        return new so(properties.getProperty("version_code"), properties.getProperty("version_name"), properties.getProperty("build_id"), properties.getProperty("package_name"));
    }
}

