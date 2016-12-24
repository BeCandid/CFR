/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.os.Binder
 *  android.os.RemoteException
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.SecurityException
 *  java.lang.String
 */
import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;

/*
 * Exception performing whole class analysis.
 */
public class xy
extends yt.a {
    int a;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Account a(yt yt2) {
        Account account = null;
        if (yt2 == null) return account;
        long l2 = Binder.clearCallingIdentity();
        try {
            Account account2;
            account = account2 = yt2.a();
        }
        catch (RemoteException remoteException) {
            Log.w((String)"AccountAccessor", (String)"Remote account accessor probably died");
            return null;
        }
        finally {
            Binder.restoreCallingIdentity((long)l2);
        }
        Binder.restoreCallingIdentity((long)l2);
        return account;
    }

    @Override
    public Account a() {
        int n2 = Binder.getCallingUid();
        if (n2 == this.a) {
            return null;
        }
        if (aac.zze(null, n2)) {
            this.a = n2;
            return null;
        }
        throw new SecurityException("Caller is not GooglePlayServices");
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof xy)) {
            return false;
        }
        (xy)object;
        return ((}
    java.lang.NullPointerException: Attempt to invoke interface method 'void org.benf.cfr.reader.bytecode.analysis.types.JavaTypeInstance.dumpInto(org.benf.cfr.reader.util.output.Dumper, org.benf.cfr.reader.state.TypeUsageInformation)' on a null object reference
    
    