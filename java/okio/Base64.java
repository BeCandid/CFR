/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.UnsupportedEncodingException
 *  java.lang.AssertionError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package okio;

import java.io.UnsupportedEncodingException;

final class Base64 {
    private static final byte[] MAP = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] URL_MAP = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    private Base64() {
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static byte[] decode(String var0) {
        var1_1 = var0.length();
        do {
            if (var1_1 <= 0 || (var20_2 = var0.charAt(var1_1 - 1)) != '=' && var20_2 != '\n' && var20_2 != '\r' && var20_2 != ' ' && var20_2 != '\t') break;
            --var1_1;
        } while (true);
        var2_3 = new byte[(int)(6 * (long)var1_1 / 8)];
        var3_4 = 0;
        var4_5 = 0;
        var5_6 = 0;
        var6_7 = 0;
        do {
            if (var5_6 >= var1_1) ** GOTO lbl42
            var14_9 = var0.charAt(var5_6);
            if (var14_9 < 'A' || var14_9 > 'Z') ** GOTO lbl17
            var15_11 = var14_9 - 65;
            ** GOTO lbl28
lbl17: // 1 sources:
            if (var14_9 < 'a' || var14_9 > 'z') ** GOTO lbl20
            var15_11 = var14_9 - 71;
            ** GOTO lbl28
lbl20: // 1 sources:
            if (var14_9 < '0' || var14_9 > '9') ** GOTO lbl23
            var15_11 = var14_9 + 4;
            ** GOTO lbl28
lbl23: // 1 sources:
            if (var14_9 != '+' && var14_9 != '-') ** GOTO lbl26
            var15_11 = 62;
            ** GOTO lbl28
lbl26: // 1 sources:
            if (var14_9 != '/' && var14_9 != '_') ** GOTO lbl37
            var15_11 = 63;
lbl28: // 5 sources:
            var4_5 = var4_5 << 6 | (byte)var15_11;
            if (++var3_4 % 4 != 0) ** GOTO lbl61
            var17_8 = var6_7 + 1;
            var2_3[var6_7] = (byte)(var4_5 >> 16);
            var18_12 = var17_8 + 1;
            var2_3[var17_8] = (byte)(var4_5 >> 8);
            var16_10 = var18_12 + 1;
            var2_3[var18_12] = (byte)var4_5;
            ** GOTO lbl62
lbl37: // 1 sources:
            if (var14_9 == '\n' || var14_9 == '\r' || var14_9 == ' ') ** GOTO lbl61
            if (var14_9 != '\t') {
                return null;
            }
            var16_10 = var6_7;
            ** GOTO lbl62
lbl42: // 1 sources:
            var7_13 = var3_4 % 4;
            if (var7_13 == 1) {
                return null;
            }
            if (var7_13 == 2) {
                var12_14 = var4_5 << 12;
                var8_15 = var6_7 + 1;
                var2_3[var6_7] = (byte)(var12_14 >> 16);
            } else {
                if (var7_13 == 3) {
                    var10_17 = var4_5 << 6;
                    var11_18 = var6_7 + 1;
                    var2_3[var6_7] = (byte)(var10_17 >> 16);
                    var6_7 = var11_18 + 1;
                    var2_3[var11_18] = (byte)(var10_17 >> 8);
                }
                var8_15 = var6_7;
            }
            if (var8_15 == var2_3.length) return var2_3;
            var9_16 = new byte[var8_15];
            System.arraycopy((Object)var2_3, (int)0, (Object)var9_16, (int)0, (int)var8_15);
            return var9_16;
lbl61: // 2 sources:
            var16_10 = var6_7;
lbl62: // 3 sources:
            ++var5_6;
            var6_7 = var16_10;
        } while (true);
    }

    public static String encode(byte[] arrby) {
        return Base64.encode(arrby, MAP);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static String encode(byte[] var0_1, byte[] var1) {
        var2_2 = new byte[4 * (2 + var0_1.length) / 3];
        var3_3 = var0_1.length - var0_1.length % 3;
        var5_5 = 0;
        for (var4_4 = 0; var4_4 < var3_3; var4_4 += 3) {
            var16_7 = var5_5 + 1;
            var2_2[var5_5] = var1[(255 & var0_1[var4_4]) >> 2];
            var17_6 = var16_7 + 1;
            var2_2[var16_7] = var1[(3 & var0_1[var4_4]) << 4 | (255 & var0_1[var4_4 + 1]) >> 4];
            var18_8 = var17_6 + 1;
            var2_2[var17_6] = var1[(15 & var0_1[var4_4 + 1]) << 2 | (255 & var0_1[var4_4 + 2]) >> 6];
            var5_5 = var18_8 + 1;
            var2_2[var18_8] = var1[63 & var0_1[var4_4 + 2]];
        }
        switch (var0_1.length % 3) {
            default: {
                break;
            }
            case 1: {
                var12_11 = var5_5 + 1;
                var2_2[var5_5] = var1[(255 & var0_1[var3_3]) >> 2];
                var13_12 = var12_11 + 1;
                var2_2[var12_11] = var1[(3 & var0_1[var3_3]) << 4];
                var14_13 = var13_12 + 1;
                var2_2[var13_12] = 61;
                var15_14 = var14_13 + 1;
                var2_2[var14_13] = 61;
                var9_9 = var15_14;
                ** GOTO lbl38
            }
            case 2: {
                var6_15 = var5_5 + 1;
                var2_2[var5_5] = var1[(255 & var0_1[var3_3]) >> 2];
                var7_16 = var6_15 + 1;
                var2_2[var6_15] = var1[(3 & var0_1[var3_3]) << 4 | (255 & var0_1[var3_3 + 1]) >> 4];
                var8_17 = var7_16 + 1;
                var2_2[var7_16] = var1[(15 & var0_1[var3_3 + 1]) << 2];
                var5_5 = var8_17 + 1;
                var2_2[var8_17] = 61;
            }
        }
        var9_9 = var5_5;
lbl38: // 2 sources:
        try {
            return new String(var2_2, 0, var9_9, "US-ASCII");
        }
        catch (UnsupportedEncodingException var11_18) {
            throw new AssertionError((Object)var11_18);
        }
    }

    public static String encodeUrl(byte[] arrby) {
        return Base64.encode(arrby, URL_MAP);
    }
}

