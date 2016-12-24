/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
import com.google.firebase.iid.FirebaseInstanceId;

public class ahz {
    private final FirebaseInstanceId a;

    private ahz(FirebaseInstanceId firebaseInstanceId) {
        this.a = firebaseInstanceId;
    }

    public static ahz a() {
        return new ahz(FirebaseInstanceId.a());
    }

    public String b() {
        return this.a.c();
    }
}

