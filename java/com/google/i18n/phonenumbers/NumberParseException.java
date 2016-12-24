/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.google.i18n.phonenumbers;

public class NumberParseException
extends Exception {
    private ErrorType a;
    private String b;

    public NumberParseException(ErrorType errorType, String string2) {
        super(string2);
        this.b = string2;
        this.a = errorType;
    }

    public ErrorType a() {
        return this.a;
    }

    public String toString() {
        String string2 = String.valueOf((Object)String.valueOf((Object)((Object)this.a)));
        String string3 = String.valueOf((Object)String.valueOf((Object)this.b));
        return new StringBuilder(14 + string2.length() + string3.length()).append("Error type: ").append(string2).append(". ").append(string3).toString();
    }

    public static final class ErrorType
    extends Enum<ErrorType> {
        public static final /* enum */ ErrorType a = new ErrorType();
        public static final /* enum */ ErrorType b = new ErrorType();
        public static final /* enum */ ErrorType c = new ErrorType();
        public static final /* enum */ ErrorType d = new ErrorType();
        public static final /* enum */ ErrorType e = new ErrorType();
        private static final /* synthetic */ ErrorType[] f;

        static {
            ErrorType[] arrerrorType = new ErrorType[]{a, b, c, d, e};
            f = arrerrorType;
        }

        private ErrorType() {
            super(string2, n2);
        }

        public static ErrorType valueOf(String string2) {
            return (ErrorType)Enum.valueOf((Class)ErrorType.class, (String)string2);
        }

        public static ErrorType[] values() {
            return (ErrorType[])f.clone();
        }
    }

}

