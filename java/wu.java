/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  java.lang.String
 */
import android.content.Context;
import android.os.Bundle;

final class wu
extends wa {
    private String a;

    wu(Context context, String string2, String string3) {
        super(context, 65542, 65543, 20141001, string2);
        this.a = string3;
    }

    @Override
    protected void a(Bundle bundle) {
        bundle.putString("com.facebook.platform.extra.OBJECT_ID", this.a);
    }
}

