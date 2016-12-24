/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class xw {
    public static int a(Parcel parcel) {
        return xw.b(parcel, 20293);
    }

    public static void a(Parcel parcel, int n2) {
        xw.c(parcel, n2);
    }

    public static void a(Parcel parcel, int n2, byte by2) {
        xw.b(parcel, n2, 4);
        parcel.writeInt((int)by2);
    }

    public static void a(Parcel parcel, int n2, double d2) {
        xw.b(parcel, n2, 8);
        parcel.writeDouble(d2);
    }

    public static void a(Parcel parcel, int n2, float f2) {
        xw.b(parcel, n2, 4);
        parcel.writeFloat(f2);
    }

    public static void a(Parcel parcel, int n2, int n3) {
        xw.b(parcel, n2, 4);
        parcel.writeInt(n3);
    }

    public static void a(Parcel parcel, int n2, long l2) {
        xw.b(parcel, n2, 8);
        parcel.writeLong(l2);
    }

    public static void a(Parcel parcel, int n2, Bundle bundle, boolean bl2) {
        if (bundle == null) {
            if (bl2) {
                xw.b(parcel, n2, 0);
            }
            return;
        }
        int n3 = xw.b(parcel, n2);
        parcel.writeBundle(bundle);
        xw.c(parcel, n3);
    }

    public static void a(Parcel parcel, int n2, IBinder iBinder, boolean bl2) {
        if (iBinder == null) {
            if (bl2) {
                xw.b(parcel, n2, 0);
            }
            return;
        }
        int n3 = xw.b(parcel, n2);
        parcel.writeStrongBinder(iBinder);
        xw.c(parcel, n3);
    }

    public static void a(Parcel parcel, int n2, Parcelable parcelable, int n3, boolean bl2) {
        if (parcelable == null) {
            if (bl2) {
                xw.b(parcel, n2, 0);
            }
            return;
        }
        int n4 = xw.b(parcel, n2);
        parcelable.writeToParcel(parcel, n3);
        xw.c(parcel, n4);
    }

    public static void a(Parcel parcel, int n2, Double d2, boolean bl2) {
        if (d2 == null) {
            if (bl2) {
                xw.b(parcel, n2, 0);
            }
            return;
        }
        xw.b(parcel, n2, 8);
        parcel.writeDouble(d2.doubleValue());
    }

    public static void a(Parcel parcel, int n2, Float f2, boolean bl2) {
        if (f2 == null) {
            if (bl2) {
                xw.b(parcel, n2, 0);
            }
            return;
        }
        xw.b(parcel, n2, 4);
        parcel.writeFloat(f2.floatValue());
    }

    public static void a(Parcel parcel, int n2, Integer n3, boolean bl2) {
        if (n3 == null) {
            if (bl2) {
                xw.b(parcel, n2, 0);
            }
            return;
        }
        xw.b(parcel, n2, 4);
        parcel.writeInt(n3.intValue());
    }

    public static void a(Parcel parcel, int n2, Long l2, boolean bl2) {
        if (l2 == null) {
            if (bl2) {
                xw.b(parcel, n2, 0);
            }
            return;
        }
        xw.b(parcel, n2, 8);
        parcel.writeLong(l2.longValue());
    }

    public static void a(Parcel parcel, int n2, String string2, boolean bl2) {
        if (string2 == null) {
            if (bl2) {
                xw.b(parcel, n2, 0);
            }
            return;
        }
        int n3 = xw.b(parcel, n2);
        parcel.writeString(string2);
        xw.c(parcel, n3);
    }

    public static void a(Parcel parcel, int n2, List<Integer> list, boolean bl2) {
        if (list == null) {
            if (bl2) {
                xw.b(parcel, n2, 0);
            }
            return;
        }
        int n3 = xw.b(parcel, n2);
        int n4 = list.size();
        parcel.writeInt(n4);
        for (int i2 = 0; i2 < n4; ++i2) {
            parcel.writeInt(((Integer)list.get(i2)).intValue());
        }
        xw.c(parcel, n3);
    }

    public static void a(Parcel parcel, int n2, short s2) {
        xw.b(parcel, n2, 4);
        parcel.writeInt((int)s2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void a(Parcel parcel, int n2, boolean bl2) {
        xw.b(parcel, n2, 4);
        int n3 = bl2 ? 1 : 0;
        parcel.writeInt(n3);
    }

    public static void a(Parcel parcel, int n2, byte[] arrby, boolean bl2) {
        if (arrby == null) {
            if (bl2) {
                xw.b(parcel, n2, 0);
            }
            return;
        }
        int n3 = xw.b(parcel, n2);
        parcel.writeByteArray(arrby);
        xw.c(parcel, n3);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static <T extends Parcelable> void a(Parcel parcel, int n2, T[] arrT, int n3, boolean bl2) {
        if (arrT == null) {
            if (bl2) {
                xw.b(parcel, n2, 0);
            }
            return;
        }
        int n4 = xw.b(parcel, n2);
        int n5 = arrT.length;
        parcel.writeInt(n5);
        int n6 = 0;
        do {
            if (n6 >= n5) {
                xw.c(parcel, n4);
                return;
            }
            T t2 = arrT[n6];
            if (t2 == null) {
                parcel.writeInt(0);
            } else {
                xw.a(parcel, t2, n3);
            }
            ++n6;
        } while (true);
    }

    public static void a(Parcel parcel, int n2, String[] arrstring, boolean bl2) {
        if (arrstring == null) {
            if (bl2) {
                xw.b(parcel, n2, 0);
            }
            return;
        }
        int n3 = xw.b(parcel, n2);
        parcel.writeStringArray(arrstring);
        xw.c(parcel, n3);
    }

    private static <T extends Parcelable> void a(Parcel parcel, T t2, int n2) {
        int n3 = parcel.dataPosition();
        parcel.writeInt(1);
        int n4 = parcel.dataPosition();
        t2.writeToParcel(parcel, n2);
        int n5 = parcel.dataPosition();
        parcel.setDataPosition(n3);
        parcel.writeInt(n5 - n4);
        parcel.setDataPosition(n5);
    }

    private static int b(Parcel parcel, int n2) {
        parcel.writeInt(-65536 | n2);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void b(Parcel parcel, int n2, int n3) {
        if (n3 >= 65535) {
            parcel.writeInt(-65536 | n2);
            parcel.writeInt(n3);
            return;
        }
        parcel.writeInt(n2 | n3 << 16);
    }

    public static void b(Parcel parcel, int n2, List<String> list, boolean bl2) {
        if (list == null) {
            if (bl2) {
                xw.b(parcel, n2, 0);
            }
            return;
        }
        int n3 = xw.b(parcel, n2);
        parcel.writeStringList(list);
        xw.c(parcel, n3);
    }

    private static void c(Parcel parcel, int n2) {
        int n3 = parcel.dataPosition();
        int n4 = n3 - n2;
        parcel.setDataPosition(n2 - 4);
        parcel.writeInt(n4);
        parcel.setDataPosition(n3);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static <T extends Parcelable> void c(Parcel parcel, int n2, List<T> list, boolean bl2) {
        if (list == null) {
            if (bl2) {
                xw.b(parcel, n2, 0);
            }
            return;
        }
        int n3 = xw.b(parcel, n2);
        int n4 = list.size();
        parcel.writeInt(n4);
        int n5 = 0;
        do {
            if (n5 >= n4) {
                xw.c(parcel, n3);
                return;
            }
            Parcelable parcelable = (Parcelable)list.get(n5);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                xw.a(parcel, parcelable, 0);
            }
            ++n5;
        } while (true);
    }

    public static void d(Parcel parcel, int n2, List list, boolean bl2) {
        if (list == null) {
            if (bl2) {
                xw.b(parcel, n2, 0);
            }
            return;
        }
        int n3 = xw.b(parcel, n2);
        parcel.writeList(list);
        xw.c(parcel, n3);
    }
}

