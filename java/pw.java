/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Bundle
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalArgumentException
 *  java.lang.InstantiationException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.Set
 */
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class pw {
    private final Context a;

    public pw(Context context) {
        this.a = context;
    }

    private static pv a(String string2) {
        Object object;
        Class class_;
        try {
            class_ = Class.forName((String)string2);
        }
        catch (ClassNotFoundException var1_3) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", (Throwable)var1_3);
        }
        try {
            object = class_.newInstance();
        }
        catch (InstantiationException var4_4) {
            throw new RuntimeException("Unable to instantiate GlideModule implementation for " + (Object)class_, (Throwable)var4_4);
        }
        catch (IllegalAccessException var3_5) {
            throw new RuntimeException("Unable to instantiate GlideModule implementation for " + (Object)class_, (Throwable)var3_5);
        }
        if (!(object instanceof pv)) {
            throw new RuntimeException("Expected instanceof GlideModule, but found: " + object);
        }
        return (pv)object;
    }

    public List<pv> a() {
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128);
            if (applicationInfo.metaData != null) {
                for (String string2 : applicationInfo.metaData.keySet()) {
                    if (!"GlideModule".equals(applicationInfo.metaData.get(string2))) continue;
                    arrayList.add((Object)pw.a(string2));
                }
            }
        }
        catch (PackageManager.NameNotFoundException var2_5) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", (Throwable)var2_5);
        }
        return arrayList;
    }
}

