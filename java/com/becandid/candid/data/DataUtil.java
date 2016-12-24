/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.util.Log
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.Type
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package com.becandid.candid.data;

import android.net.Uri;
import android.util.Log;
import com.becandid.candid.data.TextTag;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataUtil {
    static final char[] ALPHABET;
    static char[] ALPHABET_MAP;
    public static final Pattern encoded_ids_re;
    public static aih gson;

    static {
        gson = new aih();
        ALPHABET = "a34GpuRDcYZtwyzqhLndA9Qrf7MgoJl8Ik25sWBx_jmNCFSiK-PX10veTOEHUbV6".toCharArray();
        ALPHABET_MAP = new char[]{'\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '1', '\u0000', '\u0000', '5', '4', '\"', '\u0001', '\u0002', '#', '?', '\u0019', '\u001f', '\u0015', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0014', '&', ',', '\u0007', ':', '-', '\u0003', ';', ' ', '\u001d', '0', '\u0011', '\u001a', '+', '9', '2', '\u0016', '\u0006', '.', '8', '<', '>', '%', '3', '\t', '\n', '\u0000', '\u0000', '\u0000', '\u0000', '(', '\u0000', '\u0000', '=', '\b', '\u0013', '7', '\u0018', '\u001b', '\u0010', '/', ')', '!', '\u001e', '*', '\u0012', '\u001c', '\u0004', '\u000f', '\u0017', '$', '\u000b', '\u0005', '6', '\f', '\'', '\r', '\u000e', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000'};
        encoded_ids_re = Pattern.compile((String)"\"encoded_(post_id|user_id|comment_id|group_id|last_activity_id|activity_id|referral_post_id|related_to_post)\": ?\"([^\"]+)\"");
    }

    public static long decodeId(String string2) {
        long l2 = 0;
        for (int i2 = -1 + string2.length(); i2 >= 0; --i2) {
            l2 = (l2 << 6) + (long)ALPHABET_MAP[string2.charAt(i2)];
        }
        return DataUtil.shuffle_bits(1487642837374375497L ^ l2);
    }

    public static String decodeIds(String string2) {
        StringBuffer stringBuffer = new StringBuffer();
        Matcher matcher = encoded_ids_re.matcher((CharSequence)string2);
        while (matcher.find()) {
            long l2 = DataUtil.decodeId(matcher.group(2));
            matcher.appendReplacement(stringBuffer, "\"" + matcher.group(1) + "\":" + l2);
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public static String getEncodedId(Uri uri) {
        String string2 = null;
        if (uri != null) {
            List list = uri.getPathSegments();
            string2 = null;
            if (list != null) {
                boolean bl2 = uri.getPathSegments().isEmpty();
                string2 = null;
                if (!bl2) {
                    int n2 = uri.getPathSegments().size();
                    string2 = null;
                    if (n2 >= 2) {
                        string2 = (String)uri.getPathSegments().get(1);
                    }
                }
            }
        }
        return string2;
    }

    public static String join(List<String> list) {
        return DataUtil.join(list, ",");
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String join(List<String> list, String string2) {
        if (list == null) {
            rj.a(new Throwable("list fbinfo friend ids is NULL"));
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl2 = true;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            String string3 = (String)iterator.next();
            if (bl2) {
                bl2 = false;
            } else {
                stringBuilder.append(string2);
            }
            stringBuilder.append(string3);
        }
        return stringBuilder.toString();
    }

    public static /* varargs */ ain newJsonObject(String ... arrstring) {
        if (arrstring.length % 2 != 0) {
            Log.e((String)"DataUtil", (String)"Bad ");
        }
        ain ain2 = new ain();
        for (int i2 = 0; i2 < arrstring.length; i2 += 2) {
            ain2.a(arrstring[i2], arrstring[i2 + 1]);
        }
        return ain2;
    }

    public static long shuffle_bits(long l2) {
        long l3 = 0;
        for (int i2 = 0; i2 < 64; ++i2) {
            l3 <<= 1;
            if ((l2 & 1 << i2 / 8 + 8 * (i2 % 8)) == 0) continue;
            l3 |= 1;
        }
        return l3;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void sortTextTags(ArrayList<TextTag> arrayList, int n2, int n3) {
        if (n2 < n3) {
            int n4 = (n2 + n3) / 2;
            DataUtil.sortTextTags(arrayList, n2, n4);
            DataUtil.sortTextTags(arrayList, n4 + 1, n3);
            int n5 = n2;
            int n6 = n4 + 1;
            if (((TextTag)arrayList.get((int)n4)).startIndex > ((TextTag)arrayList.get((int)n6)).startIndex) {
                while (n5 <= n4 && n6 <= n3) {
                    if (((TextTag)arrayList.get((int)n5)).startIndex <= ((TextTag)arrayList.get((int)n6)).startIndex) {
                        ++n5;
                        continue;
                    }
                    TextTag textTag = (TextTag)arrayList.get(n6);
                    ArrayList arrayList2 = new ArrayList((Collection)arrayList.subList(n5, n6));
                    int n7 = n5 + 1;
                    Iterator iterator = arrayList2.iterator();
                    while (iterator.hasNext()) {
                        arrayList.set(n7, (Object)((TextTag)iterator.next()));
                        ++n7;
                    }
                    arrayList.set(n5, (Object)textTag);
                    ++n5;
                    ++n4;
                    ++n6;
                }
            }
        }
    }

    public static boolean toBoolean(Object object, boolean bl2) {
        if (object instanceof Number) {
            if (((Number)object).intValue() != 0) {
                return true;
            }
            return false;
        }
        if (object instanceof Boolean) {
            return (Boolean)object;
        }
        return bl2;
    }

    public static float toFloat(Object object, float f2) {
        if (object instanceof Number) {
            f2 = ((Number)object).floatValue();
        }
        return f2;
    }

    public static int toInt(Object object, int n2) {
        if (object instanceof Number) {
            return ((Number)object).intValue();
        }
        if (object instanceof Boolean) {
            if (((Boolean)object).booleanValue()) {
                return 1;
            }
            return 0;
        }
        return n2;
    }

    public static String toJson(Object object) {
        return gson.a(object);
    }

    public static <T> List<T> toList(aij aij2, Class<T> class_) {
        int n2 = aij2.a();
        ArrayList arrayList = new ArrayList(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            arrayList.add(gson.a(aij2.a(i2), class_));
        }
        return arrayList;
    }

    public static Map<String, Object> toMap(ain ain2) {
        Type type = new aju<Map<String, Object>>(){}.getType();
        return (Map)gson.a((ail)ain2, type);
    }

    public static Map<String, Object> toMap(String string2) {
        Type type = new aju<Map<String, Object>>(){}.getType();
        return (Map)gson.a(string2, type);
    }

    public static StringTrimResult trimWithCount(String string2) {
        int n2;
        int n3;
        StringTrimResult stringTrimResult = new StringTrimResult(string2);
        int n4 = string2.length();
        int n5 = n2 = n4 - 1;
        for (n3 = 0; n3 <= n5 && string2.charAt(n3) <= ' '; ++n3) {
        }
        while (n5 >= n3 && string2.charAt(n5) <= ' ') {
            --n5;
        }
        if (n3 == 0 && n5 == n2) {
            return stringTrimResult;
        }
        stringTrimResult.string = string2.substring(n3, n5 + 1);
        stringTrimResult.trimmedStart = n3;
        stringTrimResult.trimmedEnd = -1 + string2.length() - n5;
        return stringTrimResult;
    }

    public static class StringTrimResult {
        public String string;
        public int trimmedEnd;
        public int trimmedStart;

        public StringTrimResult(String string2) {
            this.string = string2;
        }
    }

}

