/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class yk {
    public static final yk a = yk.a("\t\n\u000b\f\r \u0085\u1680\u2028\u2029\u205f\u3000\u00a0\u180e\u202f").a(yk.a('\u2000', '\u200a'));
    public static final yk b = yk.a("\t\n\u000b\f\r \u0085\u1680\u2028\u2029\u205f\u3000").a(yk.a('\u2000', '\u2006')).a(yk.a('\u2008', '\u200a'));
    public static final yk c = yk.a('\u0000', '');
    public static final yk d;
    public static final yk e;
    public static final yk f;
    public static final yk g;
    public static final yk h;
    public static final yk i;
    public static final yk j;
    public static final yk k;
    public static final yk l;
    public static final yk m;
    public static final yk n;
    public static final yk o;

    static {
        yk yk2 = yk.a('0', '9');
        char[] arrc = "\u0660\u06f0\u07c0\u0966\u09e6\u0a66\u0ae6\u0b66\u0be6\u0c66\u0ce6\u0d66\u0e50\u0ed0\u0f20\u1040\u1090\u17e0\u1810\u1946\u19d0\u1b50\u1bb0\u1c40\u1c50\ua620\ua8d0\ua900\uaa50\uff10".toCharArray();
        int n2 = arrc.length;
        yk yk3 = yk2;
        for (int i2 = 0; i2 < n2; ++i2) {
            char c2 = arrc[i2];
            yk3 = yk3.a(yk.a(c2, (char)(c2 + 9)));
        }
        d = yk3;
        e = yk.a('\t', '\r').a(yk.a('\u001c', ' ')).a(yk.a('\u1680')).a(yk.a('\u180e')).a(yk.a('\u2000', '\u2006')).a(yk.a('\u2008', '\u200b')).a(yk.a('\u2028', '\u2029')).a(yk.a('\u205f')).a(yk.a('\u3000'));
        f = new yk(){

            @Override
            public boolean b(char c2) {
                return Character.isDigit((char)c2);
            }
        };
        g = new yk(){

            @Override
            public boolean b(char c2) {
                return Character.isLetter((char)c2);
            }
        };
        h = new yk(){

            @Override
            public boolean b(char c2) {
                return Character.isLetterOrDigit((char)c2);
            }
        };
        i = new yk(){

            @Override
            public boolean b(char c2) {
                return Character.isUpperCase((char)c2);
            }
        };
        j = new yk(){

            @Override
            public boolean b(char c2) {
                return Character.isLowerCase((char)c2);
            }
        };
        k = yk.a('\u0000', '\u001f').a(yk.a('', '\u009f'));
        l = yk.a('\u0000', ' ').a(yk.a('', '\u00a0')).a(yk.a('\u00ad')).a(yk.a('\u0600', '\u0603')).a(yk.a("\u06dd\u070f\u1680\u17b4\u17b5\u180e")).a(yk.a('\u2000', '\u200f')).a(yk.a('\u2028', '\u202f')).a(yk.a('\u205f', '\u2064')).a(yk.a('\u206a', '\u206f')).a(yk.a('\u3000')).a(yk.a('\ud800', '\uf8ff')).a(yk.a("\ufeff\ufff9\ufffa\ufffb"));
        m = yk.a('\u0000', '\u04f9').a(yk.a('\u05be')).a(yk.a('\u05d0', '\u05ea')).a(yk.a('\u05f3')).a(yk.a('\u05f4')).a(yk.a('\u0600', '\u06ff')).a(yk.a('\u0750', '\u077f')).a(yk.a('\u0e00', '\u0e7f')).a(yk.a('\u1e00', '\u20af')).a(yk.a('\u2100', '\u213a')).a(yk.a('\ufb50', '\ufdff')).a(yk.a('\ufe70', '\ufeff')).a(yk.a('\uff61', '\uffdc'));
        n = new yk(){

            @Override
            public yk a(yk yk2) {
                xz.a(yk2);
                return this;
            }

            @Override
            public boolean b(char c2) {
                return true;
            }

            @Override
            public boolean b(CharSequence charSequence) {
                xz.a(charSequence);
                return true;
            }
        };
        o = new yk(){

            @Override
            public yk a(yk yk2) {
                return xz.a(yk2);
            }

            @Override
            public boolean b(char c2) {
                return false;
            }

            @Override
            public boolean b(CharSequence charSequence) {
                if (charSequence.length() == 0) {
                    return true;
                }
                return false;
            }
        };
    }

    public static yk a(char c2) {
        return new yk(){

            @Override
            public yk a(yk yk2) {
                if (yk2.b(p)) {
                    return yk2;
                }
                return super.a(yk2);
            }

            @Override
            public boolean b(char c2) {
                if (c2 == p) {
                    return true;
                }
                return false;
            }
        };
    }

    /*
     * Enabled aggressive block sorting
     */
    public static yk a(char c2, final char c3) {
        boolean bl2 = c3 >= c2;
        xz.b(bl2);
        return new yk(){

            @Override
            public boolean b(char c2) {
                if (p <= c2 && c2 <= c3) {
                    return true;
                }
                return false;
            }
        };
    }

    public static yk a(CharSequence charSequence) {
        switch (charSequence.length()) {
            default: {
                char[] arrc = charSequence.toString().toCharArray();
                Arrays.sort((char[])arrc);
                return new yk(){

                    @Override
                    public boolean b(char c2) {
                        if (Arrays.binarySearch((char[])p, (char)c2) >= 0) {
                            return true;
                        }
                        return false;
                    }
                };
            }
            case 0: {
                return o;
            }
            case 1: {
                return yk.a(charSequence.charAt(0));
            }
            case 2: 
        }
        return new yk(charSequence.charAt(1)){
            final /* synthetic */ char q;

            @Override
            public boolean b(char c2) {
                if (c2 == p || c2 == this.q) {
                    return true;
                }
                return false;
            }
        };
    }

    public yk a(yk yk2) {
        Object[] arrobject = new yk[]{this, xz.a(yk2)};
        return new a(Arrays.asList((Object[])arrobject));
    }

    public abstract boolean b(char var1);

    public boolean b(CharSequence charSequence) {
        for (int i2 = -1 + charSequence.length(); i2 >= 0; --i2) {
            if (this.b(charSequence.charAt(i2))) continue;
            return false;
        }
        return true;
    }

    static class a
    extends yk {
        List<yk> p;

        a(List<yk> list) {
            this.p = list;
        }

        @Override
        public yk a(yk yk2) {
            ArrayList arrayList = new ArrayList(this.p);
            arrayList.add((Object)xz.a(yk2));
            return new a((List<yk>)arrayList);
        }

        @Override
        public boolean b(char c2) {
            Iterator iterator = this.p.iterator();
            while (iterator.hasNext()) {
                if (!((yk)iterator.next()).b(c2)) continue;
                return true;
            }
            return false;
        }
    }

}

