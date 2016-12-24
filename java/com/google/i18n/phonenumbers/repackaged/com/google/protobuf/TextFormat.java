/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.logging.Logger
 */
package com.google.i18n.phonenumbers.repackaged.com.google.protobuf;

import java.io.IOException;
import java.util.logging.Logger;

public final class TextFormat {
    private static final Logger a = Logger.getLogger((String)TextFormat.class.getName());
    private static final a b = new a(null);
    private static final a c = a.a(new a(null), true);
    private static final a d = a.b(new a(null), false);
    private static final Parser e = Parser.a().a();

    private TextFormat() {
    }

    public static class ParseException
    extends IOException {
    }

    public static class Parser {
        private final boolean a;
        private final SingularOverwritePolicy b;

        private Parser(boolean bl2, SingularOverwritePolicy singularOverwritePolicy) {
            this.a = bl2;
            this.b = singularOverwritePolicy;
        }

        /* synthetic */ Parser(boolean bl2, SingularOverwritePolicy singularOverwritePolicy,  var3_2) {
            super(bl2, singularOverwritePolicy);
        }

        public static a a() {
            return new a();
        }

        public static final class SingularOverwritePolicy
        extends Enum<SingularOverwritePolicy> {
            public static final /* enum */ SingularOverwritePolicy a = new SingularOverwritePolicy();
            public static final /* enum */ SingularOverwritePolicy b = new SingularOverwritePolicy();
            private static final /* synthetic */ SingularOverwritePolicy[] c;

            static {
                SingularOverwritePolicy[] arrsingularOverwritePolicy = new SingularOverwritePolicy[]{a, b};
                c = arrsingularOverwritePolicy;
            }

            private SingularOverwritePolicy() {
                super(string2, n2);
            }

            public static SingularOverwritePolicy valueOf(String string2) {
                return (SingularOverwritePolicy)Enum.valueOf((Class)SingularOverwritePolicy.class, (String)string2);
            }

            public static SingularOverwritePolicy[] values() {
                return (SingularOverwritePolicy[])c.clone();
            }
        }

        public static class a {
            private boolean a = false;
            private SingularOverwritePolicy b = SingularOverwritePolicy.a;

            public Parser a() {
                return new Parser(this.a, this.b, null);
            }
        }

    }

    static final class a {
        boolean a;
        boolean b;

        private a() {
            this.a = false;
            this.b = true;
        }

        /* synthetic */ a( var1) {
        }

        static /* synthetic */ a a(a a2, boolean bl2) {
            return a2.a(bl2);
        }

        private a a(boolean bl2) {
            this.a = bl2;
            return this;
        }

        static /* synthetic */ a b(a a2, boolean bl2) {
            return a2.b(bl2);
        }

        private a b(boolean bl2) {
            this.b = bl2;
            return this;
        }
    }

}

