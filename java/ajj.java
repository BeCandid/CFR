/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.annotation.Annotation
 */
import java.lang.annotation.Annotation;

public final class ajj
implements ais {
    private final aiz a;

    public ajj(aiz aiz2) {
        this.a = aiz2;
    }

    /*
     * Enabled aggressive block sorting
     */
    static air<?> a(aiz aiz2, aih aih2, aju<?> aju2, aiu aiu2) {
        void var5_8;
        void var5_6;
        Class class_ = aiu2.a();
        if (air.class.isAssignableFrom(class_)) {
            air air2 = (air)aiz2.a(aju.get(class_)).a();
        } else {
            if (!ais.class.isAssignableFrom(class_)) {
                throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter or TypeAdapterFactory reference.");
            }
            air air3 = ((ais)aiz2.a(aju.get(class_)).a()).a(aih2, aju2);
        }
        if (var5_6 != null) {
            air air4 = var5_6.a();
        }
        return var5_8;
    }

    @Override
    public <T> air<T> a(aih aih2, aju<T> aju2) {
        aiu aiu2 = (aiu)aju2.getRawType().getAnnotation((Class)aiu.class);
        if (aiu2 == null) {
            return null;
        }
        return ajj.a(this.a, aih2, aju2, aiu2);
    }
}

