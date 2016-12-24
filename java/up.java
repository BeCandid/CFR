/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.Bundle
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Date
 *  java.util.Map
 *  java.util.Set
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.AccessTokenSource;
import com.facebook.LoggingBehavior;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class up {
    private static final String a = up.class.getSimpleName();
    private String b;
    private SharedPreferences c;

    public up(Context context) {
        super(context, null);
    }

    public up(Context context, String string2) {
        wf.a((Object)context, "context");
        if (we.a(string2)) {
            string2 = "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY";
        }
        this.b = string2;
        Context context2 = context.getApplicationContext();
        if (context2 != null) {
            context = context2;
        }
        this.c = context.getSharedPreferences(this.b, 0);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static Date a(Bundle bundle, String string2) {
        long l2;
        if (bundle == null || (l2 = bundle.getLong(string2, Long.MIN_VALUE)) == Long.MIN_VALUE) {
            return null;
        }
        return new Date(l2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(String string2, Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject(this.c.getString(string2, "{}"));
        String string3 = jSONObject.getString("valueType");
        if (string3.equals((Object)"bool")) {
            bundle.putBoolean(string2, jSONObject.getBoolean("value"));
            return;
        }
        if (string3.equals((Object)"bool[]")) {
            JSONArray jSONArray = jSONObject.getJSONArray("value");
            boolean[] arrbl = new boolean[jSONArray.length()];
            int n2 = 0;
            do {
                if (n2 >= arrbl.length) {
                    bundle.putBooleanArray(string2, arrbl);
                    return;
                }
                arrbl[n2] = jSONArray.getBoolean(n2);
                ++n2;
            } while (true);
        }
        if (string3.equals((Object)"byte")) {
            bundle.putByte(string2, (byte)jSONObject.getInt("value"));
            return;
        }
        if (string3.equals((Object)"byte[]")) {
            JSONArray jSONArray = jSONObject.getJSONArray("value");
            byte[] arrby = new byte[jSONArray.length()];
            int n3 = 0;
            do {
                if (n3 >= arrby.length) {
                    bundle.putByteArray(string2, arrby);
                    return;
                }
                arrby[n3] = (byte)jSONArray.getInt(n3);
                ++n3;
            } while (true);
        }
        if (string3.equals((Object)"short")) {
            bundle.putShort(string2, (short)jSONObject.getInt("value"));
            return;
        }
        if (string3.equals((Object)"short[]")) {
            JSONArray jSONArray = jSONObject.getJSONArray("value");
            short[] arrs = new short[jSONArray.length()];
            int n4 = 0;
            do {
                if (n4 >= arrs.length) {
                    bundle.putShortArray(string2, arrs);
                    return;
                }
                arrs[n4] = (short)jSONArray.getInt(n4);
                ++n4;
            } while (true);
        }
        if (string3.equals((Object)"int")) {
            bundle.putInt(string2, jSONObject.getInt("value"));
            return;
        }
        if (string3.equals((Object)"int[]")) {
            JSONArray jSONArray = jSONObject.getJSONArray("value");
            int[] arrn = new int[jSONArray.length()];
            int n5 = 0;
            do {
                if (n5 >= arrn.length) {
                    bundle.putIntArray(string2, arrn);
                    return;
                }
                arrn[n5] = jSONArray.getInt(n5);
                ++n5;
            } while (true);
        }
        if (string3.equals((Object)"long")) {
            bundle.putLong(string2, jSONObject.getLong("value"));
            return;
        }
        if (string3.equals((Object)"long[]")) {
            JSONArray jSONArray = jSONObject.getJSONArray("value");
            long[] arrl = new long[jSONArray.length()];
            int n6 = 0;
            do {
                if (n6 >= arrl.length) {
                    bundle.putLongArray(string2, arrl);
                    return;
                }
                arrl[n6] = jSONArray.getLong(n6);
                ++n6;
            } while (true);
        }
        if (string3.equals((Object)"float")) {
            bundle.putFloat(string2, (float)jSONObject.getDouble("value"));
            return;
        }
        if (string3.equals((Object)"float[]")) {
            JSONArray jSONArray = jSONObject.getJSONArray("value");
            float[] arrf = new float[jSONArray.length()];
            int n7 = 0;
            do {
                if (n7 >= arrf.length) {
                    bundle.putFloatArray(string2, arrf);
                    return;
                }
                arrf[n7] = (float)jSONArray.getDouble(n7);
                ++n7;
            } while (true);
        }
        if (string3.equals((Object)"double")) {
            bundle.putDouble(string2, jSONObject.getDouble("value"));
            return;
        }
        if (string3.equals((Object)"double[]")) {
            JSONArray jSONArray = jSONObject.getJSONArray("value");
            double[] arrd = new double[jSONArray.length()];
            int n8 = 0;
            do {
                if (n8 >= arrd.length) {
                    bundle.putDoubleArray(string2, arrd);
                    return;
                }
                arrd[n8] = jSONArray.getDouble(n8);
                ++n8;
            } while (true);
        }
        if (string3.equals((Object)"char")) {
            String string4 = jSONObject.getString("value");
            if (string4 == null || string4.length() != 1) return;
            {
                bundle.putChar(string2, string4.charAt(0));
                return;
            }
        }
        if (string3.equals((Object)"char[]")) {
            JSONArray jSONArray = jSONObject.getJSONArray("value");
            char[] arrc = new char[jSONArray.length()];
            int n9 = 0;
            do {
                if (n9 >= arrc.length) {
                    bundle.putCharArray(string2, arrc);
                    return;
                }
                String string5 = jSONArray.getString(n9);
                if (string5 != null && string5.length() == 1) {
                    arrc[n9] = string5.charAt(0);
                }
                ++n9;
            } while (true);
        }
        if (string3.equals((Object)"string")) {
            bundle.putString(string2, jSONObject.getString("value"));
            return;
        }
        if (!string3.equals((Object)"stringList")) {
            if (!string3.equals((Object)"enum")) return;
            try {
                bundle.putSerializable(string2, (Serializable)Enum.valueOf((Class)Class.forName((String)jSONObject.getString("enumType")), (String)jSONObject.getString("value")));
                return;
            }
            catch (ClassNotFoundException var6_37) {
                return;
            }
            catch (IllegalArgumentException var5_38) {
                return;
            }
        }
        JSONArray jSONArray = jSONObject.getJSONArray("value");
        int n10 = jSONArray.length();
        ArrayList arrayList = new ArrayList(n10);
        int n11 = 0;
        do {
            if (n11 >= n10) {
                bundle.putStringArrayList(string2, arrayList);
                return;
            }
            Object object = jSONArray.get(n11);
            String string6 = object == JSONObject.NULL ? null : (String)object;
            arrayList.add(n11, (Object)string6);
            ++n11;
        } while (true);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static boolean a(Bundle bundle) {
        String string2;
        if (bundle == null || (string2 = bundle.getString("com.facebook.TokenCachingStrategy.Token")) == null || string2.length() == 0 || bundle.getLong("com.facebook.TokenCachingStrategy.ExpirationDate", 0) == 0) {
            return false;
        }
        return true;
    }

    public static String b(Bundle bundle) {
        wf.a((Object)bundle, "bundle");
        return bundle.getString("com.facebook.TokenCachingStrategy.Token");
    }

    public static AccessTokenSource c(Bundle bundle) {
        wf.a((Object)bundle, "bundle");
        if (bundle.containsKey("com.facebook.TokenCachingStrategy.AccessTokenSource")) {
            return (AccessTokenSource)bundle.getSerializable("com.facebook.TokenCachingStrategy.AccessTokenSource");
        }
        if (bundle.getBoolean("com.facebook.TokenCachingStrategy.IsSSO")) {
            return AccessTokenSource.b;
        }
        return AccessTokenSource.e;
    }

    public static String d(Bundle bundle) {
        wf.a((Object)bundle, "bundle");
        return bundle.getString("com.facebook.TokenCachingStrategy.ApplicationId");
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        for (String string2 : this.c.getAll().keySet()) {
            try {
                this.a(string2, bundle);
                continue;
            }
            catch (JSONException var4_4) {
                vx.a(LoggingBehavior.d, 5, a, "Error reading cached value for key: '" + string2 + "' -- " + (Object)var4_4);
                bundle = null;
                break;
            }
        }
        return bundle;
    }

    public void b() {
        this.c.edit().clear().apply();
    }
}

