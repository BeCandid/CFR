/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Long
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.google.i18n.phonenumbers;

import java.io.Serializable;

public final class Phonenumber {

    public static class PhoneNumber
    implements Serializable {
        private boolean a;
        private int b = 0;
        private boolean c;
        private long d = 0;
        private boolean e;
        private String f = "";
        private boolean g;
        private boolean h = false;
        private boolean i;
        private int j = 1;
        private boolean k;
        private String l = "";
        private boolean m;
        private CountryCodeSource n = CountryCodeSource.a;
        private boolean o;
        private String p = "";

        public int a() {
            return this.b;
        }

        public PhoneNumber a(int n2) {
            this.a = true;
            this.b = n2;
            return this;
        }

        public PhoneNumber a(long l2) {
            this.c = true;
            this.d = l2;
            return this;
        }

        public PhoneNumber a(CountryCodeSource countryCodeSource) {
            if (countryCodeSource == null) {
                throw new NullPointerException();
            }
            this.m = true;
            this.n = countryCodeSource;
            return this;
        }

        public PhoneNumber a(String string2) {
            if (string2 == null) {
                throw new NullPointerException();
            }
            this.e = true;
            this.f = string2;
            return this;
        }

        public PhoneNumber a(boolean bl2) {
            this.g = true;
            this.h = bl2;
            return this;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public boolean a(PhoneNumber phoneNumber) {
            boolean bl2 = true;
            if (phoneNumber == null) {
                return false;
            }
            if (this == phoneNumber) return bl2;
            if (this.b != phoneNumber.b) return false;
            if (this.d != phoneNumber.d) return false;
            if (!this.f.equals((Object)phoneNumber.f)) return false;
            if (this.h != phoneNumber.h) return false;
            if (this.j != phoneNumber.j) return false;
            if (!this.l.equals((Object)phoneNumber.l)) return false;
            if (this.n != phoneNumber.n) return false;
            if (!this.p.equals((Object)phoneNumber.p)) return false;
            if (this.n() == phoneNumber.n()) return bl2;
            return false;
        }

        public long b() {
            return this.d;
        }

        public PhoneNumber b(int n2) {
            this.i = true;
            this.j = n2;
            return this;
        }

        public PhoneNumber b(String string2) {
            if (string2 == null) {
                throw new NullPointerException();
            }
            this.k = true;
            this.l = string2;
            return this;
        }

        public PhoneNumber c(String string2) {
            if (string2 == null) {
                throw new NullPointerException();
            }
            this.o = true;
            this.p = string2;
            return this;
        }

        public boolean c() {
            return this.e;
        }

        public String d() {
            return this.f;
        }

        public boolean e() {
            return this.g;
        }

        public boolean equals(Object object) {
            if (object instanceof PhoneNumber && this.a((PhoneNumber)object)) {
                return true;
            }
            return false;
        }

        public boolean f() {
            return this.h;
        }

        public boolean g() {
            return this.i;
        }

        public int h() {
            return this.j;
        }

        /*
         * Enabled aggressive block sorting
         */
        public int hashCode() {
            int n2 = 1231;
            int n3 = 53 * (53 * (53 * (2173 + this.a()) + Long.valueOf((long)this.b()).hashCode()) + this.d().hashCode());
            int n4 = this.f() ? n2 : 1237;
            int n5 = 53 * (53 * (53 * (53 * (53 * (n3 + n4) + this.h()) + this.j().hashCode()) + this.l().hashCode()) + this.o().hashCode());
            if (this.n()) {
                return n5 + n2;
            }
            n2 = 1237;
            return n5 + n2;
        }

        public boolean i() {
            return this.k;
        }

        public String j() {
            return this.l;
        }

        public boolean k() {
            return this.m;
        }

        public CountryCodeSource l() {
            return this.n;
        }

        public PhoneNumber m() {
            this.m = false;
            this.n = CountryCodeSource.a;
            return this;
        }

        public boolean n() {
            return this.o;
        }

        public String o() {
            return this.p;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Country Code: ").append(this.b);
            stringBuilder.append(" National Number: ").append(this.d);
            if (this.e() && this.f()) {
                stringBuilder.append(" Leading Zero(s): true");
            }
            if (this.g()) {
                stringBuilder.append(" Number of leading zeros: ").append(this.j);
            }
            if (this.c()) {
                stringBuilder.append(" Extension: ").append(this.f);
            }
            if (this.k()) {
                stringBuilder.append(" Country Code Source: ").append((Object)this.n);
            }
            if (this.n()) {
                stringBuilder.append(" Preferred Domestic Carrier Code: ").append(this.p);
            }
            return stringBuilder.toString();
        }

        public static final class CountryCodeSource
        extends Enum<CountryCodeSource> {
            public static final /* enum */ CountryCodeSource a = new CountryCodeSource();
            public static final /* enum */ CountryCodeSource b = new CountryCodeSource();
            public static final /* enum */ CountryCodeSource c = new CountryCodeSource();
            public static final /* enum */ CountryCodeSource d = new CountryCodeSource();
            private static final /* synthetic */ CountryCodeSource[] e;

            static {
                CountryCodeSource[] arrcountryCodeSource = new CountryCodeSource[]{a, b, c, d};
                e = arrcountryCodeSource;
            }

            private CountryCodeSource() {
                super(string2, n2);
            }

            public static CountryCodeSource valueOf(String string2) {
                return (CountryCodeSource)Enum.valueOf((Class)CountryCodeSource.class, (String)string2);
            }

            public static CountryCodeSource[] values() {
                return (CountryCodeSource[])e.clone();
            }
        }

    }

}

