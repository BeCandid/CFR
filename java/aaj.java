/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  java.lang.Boolean
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.Callable
 */
import android.content.SharedPreferences;
import java.util.concurrent.Callable;

public abstract class aaj<T> {

    public static class a
    extends aaj<Boolean> {
        public static Boolean a(SharedPreferences sharedPreferences, final String string2, final Boolean bl2) {
            return (Boolean)abx.a(new Callable<Boolean>(){

                public Boolean a() {
                    return SharedPreferences.this.getBoolean(string2, bl2.booleanValue());
                }

                public /* synthetic */ Object call() throws Exception {
                    return this.a();
                }
            });
        }

    }

    public static class b
    extends aaj<Integer> {
        public static Integer a(SharedPreferences sharedPreferences, final String string2, final Integer n2) {
            return (Integer)abx.a(new Callable<Integer>(){

                public Integer a() {
                    return SharedPreferences.this.getInt(string2, n2.intValue());
                }

                public /* synthetic */ Object call() throws Exception {
                    return this.a();
                }
            });
        }

    }

    public static class c
    extends aaj<Long> {
        public static Long a(SharedPreferences sharedPreferences, final String string2, final Long l2) {
            return (Long)abx.a(new Callable<Long>(){

                public Long a() {
                    return SharedPreferences.this.getLong(string2, l2.longValue());
                }

                public /* synthetic */ Object call() throws Exception {
                    return this.a();
                }
            });
        }

    }

    public static class d
    extends aaj<String> {
        public static String a(SharedPreferences sharedPreferences, final String string2, final String string3) {
            return (String)abx.a(new Callable<String>(){

                public String a() {
                    return SharedPreferences.this.getString(string2, string3);
                }

                public /* synthetic */ Object call() throws Exception {
                    return this.a();
                }
            });
        }

    }

}

