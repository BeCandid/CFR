/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.IOException
 *  java.io.UnsupportedEncodingException
 *  java.lang.ArrayIndexOutOfBoundsException
 *  java.lang.AssertionError
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.Error
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.lang.reflect.Array
 *  java.net.IDN
 *  java.net.ServerSocket
 *  java.net.Socket
 *  java.nio.charset.Charset
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Locale
 *  java.util.Map
 *  java.util.TimeZone
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.TimeUnit
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package okhttp3.internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.IDN;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.HttpUrl;
import okio.Buffer;
import okio.ByteString;
import okio.Source;

public final class Util {
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final TimeZone UTC;
    public static final Charset UTF_8;
    private static final Pattern VERIFY_AS_IP_ADDRESS;

    static {
        UTF_8 = Charset.forName((String)"UTF-8");
        UTC = TimeZone.getTimeZone((String)"GMT");
        VERIFY_AS_IP_ADDRESS = Pattern.compile((String)"([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    private Util() {
    }

    public static void checkOffsetAndCount(long l2, long l3, long l4) {
        if ((l3 | l4) < 0 || l3 > l2 || l2 - l3 < l4) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static void closeAll(Closeable var0_1, Closeable var1) throws IOException {
        var2_2 = null;
        try {
            var0_1.close();
        }
        catch (Throwable var3_3) {
            var2_2 = var3_3;
            ** continue;
        }
lbl4: // 2 sources:
        do {
            var1.close();
lbl7: // 3 sources:
            while (var2_2 == null) {
                return;
            }
            break;
        } while (true);
        catch (Throwable var4_4) {
            if (var2_2 != null) ** GOTO lbl7
            var2_2 = var4_4;
            ** GOTO lbl7
        }
        if (var2_2 instanceof IOException) {
            throw (IOException)var2_2;
        }
        if (var2_2 instanceof RuntimeException) {
            throw (RuntimeException)var2_2;
        }
        if (var2_2 instanceof Error) {
            throw (Error)var2_2;
        }
        throw new AssertionError((Object)var2_2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void closeQuietly(Closeable closeable) {
        if (closeable == null) return;
        try {
            closeable.close();
            return;
        }
        catch (RuntimeException var2_1) {
            throw var2_1;
        }
        catch (Exception var1_2) {
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void closeQuietly(ServerSocket serverSocket) {
        if (serverSocket == null) return;
        try {
            serverSocket.close();
            return;
        }
        catch (RuntimeException var2_1) {
            throw var2_1;
        }
        catch (Exception var1_2) {
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void closeQuietly(Socket socket) {
        if (socket == null) return;
        try {
            socket.close();
            return;
        }
        catch (AssertionError var3_1) {
            if (Util.isAndroidGetsocknameError(var3_1)) return;
            throw var3_1;
        }
        catch (RuntimeException var2_2) {
            throw var2_2;
        }
        catch (Exception var1_3) {
            return;
        }
    }

    public static String[] concat(String[] arrstring, String string2) {
        String[] arrstring2 = new String[1 + arrstring.length];
        System.arraycopy((Object)arrstring, (int)0, (Object)arrstring2, (int)0, (int)arrstring.length);
        arrstring2[-1 + arrstring2.length] = string2;
        return arrstring2;
    }

    public static boolean contains(String[] arrstring, String string2) {
        return Arrays.asList((Object[])arrstring).contains((Object)string2);
    }

    /*
     * Enabled aggressive block sorting
     */
    private static boolean containsInvalidHostnameAsciiCodes(String string2) {
        int n2 = 0;
        while (n2 < string2.length()) {
            char c2 = string2.charAt(n2);
            if (c2 <= '\u001f' || c2 >= '' || " #%/:?@[\\]".indexOf((int)c2) != -1) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    public static int delimiterOffset(String string2, int n2, int n3, char c2) {
        for (int i2 = n2; i2 < n3; ++i2) {
            if (string2.charAt(i2) != c2) continue;
            return i2;
        }
        return n3;
    }

    public static int delimiterOffset(String string2, int n2, int n3, String string3) {
        for (int i2 = n2; i2 < n3; ++i2) {
            if (string3.indexOf((int)string2.charAt(i2)) == -1) continue;
            return i2;
        }
        return n3;
    }

    public static boolean discard(Source source, int n2, TimeUnit timeUnit) {
        try {
            boolean bl2 = Util.skipAll(source, n2, timeUnit);
            return bl2;
        }
        catch (IOException var3_4) {
            return false;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String domainToAscii(String string2) {
        try {
            String string3 = IDN.toASCII((String)string2).toLowerCase(Locale.US);
            if (string3.isEmpty()) {
                return null;
            }
            boolean bl2 = Util.containsInvalidHostnameAsciiCodes(string3);
            if (!bl2) return string3;
            return null;
        }
        catch (IllegalArgumentException var1_3) {
            return null;
        }
    }

    public static boolean equal(Object object, Object object2) {
        if (object == object2 || object != null && object.equals(object2)) {
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String hostHeader(HttpUrl httpUrl, boolean bl2) {
        String string2 = httpUrl.host().contains((CharSequence)":") ? "[" + httpUrl.host() + "]" : httpUrl.host();
        if (bl2) return string2 + ":" + httpUrl.port();
        if (httpUrl.port() == HttpUrl.defaultPort(httpUrl.scheme())) return string2;
        return string2 + ":" + httpUrl.port();
    }

    public static <T> List<T> immutableList(List<T> list) {
        return Collections.unmodifiableList((List)new ArrayList(list));
    }

    public static /* varargs */ <T> List<T> immutableList(T ... arrT) {
        return Collections.unmodifiableList((List)Arrays.asList((Object[])((Object[])arrT.clone())));
    }

    public static <K, V> Map<K, V> immutableMap(Map<K, V> map) {
        return Collections.unmodifiableMap((Map)new LinkedHashMap(map));
    }

    private static <T> List<T> intersect(T[] arrT, T[] arrT2) {
        ArrayList arrayList = new ArrayList();
        block0 : for (T t2 : arrT) {
            int n2 = arrT2.length;
            int n3 = 0;
            do {
                if (n3 >= n2) continue block0;
                T t3 = arrT2[n3];
                if (t2.equals(t3)) {
                    arrayList.add(t3);
                    continue block0;
                }
                ++n3;
            } while (true);
        }
        return arrayList;
    }

    public static <T> T[] intersect(Class<T> class_, T[] arrT, T[] arrT2) {
        List<T> list = Util.intersect(arrT, arrT2);
        return list.toArray((Object[])Array.newInstance(class_, (int)list.size()));
    }

    public static boolean isAndroidGetsocknameError(AssertionError assertionError) {
        if (assertionError.getCause() != null && assertionError.getMessage() != null && assertionError.getMessage().contains((CharSequence)"getsockname failed")) {
            return true;
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String md5Hex(String string2) {
        void var1_3;
        try {
            return ByteString.of(MessageDigest.getInstance((String)"MD5").digest(string2.getBytes("UTF-8"))).hex();
        }
        catch (NoSuchAlgorithmException var1_2) {
            do {
                throw new AssertionError((Object)var1_3);
                break;
            } while (true);
        }
        catch (UnsupportedEncodingException var1_4) {
            throw new AssertionError((Object)var1_3);
        }
    }

    public static ByteString sha1(ByteString byteString) {
        try {
            ByteString byteString2 = ByteString.of(MessageDigest.getInstance((String)"SHA-1").digest(byteString.toByteArray()));
            return byteString2;
        }
        catch (NoSuchAlgorithmException var1_2) {
            throw new AssertionError((Object)var1_2);
        }
    }

    public static ByteString sha256(ByteString byteString) {
        try {
            ByteString byteString2 = ByteString.of(MessageDigest.getInstance((String)"SHA-256").digest(byteString.toByteArray()));
            return byteString2;
        }
        catch (NoSuchAlgorithmException var1_2) {
            throw new AssertionError((Object)var1_2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String shaBase64(String string2) {
        void var1_3;
        try {
            return ByteString.of(MessageDigest.getInstance((String)"SHA-1").digest(string2.getBytes("UTF-8"))).base64();
        }
        catch (NoSuchAlgorithmException var1_2) {
            do {
                throw new AssertionError((Object)var1_3);
                break;
            } while (true);
        }
        catch (UnsupportedEncodingException var1_4) {
            throw new AssertionError((Object)var1_3);
        }
    }

    /*
     * Exception decompiling
     */
    public static boolean skipAll(Source var0_1, int var1, TimeUnit var2_2) throws IOException {
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

    public static int skipLeadingAsciiWhitespace(String string2, int n2, int n3) {
        for (int i2 = n2; i2 < n3; ++i2) {
            switch (string2.charAt(i2)) {
                default: {
                    return i2;
                }
                case '\t': 
                case '\n': 
                case '\f': 
                case '\r': 
                case ' ': 
            }
        }
        return n3;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int skipTrailingAsciiWhitespace(String string2, int n2, int n3) {
        int n4 = n3 - 1;
        while (n4 >= n2) {
            switch (string2.charAt(n4)) {
                default: {
                    return n4 + 1;
                }
                case '\t': 
                case '\n': 
                case '\f': 
                case '\r': 
                case ' ': 
            }
            --n4;
        }
        return n2;
    }

    public static ThreadFactory threadFactory(final String string2, final boolean bl2) {
        return new ThreadFactory(){

            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, string2);
                thread.setDaemon(bl2);
                return thread;
            }
        };
    }

    /*
     * Unable to fully structure code
     */
    public static String toHumanReadableAscii(String var0) {
        var2_2 = var0.length();
        for (var1_1 = 0; var1_1 < var2_2; var1_1 += Character.charCount((int)var3_3)) {
            var3_3 = var0.codePointAt(var1_1);
            if (var3_3 > 31 && var3_3 < 127) {
                continue;
            }
            var4_4 = new Buffer();
            var4_4.writeUtf8(var0, 0, var1_1);
            block1 : for (var6_5 = var1_1; var6_5 < var2_2; var6_5 += Character.charCount((int)var7_7)) {
                var7_7 = var0.codePointAt(var6_5);
                if (var7_7 > 31 && var7_7 < 127) {
                    var8_6 = var7_7;
lbl12: // 2 sources:
                    do {
                        var4_4.writeUtf8CodePoint(var8_6);
                        continue block1;
                        break;
                    } while (true);
                }
                var8_6 = 63;
                ** continue;
            }
            var0 = var4_4.readUtf8();
            break;
        }
        return var0;
    }

    public static String trimSubstring(String string2, int n2, int n3) {
        int n4 = Util.skipLeadingAsciiWhitespace(string2, n2, n3);
        return string2.substring(n4, Util.skipTrailingAsciiWhitespace(string2, n4, n3));
    }

    public static boolean verifyAsIpAddress(String string2) {
        return VERIFY_AS_IP_ADDRESS.matcher((CharSequence)string2).matches();
    }

}

