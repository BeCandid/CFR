/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ActivityInfo
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ResolveInfo
 *  android.content.pm.ServiceInfo
 *  android.content.pm.Signature
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Bundle
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.TreeSet
 *  java.util.UUID
 *  java.util.concurrent.atomic.AtomicBoolean
 */
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.login.DefaultAudience;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public final class vz {
    private static final String a = vz.class.getName();
    private static List<c> b = vz.e();
    private static Map<String, List<c>> c = vz.f();
    private static AtomicBoolean d = new AtomicBoolean(false);
    private static final List<Integer> e;

    static {
        Object[] arrobject = new Integer[]{20160327, 20141218, 20141107, 20141028, 20141001, 20140701, 20140324, 20140204, 20131107, 20130618, 20130502, 20121101};
        e = Arrays.asList((Object[])arrobject);
    }

    public static final int a() {
        return (Integer)e.get(0);
    }

    public static int a(Intent intent) {
        return intent.getIntExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 0);
    }

    public static int a(String string2, int[] arrn) {
        return vz.a((List)c.get((Object)string2), arrn);
    }

    private static int a(List<c> list, int[] arrn) {
        vz.b();
        if (list == null) {
            return -1;
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            int n2 = vz.a(((c)iterator.next()).b(), vz.a(), arrn);
            if (n2 == -1) continue;
            return n2;
        }
        return -1;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int a(TreeSet<Integer> treeSet, int n2, int[] arrn) {
        int n3;
        int n4 = -1 + arrn.length;
        Iterator iterator = treeSet.descendingIterator();
        int n5 = -1;
        do {
            if (!iterator.hasNext()) return -1;
            n3 = (Integer)iterator.next();
            n5 = Math.max((int)n5, (int)n3);
            while (n4 >= 0 && arrn[n4] > n3) {
                --n4;
            }
            if (n4 >= 0) continue;
            return -1;
        } while (arrn[n4] != n3);
        if (n4 % 2 != 0) return -1;
        return Math.min((int)n5, (int)n2);
    }

    public static Intent a(Context context) {
        for (c c2 : b) {
            Intent intent = vz.b(context, new Intent("com.facebook.platform.PLATFORM_SERVICE").setPackage(c2.a()).addCategory("android.intent.category.DEFAULT"), c2);
            if (intent == null) continue;
            return intent;
        }
        return null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static Intent a(Context context, Intent intent, c c2) {
        if (intent == null) {
            return null;
        }
        ResolveInfo resolveInfo = context.getPackageManager().resolveActivity(intent, 0);
        if (resolveInfo == null) {
            return null;
        }
        if (c2.a(context, resolveInfo.activityInfo.packageName)) return intent;
        return null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static Intent a(Context context, String string2, String string3) {
        c c2;
        List list = (List)c.get((Object)string3);
        if (list == null) {
            return null;
        }
        Intent intent = null;
        Iterator iterator = list.iterator();
        do {
            if (!iterator.hasNext()) return intent;
            c2 = (c)iterator.next();
        } while ((intent = vz.a(context, new Intent().setAction(string2).setPackage(c2.a()).addCategory("android.intent.category.DEFAULT"), c2)) == null);
        return intent;
    }

    public static Intent a(Context context, String string2, String string3, int n2, Bundle bundle) {
        Intent intent = vz.a(context, "com.facebook.platform.PLATFORM_ACTIVITY", string3);
        if (intent == null) {
            return null;
        }
        vz.a(intent, string2, string3, n2, bundle);
        return intent;
    }

    public static Intent a(Context context, String string2, Collection<String> collection, String string3, boolean bl2, boolean bl3, DefaultAudience defaultAudience, String string4) {
        for (c c2 : b) {
            Intent intent;
            Intent intent2 = new Intent().setClassName(c2.a(), "com.facebook.katana.ProxyAuth").putExtra("client_id", string2);
            if (!we.a(collection)) {
                intent2.putExtra("scope", TextUtils.join((CharSequence)",", collection));
            }
            if (!we.a(string3)) {
                intent2.putExtra("e2e", string3);
            }
            intent2.putExtra("state", string4);
            intent2.putExtra("response_type", "token,signed_request");
            intent2.putExtra("return_scopes", "true");
            if (bl3) {
                intent2.putExtra("default_audience", defaultAudience.a());
            }
            intent2.putExtra("legacy_override", "v2.6");
            if (bl2) {
                intent2.putExtra("auth_type", "rerequest");
            }
            if ((intent = vz.a(context, intent2, c2)) == null) continue;
            return intent;
        }
        return null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Intent a(Intent intent, Bundle bundle, FacebookException facebookException) {
        UUID uUID = vz.b(intent);
        if (uUID == null) {
            return null;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", vz.a(intent));
        Bundle bundle2 = new Bundle();
        bundle2.putString("action_id", uUID.toString());
        if (facebookException != null) {
            bundle2.putBundle("error", vz.a(facebookException));
        }
        intent2.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", bundle2);
        if (bundle == null) return intent2;
        intent2.putExtra("com.facebook.platform.protocol.RESULT_ARGS", bundle);
        return intent2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Bundle a(FacebookException facebookException) {
        if (facebookException == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("error_description", facebookException.toString());
        if (!(facebookException instanceof FacebookOperationCanceledException)) return bundle;
        bundle.putString("error_type", "UserCanceled");
        return bundle;
    }

    public static FacebookException a(Bundle bundle) {
        String string2;
        if (bundle == null) {
            return null;
        }
        String string3 = bundle.getString("error_type");
        if (string3 == null) {
            string3 = bundle.getString("com.facebook.platform.status.ERROR_TYPE");
        }
        if ((string2 = bundle.getString("error_description")) == null) {
            string2 = bundle.getString("com.facebook.platform.status.ERROR_DESCRIPTION");
        }
        if (string3 != null && string3.equalsIgnoreCase("UserCanceled")) {
            return new FacebookOperationCanceledException(string2);
        }
        return new FacebookException(string2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void a(Intent intent, String string2, String string3, int n2, Bundle bundle) {
        String string4 = ul.i();
        String string5 = ul.j();
        intent.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", n2).putExtra("com.facebook.platform.protocol.PROTOCOL_ACTION", string3).putExtra("com.facebook.platform.extra.APPLICATION_ID", string4);
        if (vz.a(n2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("action_id", string2);
            we.a(bundle2, "app_name", string5);
            intent.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", bundle2);
            Bundle bundle3 = bundle == null ? new Bundle() : bundle;
            intent.putExtra("com.facebook.platform.protocol.METHOD_ARGS", bundle3);
            return;
        }
        intent.putExtra("com.facebook.platform.protocol.CALL_ID", string2);
        if (!we.a(string5)) {
            intent.putExtra("com.facebook.platform.extra.APPLICATION_NAME", string5);
        }
        intent.putExtras(bundle);
    }

    public static boolean a(int n2) {
        if (e.contains((Object)n2) && n2 >= 20140701) {
            return true;
        }
        return false;
    }

    public static int b(int n2) {
        return vz.a(b, new int[]{n2});
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static Intent b(Context context, Intent intent, c c2) {
        if (intent == null) {
            return null;
        }
        ResolveInfo resolveInfo = context.getPackageManager().resolveService(intent, 0);
        if (resolveInfo == null) {
            return null;
        }
        if (c2.a(context, resolveInfo.serviceInfo.packageName)) return intent;
        return null;
    }

    /*
     * Exception decompiling
     */
    private static TreeSet<Integer> b(c var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 4[CATCHBLOCK]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2859)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:805)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static UUID b(Intent intent) {
        String string2;
        if (intent == null) return null;
        if (vz.a(vz.a(intent))) {
            Bundle bundle = intent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
            string2 = null;
            if (bundle == null) return null;
            string2 = bundle.getString("action_id");
        } else {
            string2 = intent.getStringExtra("com.facebook.platform.protocol.CALL_ID");
        }
        if (string2 == null) {
            return null;
        }
        try {
            return UUID.fromString((String)string2);
        }
        catch (IllegalArgumentException var2_4) {
            return null;
        }
    }

    public static void b() {
        if (!d.compareAndSet(false, true)) {
            return;
        }
        ul.d().execute(new Runnable(){

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public void run() {
                try {
                    Iterator iterator = b.iterator();
                    while (iterator.hasNext()) {
                        ((c)iterator.next()).a(true);
                    }
                    return;
                }
                finally {
                    d.set(false);
                }
            }
        });
    }

    private static Uri c(c c2) {
        return Uri.parse((String)("content://" + c2.a() + ".provider.PlatformProvider/versions"));
    }

    public static Bundle c(Intent intent) {
        if (!vz.a(vz.a(intent))) {
            return null;
        }
        return intent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
    }

    public static Bundle d(Intent intent) {
        if (!vz.a(vz.a(intent))) {
            return intent.getExtras();
        }
        return intent.getBundleExtra("com.facebook.platform.protocol.METHOD_ARGS");
    }

    public static Bundle e(Intent intent) {
        int n2 = vz.a(intent);
        Bundle bundle = intent.getExtras();
        if (!vz.a(n2) || bundle == null) {
            return bundle;
        }
        return bundle.getBundle("com.facebook.platform.protocol.RESULT_ARGS");
    }

    private static List<c> e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object)new a(null));
        arrayList.add((Object)new d(null));
        return arrayList;
    }

    private static Map<String, List<c>> f() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object)new b(null));
        hashMap.put((Object)"com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG", b);
        hashMap.put((Object)"com.facebook.platform.action.request.FEED_DIALOG", b);
        hashMap.put((Object)"com.facebook.platform.action.request.LIKE_DIALOG", b);
        hashMap.put((Object)"com.facebook.platform.action.request.APPINVITES_DIALOG", b);
        hashMap.put((Object)"com.facebook.platform.action.request.MESSAGE_DIALOG", (Object)arrayList);
        hashMap.put((Object)"com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG", (Object)arrayList);
        return hashMap;
    }

    public static boolean f(Intent intent) {
        Bundle bundle = vz.c(intent);
        if (bundle != null) {
            return bundle.containsKey("error");
        }
        return intent.hasExtra("com.facebook.platform.status.ERROR_TYPE");
    }

    public static Bundle g(Intent intent) {
        if (!vz.f(intent)) {
            return null;
        }
        Bundle bundle = vz.c(intent);
        if (bundle != null) {
            return bundle.getBundle("error");
        }
        return intent.getExtras();
    }

    static class a
    extends c {
        private a() {
            super(null);
        }

        /* synthetic */ a( var1) {
        }

        @Override
        protected String a() {
            return "com.facebook.katana";
        }
    }

    static class b
    extends c {
        private b() {
            super(null);
        }

        /* synthetic */ b( var1) {
        }

        @Override
        protected String a() {
            return "com.facebook.orca";
        }
    }

    static abstract class c {
        private static final HashSet<String> a = c.c();
        private TreeSet<Integer> b;

        private c() {
        }

        /* synthetic */ c( var1) {
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        private void a(boolean bl2) {
            void var3_2 = this;
            synchronized (var3_2) {
                if (bl2 || this.b == null) {
                    this.b = vz.b((c)this);
                }
                return;
            }
        }

        private static HashSet<String> c() {
            HashSet hashSet = new HashSet();
            hashSet.add((Object)"8a3c4b262d721acd49a4bf97d5213199c86fa2b9");
            hashSet.add((Object)"a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc");
            hashSet.add((Object)"5e8f16062ea3cd2c4a0d547876baa6f38cabf625");
            return hashSet;
        }

        protected abstract String a();

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        public boolean a(Context context, String string2) {
            Signature[] arrsignature;
            String string3 = Build.BRAND;
            int n2 = context.getApplicationInfo().flags;
            if (string3.startsWith("generic") && (n2 & 2) != 0) {
                return true;
            }
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(string2, 64);
                arrsignature = packageInfo.signatures;
            }
            catch (PackageManager.NameNotFoundException var5_10) {
                return false;
            }
            int n3 = arrsignature.length;
            int n4 = 0;
            while (n4 < n3) {
                String string4 = we.a(arrsignature[n4].toByteArray());
                if (a.contains((Object)string4)) return true;
                ++n4;
            }
            return false;
        }

        public TreeSet<Integer> b() {
            if (this.b == null) {
                this.a(false);
            }
            return this.b;
        }
    }

    static class d
    extends c {
        private d() {
            super(null);
        }

        /* synthetic */ d( var1) {
        }

        @Override
        protected String a() {
            return "com.facebook.wakizashi";
        }
    }

}

