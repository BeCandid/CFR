/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  io.fabric.sdk.android.services.common.CommonUtils
 *  io.fabric.sdk.android.services.common.IdManager
 *  io.fabric.sdk.android.services.common.IdManager$DeviceIdentifierType
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 *  java.util.UUID
 */
import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.IdManager;
import java.util.Map;
import java.util.UUID;

class sj {
    private final Context a;
    private final IdManager b;
    private final String c;
    private final String d;

    public sj(Context context, IdManager idManager, String string2, String string3) {
        this.a = context;
        this.b = idManager;
        this.c = string2;
        this.d = string3;
    }

    public sh a() {
        Map map = this.b.i();
        String string2 = this.b.c();
        String string3 = this.b.b();
        String string4 = (String)map.get((Object)IdManager.DeviceIdentifierType.d);
        String string5 = (String)map.get((Object)IdManager.DeviceIdentifierType.g);
        Boolean bl2 = this.b.l();
        String string6 = (String)map.get((Object)IdManager.DeviceIdentifierType.c);
        String string7 = CommonUtils.m((Context)this.a);
        String string8 = this.b.d();
        String string9 = this.b.g();
        return new sh(string2, UUID.randomUUID().toString(), string3, string4, string5, bl2, string6, string7, string8, string9, this.c, this.d);
    }
}

