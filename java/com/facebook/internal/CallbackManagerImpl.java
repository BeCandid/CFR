/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 */
package com.facebook.internal;

import android.content.Intent;
import java.util.HashMap;
import java.util.Map;

public final class CallbackManagerImpl
implements uj {
    private static Map<Integer, a> a = new HashMap();
    private Map<Integer, a> b = new HashMap();

    private static a a(Integer n2) {
        reference var3_1 = CallbackManagerImpl.class;
        synchronized (CallbackManagerImpl.class) {
            a a2 = (a)a.get((Object)n2);
            // ** MonitorExit[var3_1] (shouldn't be in output)
            return a2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(int n2, a a2) {
        reference var5_2 = CallbackManagerImpl.class;
        synchronized (CallbackManagerImpl.class) {
            wf.a(a2, "callback");
            boolean bl2 = a.containsKey((Object)n2);
            if (!bl2) {
                a.put((Object)n2, (Object)a2);
            }
            // ** MonitorExit[var5_2] (shouldn't be in output)
            return;
        }
    }

    private static boolean b(int n2, int n3, Intent intent) {
        a a2 = CallbackManagerImpl.a(n2);
        if (a2 != null) {
            return a2.a(n3, intent);
        }
        return false;
    }

    @Override
    public boolean a(int n2, int n3, Intent intent) {
        a a2 = (a)this.b.get((Object)n2);
        if (a2 != null) {
            return a2.a(n3, intent);
        }
        return CallbackManagerImpl.b(n2, n3, intent);
    }

    public void b(int n2, a a2) {
        wf.a(a2, "callback");
        this.b.put((Object)n2, (Object)a2);
    }

    public static final class RequestCodeOffset
    extends Enum<RequestCodeOffset> {
        public static final /* enum */ RequestCodeOffset a = new RequestCodeOffset(0);
        public static final /* enum */ RequestCodeOffset b = new RequestCodeOffset(1);
        public static final /* enum */ RequestCodeOffset c = new RequestCodeOffset(2);
        public static final /* enum */ RequestCodeOffset d = new RequestCodeOffset(3);
        public static final /* enum */ RequestCodeOffset e = new RequestCodeOffset(4);
        public static final /* enum */ RequestCodeOffset f = new RequestCodeOffset(5);
        public static final /* enum */ RequestCodeOffset g = new RequestCodeOffset(6);
        public static final /* enum */ RequestCodeOffset h = new RequestCodeOffset(7);
        public static final /* enum */ RequestCodeOffset i = new RequestCodeOffset(8);
        private static final /* synthetic */ RequestCodeOffset[] k;
        private final int j;

        static {
            RequestCodeOffset[] arrrequestCodeOffset = new RequestCodeOffset[]{a, b, c, d, e, f, g, h, i};
            k = arrrequestCodeOffset;
        }

        private RequestCodeOffset(int n3) {
            super(string2, n2);
            this.j = n3;
        }

        public static RequestCodeOffset valueOf(String string2) {
            return (RequestCodeOffset)Enum.valueOf((Class)RequestCodeOffset.class, (String)string2);
        }

        public static RequestCodeOffset[] values() {
            return (RequestCodeOffset[])k.clone();
        }

        public int a() {
            return ul.n() + this.j;
        }
    }

    public static interface a {
        public boolean a(int var1, Intent var2);
    }

}

