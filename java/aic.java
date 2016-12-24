/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ResolveInfo
 *  android.content.pm.ServiceInfo
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.ConditionVariable
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.os.Messenger
 *  android.os.Parcelable
 *  android.os.Process
 *  android.os.RemoteException
 *  android.os.SystemClock
 *  android.text.TextUtils
 *  android.util.Log
 *  com.google.android.gms.iid.MessengerCompat
 *  java.io.IOException
 *  java.io.UnsupportedEncodingException
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.security.GeneralSecurityException
 *  java.security.KeyPair
 *  java.security.PrivateKey
 *  java.security.PublicKey
 *  java.security.Signature
 *  java.security.interfaces.RSAPrivateKey
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Random
 *  java.util.Set
 */
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.iid.MessengerCompat;
import com.google.firebase.iid.FirebaseInstanceId;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class aic {
    static String a = null;
    public static int b = 0;
    public static int c = 0;
    static int d = 0;
    Context e;
    Map<String, Object> f = new HashMap();
    Messenger g;
    Messenger h;
    MessengerCompat i;
    PendingIntent j;
    long k;
    long l;
    int m;
    int n;
    long o;

    public aic(Context context) {
        this.e = context;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static String a(Context context) {
        if (a != null) {
            return a;
        }
        b = Process.myUid();
        PackageManager packageManager = context.getPackageManager();
        Iterator iterator = packageManager.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0).iterator();
        do {
            if (iterator.hasNext()) {
                ResolveInfo resolveInfo = (ResolveInfo)iterator.next();
                if (packageManager.checkPermission("com.google.android.c2dm.permission.RECEIVE", resolveInfo.serviceInfo.packageName) == 0) {
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(resolveInfo.serviceInfo.packageName, 0);
                    int n2 = applicationInfo.uid;
                    Log.w((String)"InstanceID/Rpc", (String)new StringBuilder(17).append("Found ").append(n2).toString());
                    c = applicationInfo.uid;
                    a = resolveInfo.serviceInfo.packageName;
                    return a;
                }
                String string3 = String.valueOf((Object)resolveInfo.serviceInfo.packageName);
                String string4 = String.valueOf((Object)"com.google.android.c2dm.intent.REGISTER");
                Log.w((String)"InstanceID/Rpc", (String)new StringBuilder(56 + String.valueOf((Object)string3).length() + String.valueOf((Object)string4).length()).append("Possible malicious package ").append(string3).append(" declares ").append(string4).append(" without permission").toString());
                continue;
            }
            Log.w((String)"InstanceID/Rpc", (String)"Failed to resolve REGISTER intent, falling back");
            try {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                a = applicationInfo.packageName;
                c = applicationInfo.uid;
                return a;
            }
            catch (PackageManager.NameNotFoundException var4_12) {
                try {
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo("com.google.android.gsf", 0);
                    a = applicationInfo.packageName;
                    c = applicationInfo.uid;
                    return a;
                }
                catch (PackageManager.NameNotFoundException var5_15) {
                    Log.w((String)"InstanceID/Rpc", (String)"Both Google Play Services and legacy GSF package are missing");
                    return null;
                }
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                continue;
            }
            break;
        } while (true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static /* varargs */ String a(KeyPair keyPair, String ... arrstring) {
        byte[] arrby;
        try {
            arrby = TextUtils.join((CharSequence)"\n", (Object[])arrstring).getBytes("UTF-8");
        }
        catch (UnsupportedEncodingException var2_7) {
            Log.e((String)"InstanceID/Rpc", (String)"Unable to encode string", (Throwable)var2_7);
            return null;
        }
        try {
            PrivateKey privateKey = keyPair.getPrivate();
            String string2 = privateKey instanceof RSAPrivateKey ? "SHA256withRSA" : "SHA256withECDSA";
            Signature signature = Signature.getInstance((String)string2);
            signature.initSign(privateKey);
            signature.update(arrby);
            return FirebaseInstanceId.a(signature.sign());
        }
        catch (GeneralSecurityException var5_8) {
            Log.e((String)"InstanceID/Rpc", (String)"Unable to sign registration request", (Throwable)var5_8);
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(Object object) {
        Class class_;
        Class class_2 = class_ = this.getClass();
        synchronized (class_2) {
            Iterator iterator = this.f.keySet().iterator();
            while (iterator.hasNext()) {
                String string2 = (String)iterator.next();
                Object object2 = this.f.get((Object)string2);
                this.f.put((Object)string2, object);
                super.a(object2, object);
            }
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void a(Object object, Object object2) {
        if (object instanceof ConditionVariable) {
            ((ConditionVariable)object).open();
        }
        if (!(object instanceof Messenger)) return;
        Messenger messenger = (Messenger)object;
        Message message = Message.obtain();
        message.obj = object2;
        try {
            messenger.send(message);
            return;
        }
        catch (RemoteException var5_5) {
            String string2 = String.valueOf((Object)var5_5);
            Log.w((String)"InstanceID/Rpc", (String)new StringBuilder(24 + String.valueOf((Object)string2).length()).append("Failed to send response ").append(string2).toString());
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void a(String string2) {
        if (!"com.google.android.gsf".equals((Object)a)) {
            return;
        }
        this.m = 1 + this.m;
        if (this.m < 3) return;
        if (this.m == 3) {
            this.n = 1000 + new Random().nextInt(1000);
        }
        this.n = 2 * this.n;
        this.o = SystemClock.elapsedRealtime() + (long)this.n;
        int n2 = this.n;
        Log.w((String)"InstanceID/Rpc", (String)new StringBuilder(31 + String.valueOf((Object)string2).length()).append("Backoff due to ").append(string2).append(" for ").append(n2).toString());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(String string2, Object object) {
        Class class_;
        Class class_2 = class_ = this.getClass();
        synchronized (class_2) {
            Object object2 = this.f.get((Object)string2);
            this.f.put((Object)string2, object);
            super.a(object2, object);
            return;
        }
    }

    private static int b(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            int n2 = packageManager.getPackageInfo((String)aic.a((Context)context), (int)0).versionCode;
            return n2;
        }
        catch (PackageManager.NameNotFoundException var2_3) {
            return -1;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Intent b(Bundle bundle, KeyPair keyPair) throws IOException {
        Class class_;
        Class class_2;
        ConditionVariable conditionVariable = new ConditionVariable();
        String string2 = aic.b();
        Class class_3 = class_2 = this.getClass();
        synchronized (class_3) {
            this.f.put((Object)string2, (Object)conditionVariable);
        }
        this.a(bundle, keyPair, string2);
        conditionVariable.block(30000);
        Class class_4 = class_ = this.getClass();
        synchronized (class_4) {
            Object object = this.f.remove((Object)string2);
            if (object instanceof Intent) {
                return (Intent)object;
            }
            if (object instanceof String) {
                throw new IOException((String)object);
            }
            String string3 = String.valueOf((Object)object);
            Log.w((String)"InstanceID/Rpc", (String)new StringBuilder(12 + String.valueOf((Object)string3).length()).append("No response ").append(string3).toString());
            throw new IOException("TIMEOUT");
        }
    }

    public static String b() {
        reference var3 = aic.class;
        synchronized (aic.class) {
            int n2 = d;
            d = n2 + 1;
            String string2 = Integer.toString((int)n2);
            // ** MonitorExit[var3] (shouldn't be in output)
            return string2;
        }
    }

    Intent a(Bundle bundle, KeyPair keyPair) throws IOException {
        Intent intent = super.b(bundle, keyPair);
        if (intent != null && intent.hasExtra("google.messenger")) {
            intent = super.b(bundle, keyPair);
        }
        return intent;
    }

    void a() {
        if (this.g != null) {
            return;
        }
        aic.a(this.e);
        this.g = new Messenger(new Handler(Looper.getMainLooper()){

            public void handleMessage(Message message) {
                aic.this.a(message);
            }
        });
    }

    void a(Intent intent) {
        void var6_2 = this;
        synchronized (var6_2) {
            if (this.j == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                this.j = PendingIntent.getBroadcast((Context)this.e, (int)0, (Intent)intent2, (int)0);
            }
            intent.putExtra("app", (Parcelable)this.j);
            return;
        }
    }

    /*
     * Exception decompiling
     */
    protected void a(Intent var1, String var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.util.ConcurrentModificationException
        // java.util.LinkedList$ReverseLinkIterator.next(LinkedList.java:217)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.extractLabelledBlocks(Block.java:212)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:485)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.insertLabelledBlocks(Op04StructuredStatement.java:649)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:816)
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

    public void a(Bundle bundle, KeyPair keyPair, String string2) throws IOException {
        long l2 = SystemClock.elapsedRealtime();
        if (this.o != 0 && l2 <= this.o) {
            long l3 = this.o - l2;
            int n2 = this.n;
            Log.w((String)"InstanceID/Rpc", (String)new StringBuilder(78).append("Backoff mode, next request attempt: ").append(l3).append(" interval: ").append(n2).toString());
            throw new IOException("RETRY_LATER");
        }
        this.a();
        if (a == null) {
            throw new IOException("MISSING_INSTANCEID_SERVICE");
        }
        this.k = SystemClock.elapsedRealtime();
        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent.setPackage(a);
        bundle.putString("gmsv", Integer.toString((int)aic.b(this.e)));
        bundle.putString("osv", Integer.toString((int)Build.VERSION.SDK_INT));
        bundle.putString("app_ver", Integer.toString((int)FirebaseInstanceId.b(this.e)));
        bundle.putString("app_ver_name", FirebaseInstanceId.c(this.e));
        bundle.putString("cliv", "1");
        bundle.putString("appid", FirebaseInstanceId.a(keyPair));
        String string3 = FirebaseInstanceId.a(this.e);
        if (string3 != null) {
            bundle.putString("gmp_app_id", string3);
        }
        String string4 = FirebaseInstanceId.a(keyPair.getPublic().getEncoded());
        bundle.putString("pub2", string4);
        String[] arrstring = new String[]{this.e.getPackageName(), string4};
        bundle.putString("sig", aic.a(keyPair, arrstring));
        intent.putExtras(bundle);
        this.a(intent);
        this.a(intent, string2);
    }

    public void a(Message message) {
        if (message == null) {
            return;
        }
        if (message.obj instanceof Intent) {
            Intent intent = (Intent)message.obj;
            intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
            if (intent.hasExtra("google.messenger")) {
                Parcelable parcelable = intent.getParcelableExtra("google.messenger");
                if (parcelable instanceof MessengerCompat) {
                    this.i = (MessengerCompat)parcelable;
                }
                if (parcelable instanceof Messenger) {
                    this.h = (Messenger)parcelable;
                }
            }
            this.d((Intent)message.obj);
            return;
        }
        Log.w((String)"InstanceID/Rpc", (String)"Dropping invalid message");
    }

    String b(Intent intent) throws IOException {
        if (intent == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String string2 = intent.getStringExtra("registration_id");
        if (string2 == null) {
            string2 = intent.getStringExtra("unregistered");
        }
        if (string2 == null) {
            String string3 = intent.getStringExtra("error");
            if (string3 != null) {
                throw new IOException(string3);
            }
            String string4 = String.valueOf((Object)intent.getExtras());
            Log.w((String)"InstanceID/Rpc", (String)new StringBuilder(29 + String.valueOf((Object)string4).length()).append("Unexpected response from GCM ").append(string4).toString(), (Throwable)new Throwable());
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     */
    void c(Intent intent) {
        String string2 = intent.getStringExtra("error");
        if (string2 == null) {
            String string3 = String.valueOf((Object)intent.getExtras());
            Log.w((String)"InstanceID/Rpc", (String)new StringBuilder(49 + String.valueOf((Object)string3).length()).append("Unexpected response, no error or registration id ").append(string3).toString());
            return;
        } else {
            String string4;
            String string5;
            long l2;
            if (Log.isLoggable((String)"InstanceID/Rpc", (int)3)) {
                String string6 = String.valueOf((Object)string2);
                String string7 = string6.length() != 0 ? "Received InstanceID error ".concat(string6) : new String("Received InstanceID error ");
                Log.d((String)"InstanceID/Rpc", (String)string7);
            }
            if (string2.startsWith("|")) {
                String[] arrstring = string2.split("\\|");
                if (!"ID".equals((Object)arrstring[1])) {
                    String string8 = String.valueOf((Object)string2);
                    String string9 = string8.length() != 0 ? "Unexpected structured response ".concat(string8) : new String("Unexpected structured response ");
                    Log.w((String)"InstanceID/Rpc", (String)string9);
                }
                if (arrstring.length > 2) {
                    string5 = arrstring[2];
                    string4 = arrstring[3];
                    if (string4.startsWith(":")) {
                        string4 = string4.substring(1);
                    }
                } else {
                    string4 = "UNKNOWN";
                    string5 = null;
                }
                intent.putExtra("error", string4);
            } else {
                string4 = string2;
                string5 = null;
            }
            if (string5 == null) {
                super.a((Object)string4);
            } else {
                super.a(string5, (Object)string4);
            }
            if ((l2 = intent.getLongExtra("Retry-After", 0)) > 0) {
                this.l = SystemClock.elapsedRealtime();
                this.n = 1000 * (int)l2;
                this.o = SystemClock.elapsedRealtime() + (long)this.n;
                int n2 = this.n;
                Log.w((String)"InstanceID/Rpc", (String)new StringBuilder(52).append("Explicit request from server to backoff: ").append(n2).toString());
                return;
            }
            if (!"SERVICE_NOT_AVAILABLE".equals((Object)string4) && !"AUTHENTICATION_FAILED".equals((Object)string4)) return;
            {
                super.a(string4);
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void d(Intent intent) {
        String string2;
        if (intent == null) {
            if (!Log.isLoggable((String)"InstanceID/Rpc", (int)3)) return;
            Log.d((String)"InstanceID/Rpc", (String)"Unexpected response: null");
            return;
        }
        if (!"com.google.android.c2dm.intent.REGISTRATION".equals((Object)intent.getAction())) {
            if (!Log.isLoggable((String)"InstanceID/Rpc", (int)3)) return;
            String string3 = String.valueOf((Object)intent.getAction());
            String string4 = string3.length() != 0 ? "Unexpected response ".concat(string3) : new String("Unexpected response ");
            Log.d((String)"InstanceID/Rpc", (String)string4);
            return;
        }
        String string5 = intent.getStringExtra("registration_id");
        if (string5 == null) {
            string5 = intent.getStringExtra("unregistered");
        }
        if (string5 == null) {
            this.c(intent);
            return;
        }
        this.k = SystemClock.elapsedRealtime();
        this.o = 0;
        this.m = 0;
        this.n = 0;
        if (Log.isLoggable((String)"InstanceID/Rpc", (int)3)) {
            String string6 = String.valueOf((Object)intent.getExtras());
            Log.d((String)"InstanceID/Rpc", (String)new StringBuilder(16 + String.valueOf((Object)string5).length() + String.valueOf((Object)string6).length()).append("AppIDResponse: ").append(string5).append(" ").append(string6).toString());
        }
        if (string5.startsWith("|")) {
            String string7;
            String[] arrstring = string5.split("\\|");
            if (!"ID".equals((Object)arrstring[1])) {
                String string8 = String.valueOf((Object)string5);
                String string9 = string8.length() != 0 ? "Unexpected structured response ".concat(string8) : new String("Unexpected structured response ");
                Log.w((String)"InstanceID/Rpc", (String)string9);
            }
            String string10 = arrstring[2];
            if (arrstring.length > 4) {
                if ("SYNC".equals((Object)arrstring[3])) {
                    FirebaseInstanceId.d(this.e);
                } else if ("RST".equals((Object)arrstring[3])) {
                    FirebaseInstanceId.a(this.e, aia.a(this.e, null).c());
                    intent.removeExtra("registration_id");
                    super.a(string10, (Object)intent);
                    return;
                }
            }
            if ((string7 = arrstring[-1 + arrstring.length]).startsWith(":")) {
                string7 = string7.substring(1);
            }
            intent.putExtra("registration_id", string7);
            string2 = string10;
        } else {
            string2 = null;
        }
        if (string2 == null) {
            super.a((Object)intent);
            return;
        }
        super.a(string2, (Object)intent);
    }

}

