/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.Date
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.TreeSet
 */
package okhttp3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import okhttp3.internal.http.HttpDate;

public final class Headers {
    private final String[] namesAndValues;

    private Headers(Builder builder) {
        this.namesAndValues = (String[])builder.namesAndValues.toArray((Object[])new String[builder.namesAndValues.size()]);
    }

    /* synthetic */ Headers(Builder builder,  var2_2) {
        super(builder);
    }

    private Headers(String[] arrstring) {
        this.namesAndValues = arrstring;
    }

    private static String get(String[] arrstring, String string2) {
        for (int i2 = -2 + arrstring.length; i2 >= 0; i2 -= 2) {
            if (!string2.equalsIgnoreCase(arrstring[i2])) continue;
            return arrstring[i2 + 1];
        }
        return null;
    }

    public static Headers of(Map<String, String> map) {
        if (map == null) {
            throw new IllegalArgumentException("Expected map with header names and values");
        }
        String[] arrstring = new String[2 * map.size()];
        int n2 = 0;
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() == null || entry.getValue() == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            String string2 = ((String)entry.getKey()).trim();
            String string3 = ((String)entry.getValue()).trim();
            if (string2.length() == 0 || string2.indexOf(0) != -1 || string3.indexOf(0) != -1) {
                throw new IllegalArgumentException("Unexpected header: " + string2 + ": " + string3);
            }
            arrstring[n2] = string2;
            arrstring[n2 + 1] = string3;
            n2 += 2;
        }
        return new Headers(arrstring);
    }

    public static /* varargs */ Headers of(String ... arrstring) {
        if (arrstring == null || arrstring.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        String[] arrstring2 = (String[])arrstring.clone();
        for (int i2 = 0; i2 < arrstring2.length; ++i2) {
            if (arrstring2[i2] == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            arrstring2[i2] = arrstring2[i2].trim();
        }
        for (int i3 = 0; i3 < arrstring2.length; i3 += 2) {
            String string2 = arrstring2[i3];
            String string3 = arrstring2[i3 + 1];
            if (string2.length() != 0 && string2.indexOf(0) == -1 && string3.indexOf(0) == -1) continue;
            throw new IllegalArgumentException("Unexpected header: " + string2 + ": " + string3);
        }
        return new Headers(arrstring2);
    }

    public String get(String string2) {
        return Headers.get(this.namesAndValues, string2);
    }

    public Date getDate(String string2) {
        String string3 = this.get(string2);
        if (string3 != null) {
            return HttpDate.parse(string3);
        }
        return null;
    }

    public String name(int n2) {
        return this.namesAndValues[n2 * 2];
    }

    public Set<String> names() {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        int n2 = this.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            treeSet.add((Object)this.name(i2));
        }
        return Collections.unmodifiableSet((Set)treeSet);
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        Collections.addAll((Collection)builder.namesAndValues, (Object[])this.namesAndValues);
        return builder;
    }

    public int size() {
        return this.namesAndValues.length / 2;
    }

    public Map<String, List<String>> toMultimap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int n2 = this.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            String string2 = this.name(i2);
            List list = (List)linkedHashMap.get((Object)string2);
            if (list == null) {
                list = new ArrayList(2);
                linkedHashMap.put((Object)string2, (Object)list);
            }
            list.add((Object)this.value(i2));
        }
        return linkedHashMap;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = this.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            stringBuilder.append(this.name(i2)).append(": ").append(this.value(i2)).append("\n");
        }
        return stringBuilder.toString();
    }

    public String value(int n2) {
        return this.namesAndValues[1 + n2 * 2];
    }

    public List<String> values(String string2) {
        ArrayList arrayList = null;
        int n2 = this.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!string2.equalsIgnoreCase(this.name(i2))) continue;
            if (arrayList == null) {
                arrayList = new ArrayList(2);
            }
            arrayList.add((Object)this.value(i2));
        }
        if (arrayList != null) {
            return Collections.unmodifiableList((List)arrayList);
        }
        return Collections.emptyList();
    }

    public static final class Builder {
        private final List<String> namesAndValues = new ArrayList(20);

        private void checkNameAndValue(String string2, String string3) {
            if (string2 == null) {
                throw new IllegalArgumentException("name == null");
            }
            if (string2.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            int n2 = string2.length();
            for (int i2 = 0; i2 < n2; ++i2) {
                char c2 = string2.charAt(i2);
                if (c2 > '\u001f' && c2 < '') continue;
                Object[] arrobject = new Object[]{c2, i2, string2};
                throw new IllegalArgumentException(String.format((String)"Unexpected char %#04x at %d in header name: %s", (Object[])arrobject));
            }
            if (string3 == null) {
                throw new IllegalArgumentException("value == null");
            }
            int n3 = string3.length();
            for (int i3 = 0; i3 < n3; ++i3) {
                char c3 = string3.charAt(i3);
                if (c3 > '\u001f' && c3 < '') continue;
                Object[] arrobject = new Object[]{c3, i3, string2, string3};
                throw new IllegalArgumentException(String.format((String)"Unexpected char %#04x at %d in %s value: %s", (Object[])arrobject));
            }
        }

        public Builder add(String string2) {
            int n2 = string2.indexOf(":");
            if (n2 == -1) {
                throw new IllegalArgumentException("Unexpected header: " + string2);
            }
            return this.add(string2.substring(0, n2).trim(), string2.substring(n2 + 1));
        }

        public Builder add(String string2, String string3) {
            super.checkNameAndValue(string2, string3);
            return this.addLenient(string2, string3);
        }

        Builder addLenient(String string2) {
            int n2 = string2.indexOf(":", 1);
            if (n2 != -1) {
                return this.addLenient(string2.substring(0, n2), string2.substring(n2 + 1));
            }
            if (string2.startsWith(":")) {
                return this.addLenient("", string2.substring(1));
            }
            return this.addLenient("", string2);
        }

        Builder addLenient(String string2, String string3) {
            this.namesAndValues.add((Object)string2);
            this.namesAndValues.add((Object)string3.trim());
            return this;
        }

        public Headers build() {
            return new Headers(this, null);
        }

        public String get(String string2) {
            for (int i2 = -2 + this.namesAndValues.size(); i2 >= 0; i2 -= 2) {
                if (!string2.equalsIgnoreCase((String)this.namesAndValues.get(i2))) continue;
                return (String)this.namesAndValues.get(i2 + 1);
            }
            return null;
        }

        public Builder removeAll(String string2) {
            for (int i2 = 0; i2 < this.namesAndValues.size(); i2 += 2) {
                if (!string2.equalsIgnoreCase((String)this.namesAndValues.get(i2))) continue;
                this.namesAndValues.remove(i2);
                this.namesAndValues.remove(i2);
                i2 -= 2;
            }
            return this;
        }

        public Builder set(String string2, String string3) {
            super.checkNameAndValue(string2, string3);
            this.removeAll(string2);
            this.addLenient(string2, string3);
            return this;
        }
    }

}

