/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  java.lang.Class
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalArgumentException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 */
import android.os.IBinder;
import java.lang.reflect.Field;

public final class aah<T>
extends aag.a {
    private final T a;

    private aah(T t2) {
        this.a = t2;
    }

    public static <T> aag a(T t2) {
        return new aah<T>(t2);
    }

    public static <T> T a(aag aag2) {
        if (aag2 instanceof aah) {
            return ((aah)aag2).a;
        }
        IBinder iBinder = aag2.asBinder();
        Field[] arrfield = iBinder.getClass().getDeclaredFields();
        if (arrfield.length == 1) {
            Field field = arrfield[0];
            if (!field.isAccessible()) {
                Object object;
                field.setAccessible(true);
                try {
                    object = field.get((Object)iBinder);
                }
                catch (NullPointerException var6_5) {
                    throw new IllegalArgumentException("Binder object is null.", (Throwable)var6_5);
                }
                catch (IllegalArgumentException var5_6) {
                    throw new IllegalArgumentException("remoteBinder is the wrong class.", (Throwable)var5_6);
                }
                catch (IllegalAccessException var4_7) {
                    throw new IllegalArgumentException("Could not access the field in remoteBinder.", (Throwable)var4_7);
                }
                return (T)object;
            }
            throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
        }
        throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
    }
}

