/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.InputStream
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.logging.Level
 *  java.util.logging.Logger
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.Phonenumber;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberUtil {
    private static final Pattern A;
    private static final Pattern B;
    private static PhoneNumberUtil C;
    static final ajz a;
    static final Pattern b;
    static final Pattern c;
    static final Pattern d;
    static final String e;
    static final Pattern f;
    private static final Logger g;
    private static final Map<Integer, String> h;
    private static final Set<Integer> i;
    private static final Map<Character, Character> j;
    private static final Map<Character, Character> k;
    private static final Map<Character, Character> l;
    private static final Map<Character, Character> m;
    private static final Pattern n;
    private static final String o;
    private static final Pattern p;
    private static final Pattern q;
    private static final Pattern r;
    private static final Pattern s;
    private static final String t;
    private static final String u;
    private static final Pattern v;
    private static final Pattern w;
    private static final Pattern x;
    private static final Pattern y;
    private static final Pattern z;
    private final akb D;
    private final Map<Integer, List<String>> E;
    private final Set<String> F = new HashSet(35);
    private final akd G = new akd(100);
    private final Set<String> H = new HashSet(320);
    private final Set<Integer> I = new HashSet();

    /*
     * Enabled aggressive block sorting
     */
    static {
        a = new ajz(){

            @Override
            public InputStream a(String string2) {
                return PhoneNumberUtil.class.getResourceAsStream(string2);
            }
        };
        g = Logger.getLogger((String)PhoneNumberUtil.class.getName());
        HashMap hashMap = new HashMap();
        hashMap.put((Object)52, (Object)"1");
        hashMap.put((Object)54, (Object)"9");
        h = Collections.unmodifiableMap((Map)hashMap);
        HashSet hashSet = new HashSet();
        hashSet.add((Object)52);
        hashSet.add((Object)54);
        hashSet.add((Object)55);
        i = Collections.unmodifiableSet((Set)hashSet);
        HashMap hashMap2 = new HashMap();
        hashMap2.put((Object)Character.valueOf((char)'0'), (Object)Character.valueOf((char)'0'));
        hashMap2.put((Object)Character.valueOf((char)'1'), (Object)Character.valueOf((char)'1'));
        hashMap2.put((Object)Character.valueOf((char)'2'), (Object)Character.valueOf((char)'2'));
        hashMap2.put((Object)Character.valueOf((char)'3'), (Object)Character.valueOf((char)'3'));
        hashMap2.put((Object)Character.valueOf((char)'4'), (Object)Character.valueOf((char)'4'));
        hashMap2.put((Object)Character.valueOf((char)'5'), (Object)Character.valueOf((char)'5'));
        hashMap2.put((Object)Character.valueOf((char)'6'), (Object)Character.valueOf((char)'6'));
        hashMap2.put((Object)Character.valueOf((char)'7'), (Object)Character.valueOf((char)'7'));
        hashMap2.put((Object)Character.valueOf((char)'8'), (Object)Character.valueOf((char)'8'));
        hashMap2.put((Object)Character.valueOf((char)'9'), (Object)Character.valueOf((char)'9'));
        HashMap hashMap3 = new HashMap(40);
        hashMap3.put((Object)Character.valueOf((char)'A'), (Object)Character.valueOf((char)'2'));
        hashMap3.put((Object)Character.valueOf((char)'B'), (Object)Character.valueOf((char)'2'));
        hashMap3.put((Object)Character.valueOf((char)'C'), (Object)Character.valueOf((char)'2'));
        hashMap3.put((Object)Character.valueOf((char)'D'), (Object)Character.valueOf((char)'3'));
        hashMap3.put((Object)Character.valueOf((char)'E'), (Object)Character.valueOf((char)'3'));
        hashMap3.put((Object)Character.valueOf((char)'F'), (Object)Character.valueOf((char)'3'));
        hashMap3.put((Object)Character.valueOf((char)'G'), (Object)Character.valueOf((char)'4'));
        hashMap3.put((Object)Character.valueOf((char)'H'), (Object)Character.valueOf((char)'4'));
        hashMap3.put((Object)Character.valueOf((char)'I'), (Object)Character.valueOf((char)'4'));
        hashMap3.put((Object)Character.valueOf((char)'J'), (Object)Character.valueOf((char)'5'));
        hashMap3.put((Object)Character.valueOf((char)'K'), (Object)Character.valueOf((char)'5'));
        hashMap3.put((Object)Character.valueOf((char)'L'), (Object)Character.valueOf((char)'5'));
        hashMap3.put((Object)Character.valueOf((char)'M'), (Object)Character.valueOf((char)'6'));
        hashMap3.put((Object)Character.valueOf((char)'N'), (Object)Character.valueOf((char)'6'));
        hashMap3.put((Object)Character.valueOf((char)'O'), (Object)Character.valueOf((char)'6'));
        hashMap3.put((Object)Character.valueOf((char)'P'), (Object)Character.valueOf((char)'7'));
        hashMap3.put((Object)Character.valueOf((char)'Q'), (Object)Character.valueOf((char)'7'));
        hashMap3.put((Object)Character.valueOf((char)'R'), (Object)Character.valueOf((char)'7'));
        hashMap3.put((Object)Character.valueOf((char)'S'), (Object)Character.valueOf((char)'7'));
        hashMap3.put((Object)Character.valueOf((char)'T'), (Object)Character.valueOf((char)'8'));
        hashMap3.put((Object)Character.valueOf((char)'U'), (Object)Character.valueOf((char)'8'));
        hashMap3.put((Object)Character.valueOf((char)'V'), (Object)Character.valueOf((char)'8'));
        hashMap3.put((Object)Character.valueOf((char)'W'), (Object)Character.valueOf((char)'9'));
        hashMap3.put((Object)Character.valueOf((char)'X'), (Object)Character.valueOf((char)'9'));
        hashMap3.put((Object)Character.valueOf((char)'Y'), (Object)Character.valueOf((char)'9'));
        hashMap3.put((Object)Character.valueOf((char)'Z'), (Object)Character.valueOf((char)'9'));
        k = Collections.unmodifiableMap((Map)hashMap3);
        HashMap hashMap4 = new HashMap(100);
        hashMap4.putAll(k);
        hashMap4.putAll((Map)hashMap2);
        l = Collections.unmodifiableMap((Map)hashMap4);
        HashMap hashMap5 = new HashMap();
        hashMap5.putAll((Map)hashMap2);
        hashMap5.put((Object)Character.valueOf((char)'+'), (Object)Character.valueOf((char)'+'));
        hashMap5.put((Object)Character.valueOf((char)'*'), (Object)Character.valueOf((char)'*'));
        j = Collections.unmodifiableMap((Map)hashMap5);
        HashMap hashMap6 = new HashMap();
        Iterator iterator = k.keySet().iterator();
        while (iterator.hasNext()) {
            char c2 = ((Character)iterator.next()).charValue();
            hashMap6.put((Object)Character.valueOf((char)Character.toLowerCase((char)c2)), (Object)Character.valueOf((char)c2));
            hashMap6.put((Object)Character.valueOf((char)c2), (Object)Character.valueOf((char)c2));
        }
        hashMap6.putAll((Map)hashMap2);
        hashMap6.put((Object)Character.valueOf((char)'-'), (Object)Character.valueOf((char)'-'));
        hashMap6.put((Object)Character.valueOf((char)'\uff0d'), (Object)Character.valueOf((char)'-'));
        hashMap6.put((Object)Character.valueOf((char)'\u2010'), (Object)Character.valueOf((char)'-'));
        hashMap6.put((Object)Character.valueOf((char)'\u2011'), (Object)Character.valueOf((char)'-'));
        hashMap6.put((Object)Character.valueOf((char)'\u2012'), (Object)Character.valueOf((char)'-'));
        hashMap6.put((Object)Character.valueOf((char)'\u2013'), (Object)Character.valueOf((char)'-'));
        hashMap6.put((Object)Character.valueOf((char)'\u2014'), (Object)Character.valueOf((char)'-'));
        hashMap6.put((Object)Character.valueOf((char)'\u2015'), (Object)Character.valueOf((char)'-'));
        hashMap6.put((Object)Character.valueOf((char)'\u2212'), (Object)Character.valueOf((char)'-'));
        hashMap6.put((Object)Character.valueOf((char)'/'), (Object)Character.valueOf((char)'/'));
        hashMap6.put((Object)Character.valueOf((char)'\uff0f'), (Object)Character.valueOf((char)'/'));
        hashMap6.put((Object)Character.valueOf((char)' '), (Object)Character.valueOf((char)' '));
        hashMap6.put((Object)Character.valueOf((char)'\u3000'), (Object)Character.valueOf((char)' '));
        hashMap6.put((Object)Character.valueOf((char)'\u2060'), (Object)Character.valueOf((char)' '));
        hashMap6.put((Object)Character.valueOf((char)'.'), (Object)Character.valueOf((char)'.'));
        hashMap6.put((Object)Character.valueOf((char)'\uff0e'), (Object)Character.valueOf((char)'.'));
        m = Collections.unmodifiableMap((Map)hashMap6);
        n = Pattern.compile((String)"[\\d]+(?:[~\u2053\u223c\uff5e][\\d]+)?");
        String string2 = String.valueOf((Object)Arrays.toString((Object[])k.keySet().toArray()).replaceAll("[, \\[\\]]", ""));
        String string3 = String.valueOf((Object)Arrays.toString((Object[])k.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", ""));
        String string4 = string3.length() != 0 ? string2.concat(string3) : new String(string2);
        o = string4;
        b = Pattern.compile((String)"[+\uff0b]+");
        p = Pattern.compile((String)"[-x\u2010-\u2015\u2212\u30fc\uff0d-\uff0f \u00a0\u00ad\u200b\u2060\u3000()\uff08\uff09\uff3b\uff3d.\\[\\]/~\u2053\u223c\uff5e]+");
        q = Pattern.compile((String)"(\\p{Nd})");
        r = Pattern.compile((String)"[+\uff0b\\p{Nd}]");
        c = Pattern.compile((String)"[\\\\/] *x");
        d = Pattern.compile((String)"[[\\P{N}&&\\P{L}]&&[^#]]+$");
        s = Pattern.compile((String)"(?:.*?[A-Za-z]){3}.*");
        String string5 = String.valueOf((Object)String.valueOf((Object)"\\p{Nd}{2}|[+\uff0b]*+(?:[-x\u2010-\u2015\u2212\u30fc\uff0d-\uff0f \u00a0\u00ad\u200b\u2060\u3000()\uff08\uff09\uff3b\uff3d.\\[\\]/~\u2053\u223c\uff5e*]*\\p{Nd}){3,}[-x\u2010-\u2015\u2212\u30fc\uff0d-\uff0f \u00a0\u00ad\u200b\u2060\u3000()\uff08\uff09\uff3b\uff3d.\\[\\]/~\u2053\u223c\uff5e*"));
        String string6 = String.valueOf((Object)String.valueOf((Object)o));
        String string7 = String.valueOf((Object)String.valueOf((Object)"\\p{Nd}"));
        t = new StringBuilder(2 + string5.length() + string6.length() + string7.length()).append(string5).append(string6).append(string7).append("]*").toString();
        String string8 = String.valueOf((Object)"x\uff58#\uff03~\uff5e");
        String string9 = string8.length() != 0 ? ",".concat(string8) : new String(",");
        u = PhoneNumberUtil.f(string9);
        e = PhoneNumberUtil.f("x\uff58#\uff03~\uff5e");
        String string10 = String.valueOf((Object)String.valueOf((Object)u));
        v = Pattern.compile((String)new StringBuilder(5 + string10.length()).append("(?:").append(string10).append(")$").toString(), (int)66);
        String string11 = String.valueOf((Object)String.valueOf((Object)t));
        String string12 = String.valueOf((Object)String.valueOf((Object)u));
        w = Pattern.compile((String)new StringBuilder(5 + string11.length() + string12.length()).append(string11).append("(?:").append(string12).append(")?").toString(), (int)66);
        f = Pattern.compile((String)"(\\D+)");
        x = Pattern.compile((String)"(\\$\\d)");
        y = Pattern.compile((String)"\\$NP");
        z = Pattern.compile((String)"\\$FG");
        A = Pattern.compile((String)"\\$CC");
        B = Pattern.compile((String)"\\(?\\$1\\)?");
        C = null;
    }

    PhoneNumberUtil(akb akb2, Map<Integer, List<String>> map) {
        this.D = akb2;
        this.E = map;
        for (Map.Entry entry : map.entrySet()) {
            List list = (List)entry.getValue();
            if (list.size() == 1 && "001".equals(list.get(0))) {
                this.I.add(entry.getKey());
                continue;
            }
            this.H.addAll((Collection)list);
        }
        if (this.H.remove((Object)"001")) {
            g.log(Level.WARNING, "invalid metadata (country calling code was mapped to the non-geo entity as well as specific region(s))");
        }
        this.F.addAll((Collection)map.get((Object)1));
    }

    private akf.b a(int n2, String string2) {
        if ("001".equals((Object)string2)) {
            return this.a(n2);
        }
        return this.e(string2);
    }

    private ValidationResult a(Pattern pattern, String string2) {
        Matcher matcher = pattern.matcher((CharSequence)string2);
        if (matcher.matches()) {
            return ValidationResult.a;
        }
        if (matcher.lookingAt()) {
            return ValidationResult.d;
        }
        return ValidationResult.c;
    }

    public static PhoneNumberUtil a() {
        reference var2 = PhoneNumberUtil.class;
        synchronized (PhoneNumberUtil.class) {
            if (C == null) {
                PhoneNumberUtil.a(PhoneNumberUtil.a(a));
            }
            PhoneNumberUtil phoneNumberUtil = C;
            // ** MonitorExit[var2] (shouldn't be in output)
            return phoneNumberUtil;
        }
    }

    public static PhoneNumberUtil a(ajz ajz2) {
        if (ajz2 == null) {
            throw new IllegalArgumentException("metadataLoader could not be null.");
        }
        return PhoneNumberUtil.a(new akc(ajz2));
    }

    public static PhoneNumberUtil a(akb akb2) {
        if (akb2 == null) {
            throw new IllegalArgumentException("metadataSource could not be null.");
        }
        return new PhoneNumberUtil(akb2, ajy.a());
    }

    /*
     * Enabled aggressive block sorting
     */
    static String a(String string2) {
        Matcher matcher;
        Matcher matcher2 = r.matcher((CharSequence)string2);
        if (!matcher2.find()) {
            return "";
        }
        String string3 = string2.substring(matcher2.start());
        Matcher matcher3 = d.matcher((CharSequence)string3);
        if (matcher3.find()) {
            string3 = string3.substring(0, matcher3.start());
            Logger logger = g;
            Level level = Level.FINER;
            String string4 = String.valueOf((Object)string3);
            String string5 = string4.length() != 0 ? "Stripped trailing characters: ".concat(string4) : new String("Stripped trailing characters: ");
            logger.log(level, string5);
        }
        if (!(matcher = c.matcher((CharSequence)string3)).find()) return string3;
        return string3.substring(0, matcher.start());
    }

    /*
     * Enabled aggressive block sorting
     */
    private String a(String string2, akf.a a2, PhoneNumberFormat phoneNumberFormat, String string3) {
        String string4;
        String string5 = a2.b;
        Matcher matcher = this.G.a(a2.a).matcher((CharSequence)string2);
        if (phoneNumberFormat == PhoneNumberFormat.c && string3 != null && string3.length() > 0 && a2.f.length() > 0) {
            String string6 = a2.f;
            String string7 = A.matcher((CharSequence)string6).replaceFirst(string3);
            string4 = matcher.replaceAll(x.matcher((CharSequence)string5).replaceFirst(string7));
        } else {
            String string8 = a2.d;
            string4 = phoneNumberFormat == PhoneNumberFormat.c && string8 != null && string8.length() > 0 ? matcher.replaceAll(x.matcher((CharSequence)string5).replaceFirst(string8)) : matcher.replaceAll(string5);
        }
        if (phoneNumberFormat != PhoneNumberFormat.d) return string4;
        Matcher matcher2 = p.matcher((CharSequence)string4);
        if (!matcher2.lookingAt()) return matcher2.reset((CharSequence)string4).replaceAll("-");
        string4 = matcher2.replaceFirst("");
        return matcher2.reset((CharSequence)string4).replaceAll("-");
    }

    private String a(String string2, akf.b b2, PhoneNumberFormat phoneNumberFormat) {
        return super.a(string2, b2, phoneNumberFormat, null);
    }

    /*
     * Enabled aggressive block sorting
     */
    private String a(String string2, akf.b b2, PhoneNumberFormat phoneNumberFormat, String string3) {
        akf.a[] arra = b2.A.length == 0 || phoneNumberFormat == PhoneNumberFormat.c ? b2.z : b2.A;
        akf.a a2 = this.a(arra, string2);
        if (a2 == null) {
            return string2;
        }
        return super.a(string2, a2, phoneNumberFormat, string3);
    }

    /*
     * Enabled aggressive block sorting
     */
    private static String a(String string2, Map<Character, Character> map, boolean bl2) {
        StringBuilder stringBuilder = new StringBuilder(string2.length());
        int n2 = 0;
        while (n2 < string2.length()) {
            char c2 = string2.charAt(n2);
            Character c3 = (Character)map.get((Object)Character.valueOf((char)Character.toUpperCase((char)c2)));
            if (c3 != null) {
                stringBuilder.append((Object)c3);
            } else if (!bl2) {
                stringBuilder.append(c2);
            }
            ++n2;
        }
        return stringBuilder.toString();
    }

    /*
     * Enabled aggressive block sorting
     */
    static StringBuilder a(String string2, boolean bl2) {
        StringBuilder stringBuilder = new StringBuilder(string2.length());
        char[] arrc = string2.toCharArray();
        int n2 = arrc.length;
        int n3 = 0;
        while (n3 < n2) {
            char c2 = arrc[n3];
            int n4 = Character.digit((char)c2, (int)10);
            if (n4 != -1) {
                stringBuilder.append(n4);
            } else if (bl2) {
                stringBuilder.append(c2);
            }
            ++n3;
        }
        return stringBuilder;
    }

    private void a(int n2, PhoneNumberFormat phoneNumberFormat, StringBuilder stringBuilder) {
        switch (.b[phoneNumberFormat.ordinal()]) {
            default: {
                return;
            }
            case 1: {
                stringBuilder.insert(0, n2).insert(0, '+');
                return;
            }
            case 2: {
                stringBuilder.insert(0, " ").insert(0, n2).insert(0, '+');
                return;
            }
            case 3: 
        }
        stringBuilder.insert(0, "-").insert(0, n2).insert(0, '+').insert(0, "tel:");
    }

    static void a(PhoneNumberUtil phoneNumberUtil) {
        reference var2_1 = PhoneNumberUtil.class;
        synchronized (PhoneNumberUtil.class) {
            C = phoneNumberUtil;
            // ** MonitorExit[var2_1] (shouldn't be in output)
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void a(Phonenumber.PhoneNumber phoneNumber, akf.b b2, PhoneNumberFormat phoneNumberFormat, StringBuilder stringBuilder) {
        if (!phoneNumber.c() || phoneNumber.d().length() <= 0) return;
        if (phoneNumberFormat == PhoneNumberFormat.d) {
            stringBuilder.append(";ext=").append(phoneNumber.d());
            return;
        }
        if (!b2.v.equals((Object)"")) {
            stringBuilder.append(b2.v).append(phoneNumber.d());
            return;
        }
        stringBuilder.append(" ext. ").append(phoneNumber.d());
    }

    static void a(String string2, Phonenumber.PhoneNumber phoneNumber) {
        if (string2.length() > 1 && string2.charAt(0) == '0') {
            int n2;
            phoneNumber.a(true);
            for (n2 = 1; n2 < -1 + string2.length() && string2.charAt(n2) == '0'; ++n2) {
            }
            if (n2 != 1) {
                phoneNumber.b(n2);
            }
        }
    }

    /*
     * Exception decompiling
     */
    private void a(String var1_4, String var2_5, boolean var3_2, boolean var4_3, Phonenumber.PhoneNumber var5_1) throws NumberParseException {
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

    /*
     * Enabled aggressive block sorting
     */
    private void a(String string2, StringBuilder stringBuilder) {
        int n2;
        int n3 = string2.indexOf(";phone-context=");
        if (n3 > 0) {
            int n4;
            int n5 = n3 + ";phone-context=".length();
            if (string2.charAt(n5) == '+') {
                int n6 = string2.indexOf(59, n5);
                if (n6 > 0) {
                    stringBuilder.append(string2.substring(n5, n6));
                } else {
                    stringBuilder.append(string2.substring(n5));
                }
            }
            int n7 = (n4 = string2.indexOf("tel:")) >= 0 ? n4 + "tel:".length() : 0;
            stringBuilder.append(string2.substring(n7, n3));
        } else {
            stringBuilder.append(PhoneNumberUtil.a(string2));
        }
        if ((n2 = stringBuilder.indexOf(";isub=")) > 0) {
            stringBuilder.delete(n2, stringBuilder.length());
        }
    }

    static void a(StringBuilder stringBuilder) {
        String string2 = PhoneNumberUtil.c(stringBuilder.toString());
        stringBuilder.replace(0, stringBuilder.length(), string2);
    }

    private boolean a(akf.b b2, String string2) {
        if (super.a(this.G.a(b2.a.b), string2) == ValidationResult.c) {
            return true;
        }
        return false;
    }

    private boolean a(Pattern pattern, StringBuilder stringBuilder) {
        Matcher matcher;
        int n2;
        Matcher matcher2 = pattern.matcher((CharSequence)stringBuilder);
        if (!matcher2.lookingAt() || (matcher = q.matcher((CharSequence)stringBuilder.substring(n2 = matcher2.end()))).find() && PhoneNumberUtil.d(matcher.group(1)).equals((Object)"0")) {
            return false;
        }
        stringBuilder.delete(0, n2);
        return true;
    }

    static boolean b(String string2) {
        if (string2.length() < 2) {
            return false;
        }
        return w.matcher((CharSequence)string2).matches();
    }

    private boolean b(String string2, String string3) {
        if (!(super.g(string3) || string2 != null && string2.length() != 0 && b.matcher((CharSequence)string2).lookingAt())) {
            return false;
        }
        return true;
    }

    static String c(String string2) {
        if (s.matcher((CharSequence)string2).matches()) {
            return PhoneNumberUtil.a(string2, l, true);
        }
        return PhoneNumberUtil.d(string2);
    }

    private boolean c(int n2) {
        return this.E.containsKey((Object)n2);
    }

    public static String d(String string2) {
        return PhoneNumberUtil.a(string2, false).toString();
    }

    private static String f(String string2) {
        String string3 = String.valueOf((Object)String.valueOf((Object)";ext=(\\p{Nd}{1,7})|[ \u00a0\\t,]*(?:e?xt(?:ensi(?:o\u0301?|\u00f3))?n?|\uff45?\uff58\uff54\uff4e?|["));
        String string4 = String.valueOf((Object)String.valueOf((Object)string2));
        String string5 = String.valueOf((Object)String.valueOf((Object)"(\\p{Nd}{1,7})"));
        String string6 = String.valueOf((Object)String.valueOf((Object)"\\p{Nd}"));
        return new StringBuilder(48 + string3.length() + string4.length() + string5.length() + string6.length()).append(string3).append(string4).append("]|int|anexo|\uff49\uff4e\uff54)").append("[:\\.\uff0e]?[ \u00a0\\t,-]*").append(string5).append("#?|").append("[- ]+(").append(string6).append("{1,5})#").toString();
    }

    private boolean g(String string2) {
        if (string2 != null && this.H.contains((Object)string2)) {
            return true;
        }
        return false;
    }

    int a(String string2, akf.b b2, StringBuilder stringBuilder, boolean bl2, Phonenumber.PhoneNumber phoneNumber) throws NumberParseException {
        if (string2.length() == 0) {
            return 0;
        }
        StringBuilder stringBuilder2 = new StringBuilder(string2);
        String string3 = "NonMatch";
        if (b2 != null) {
            string3 = b2.s;
        }
        Phonenumber.PhoneNumber.CountryCodeSource countryCodeSource = this.a(stringBuilder2, string3);
        if (bl2) {
            phoneNumber.a(countryCodeSource);
        }
        if (countryCodeSource != Phonenumber.PhoneNumber.CountryCodeSource.d) {
            if (stringBuilder2.length() <= 2) {
                throw new NumberParseException(NumberParseException.ErrorType.c, "Phone number had an IDD, but after this was not long enough to be a viable phone number.");
            }
            int n2 = this.a(stringBuilder2, stringBuilder);
            if (n2 != 0) {
                phoneNumber.a(n2);
                return n2;
            }
            throw new NumberParseException(NumberParseException.ErrorType.a, "Country calling code supplied was not recognised.");
        }
        if (b2 != null) {
            int n3 = b2.r;
            String string4 = String.valueOf((int)n3);
            String string5 = stringBuilder2.toString();
            if (string5.startsWith(string4)) {
                StringBuilder stringBuilder3 = new StringBuilder(string5.substring(string4.length()));
                akf.d d2 = b2.a;
                Pattern pattern = this.G.a(d2.a);
                this.a(stringBuilder3, b2, null);
                Pattern pattern2 = this.G.a(d2.b);
                if (!pattern.matcher((CharSequence)stringBuilder2).matches() && pattern.matcher((CharSequence)stringBuilder3).matches() || this.a(pattern2, stringBuilder2.toString()) == ValidationResult.d) {
                    stringBuilder.append((CharSequence)stringBuilder3);
                    if (bl2) {
                        phoneNumber.a(Phonenumber.PhoneNumber.CountryCodeSource.c);
                    }
                    phoneNumber.a(n3);
                    return n3;
                }
            }
        }
        phoneNumber.a(0);
        return 0;
    }

    int a(StringBuilder stringBuilder, StringBuilder stringBuilder2) {
        if (stringBuilder.length() == 0 || stringBuilder.charAt(0) == '0') {
            return 0;
        }
        int n2 = stringBuilder.length();
        for (int i2 = 1; i2 <= 3 && i2 <= n2; ++i2) {
            int n3 = Integer.parseInt((String)stringBuilder.substring(0, i2));
            if (!this.E.containsKey((Object)n3)) continue;
            stringBuilder2.append(stringBuilder.substring(i2));
            return n3;
        }
        return 0;
    }

    akf.a a(akf.a[] arra, String string2) {
        for (akf.a a2 : arra) {
            int n2 = a2.c.length;
            if (n2 != 0 && !this.G.a(a2.c[n2 - 1]).matcher((CharSequence)string2).lookingAt() || !this.G.a(a2.a).matcher((CharSequence)string2).matches()) continue;
            return a2;
        }
        return null;
    }

    akf.b a(int n2) {
        if (!this.E.containsKey((Object)n2)) {
            return null;
        }
        return this.D.a(n2);
    }

    Phonenumber.PhoneNumber.CountryCodeSource a(StringBuilder stringBuilder, String string2) {
        if (stringBuilder.length() == 0) {
            return Phonenumber.PhoneNumber.CountryCodeSource.d;
        }
        Matcher matcher = b.matcher((CharSequence)stringBuilder);
        if (matcher.lookingAt()) {
            stringBuilder.delete(0, matcher.end());
            PhoneNumberUtil.a(stringBuilder);
            return Phonenumber.PhoneNumber.CountryCodeSource.a;
        }
        Pattern pattern = this.G.a(string2);
        PhoneNumberUtil.a(stringBuilder);
        if (super.a(pattern, stringBuilder)) {
            return Phonenumber.PhoneNumber.CountryCodeSource.b;
        }
        return Phonenumber.PhoneNumber.CountryCodeSource.d;
    }

    public Phonenumber.PhoneNumber a(String string2, String string3) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumber = new Phonenumber.PhoneNumber();
        this.a(string2, string3, phoneNumber);
        return phoneNumber;
    }

    public String a(Phonenumber.PhoneNumber phoneNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        if (phoneNumber.f()) {
            char[] arrc = new char[phoneNumber.h()];
            Arrays.fill((char[])arrc, (char)'0');
            stringBuilder.append(new String(arrc));
        }
        stringBuilder.append(phoneNumber.b());
        return stringBuilder.toString();
    }

    public String a(Phonenumber.PhoneNumber phoneNumber, PhoneNumberFormat phoneNumberFormat) {
        String string2;
        if (phoneNumber.b() == 0 && phoneNumber.i() && (string2 = phoneNumber.j()).length() > 0) {
            return string2;
        }
        StringBuilder stringBuilder = new StringBuilder(20);
        this.a(phoneNumber, phoneNumberFormat, stringBuilder);
        return stringBuilder.toString();
    }

    public void a(Phonenumber.PhoneNumber phoneNumber, PhoneNumberFormat phoneNumberFormat, StringBuilder stringBuilder) {
        stringBuilder.setLength(0);
        int n2 = phoneNumber.a();
        String string2 = this.a(phoneNumber);
        if (phoneNumberFormat == PhoneNumberFormat.a) {
            stringBuilder.append(string2);
            super.a(n2, PhoneNumberFormat.a, stringBuilder);
            return;
        }
        if (!super.c(n2)) {
            stringBuilder.append(string2);
            return;
        }
        akf.b b2 = super.a(n2, this.b(n2));
        stringBuilder.append(super.a(string2, b2, phoneNumberFormat));
        super.a(phoneNumber, b2, phoneNumberFormat, stringBuilder);
        super.a(n2, phoneNumberFormat, stringBuilder);
    }

    public void a(String string2, String string3, Phonenumber.PhoneNumber phoneNumber) throws NumberParseException {
        super.a(string2, string3, false, true, phoneNumber);
    }

    /*
     * Enabled aggressive block sorting
     */
    boolean a(StringBuilder stringBuilder, akf.b b2, StringBuilder stringBuilder2) {
        Matcher matcher;
        int n2 = stringBuilder.length();
        String string2 = b2.w;
        if (n2 == 0 || string2.length() == 0 || !(matcher = this.G.a(string2).matcher((CharSequence)stringBuilder)).lookingAt()) return false;
        Pattern pattern = this.G.a(b2.a.a);
        boolean bl2 = pattern.matcher((CharSequence)stringBuilder).matches();
        int n3 = matcher.groupCount();
        String string3 = b2.x;
        if (string3 == null || string3.length() == 0 || matcher.group(n3) == null) {
            if (bl2 && !pattern.matcher((CharSequence)stringBuilder.substring(matcher.end())).matches()) return false;
            {
                if (stringBuilder2 != null && n3 > 0 && matcher.group(n3) != null) {
                    stringBuilder2.append(matcher.group(1));
                }
                stringBuilder.delete(0, matcher.end());
                return true;
            }
        }
        StringBuilder stringBuilder3 = new StringBuilder((CharSequence)stringBuilder);
        stringBuilder3.replace(0, n2, matcher.replaceFirst(string3));
        if (bl2 && !pattern.matcher((CharSequence)stringBuilder3.toString()).matches()) {
            return false;
        }
        if (stringBuilder2 != null && n3 > 1) {
            stringBuilder2.append(matcher.group(1));
        }
        stringBuilder.replace(0, stringBuilder.length(), stringBuilder3.toString());
        return true;
    }

    public String b(int n2) {
        List list = (List)this.E.get((Object)n2);
        if (list == null) {
            return "ZZ";
        }
        return (String)list.get(0);
    }

    String b(StringBuilder stringBuilder) {
        Matcher matcher = v.matcher((CharSequence)stringBuilder);
        if (matcher.find() && PhoneNumberUtil.b(stringBuilder.substring(0, matcher.start()))) {
            int n2 = matcher.groupCount();
            for (int i2 = 1; i2 <= n2; ++i2) {
                if (matcher.group(i2) == null) continue;
                String string2 = matcher.group(i2);
                stringBuilder.delete(matcher.start(), stringBuilder.length());
                return string2;
            }
        }
        return "";
    }

    akf.b e(String string2) {
        if (!super.g(string2)) {
            return null;
        }
        return this.D.a(string2);
    }

    public static final class PhoneNumberFormat
    extends Enum<PhoneNumberFormat> {
        public static final /* enum */ PhoneNumberFormat a = new PhoneNumberFormat();
        public static final /* enum */ PhoneNumberFormat b = new PhoneNumberFormat();
        public static final /* enum */ PhoneNumberFormat c = new PhoneNumberFormat();
        public static final /* enum */ PhoneNumberFormat d = new PhoneNumberFormat();
        private static final /* synthetic */ PhoneNumberFormat[] e;

        static {
            PhoneNumberFormat[] arrphoneNumberFormat = new PhoneNumberFormat[]{a, b, c, d};
            e = arrphoneNumberFormat;
        }

        private PhoneNumberFormat() {
            super(string2, n2);
        }

        public static PhoneNumberFormat valueOf(String string2) {
            return (PhoneNumberFormat)Enum.valueOf((Class)PhoneNumberFormat.class, (String)string2);
        }

        public static PhoneNumberFormat[] values() {
            return (PhoneNumberFormat[])e.clone();
        }
    }

    public static final class PhoneNumberType
    extends Enum<PhoneNumberType> {
        public static final /* enum */ PhoneNumberType a = new PhoneNumberType();
        public static final /* enum */ PhoneNumberType b = new PhoneNumberType();
        public static final /* enum */ PhoneNumberType c = new PhoneNumberType();
        public static final /* enum */ PhoneNumberType d = new PhoneNumberType();
        public static final /* enum */ PhoneNumberType e = new PhoneNumberType();
        public static final /* enum */ PhoneNumberType f = new PhoneNumberType();
        public static final /* enum */ PhoneNumberType g = new PhoneNumberType();
        public static final /* enum */ PhoneNumberType h = new PhoneNumberType();
        public static final /* enum */ PhoneNumberType i = new PhoneNumberType();
        public static final /* enum */ PhoneNumberType j = new PhoneNumberType();
        public static final /* enum */ PhoneNumberType k = new PhoneNumberType();
        public static final /* enum */ PhoneNumberType l = new PhoneNumberType();
        private static final /* synthetic */ PhoneNumberType[] m;

        static {
            PhoneNumberType[] arrphoneNumberType = new PhoneNumberType[]{a, b, c, d, e, f, g, h, i, j, k, l};
            m = arrphoneNumberType;
        }

        private PhoneNumberType() {
            super(string2, n2);
        }

        public static PhoneNumberType valueOf(String string2) {
            return (PhoneNumberType)Enum.valueOf((Class)PhoneNumberType.class, (String)string2);
        }

        public static PhoneNumberType[] values() {
            return (PhoneNumberType[])m.clone();
        }
    }

    public static final class ValidationResult
    extends Enum<ValidationResult> {
        public static final /* enum */ ValidationResult a = new ValidationResult();
        public static final /* enum */ ValidationResult b = new ValidationResult();
        public static final /* enum */ ValidationResult c = new ValidationResult();
        public static final /* enum */ ValidationResult d = new ValidationResult();
        private static final /* synthetic */ ValidationResult[] e;

        static {
            ValidationResult[] arrvalidationResult = new ValidationResult[]{a, b, c, d};
            e = arrvalidationResult;
        }

        private ValidationResult() {
            super(string2, n2);
        }

        public static ValidationResult valueOf(String string2) {
            return (ValidationResult)Enum.valueOf((Class)ValidationResult.class, (String)string2);
        }

        public static ValidationResult[] values() {
            return (ValidationResult[])e.clone();
        }
    }

}

