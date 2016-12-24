/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.CloneNotSupportedException
 *  java.lang.Cloneable
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Field
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 */
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class aja
implements ais,
Cloneable {
    public static final aja a = new aja();
    private double b = -1.0;
    private int c = 136;
    private boolean d = true;
    private boolean e;
    private List<aie> f = Collections.emptyList();
    private List<aie> g = Collections.emptyList();

    private boolean a(aiw aiw2) {
        if (aiw2 != null && aiw2.a() > this.b) {
            return false;
        }
        return true;
    }

    private boolean a(aiw aiw2, aix aix2) {
        if (super.a(aiw2) && super.a(aix2)) {
            return true;
        }
        return false;
    }

    private boolean a(aix aix2) {
        if (aix2 != null && aix2.a() <= this.b) {
            return false;
        }
        return true;
    }

    private boolean a(Class<?> class_) {
        if (!Enum.class.isAssignableFrom(class_) && (class_.isAnonymousClass() || class_.isLocalClass())) {
            return true;
        }
        return false;
    }

    private boolean b(Class<?> class_) {
        if (class_.isMemberClass() && !super.c(class_)) {
            return true;
        }
        return false;
    }

    private boolean c(Class<?> class_) {
        if ((8 & class_.getModifiers()) != 0) {
            return true;
        }
        return false;
    }

    @Override
    public <T> air<T> a(final aih aih2, final aju<T> aju2) {
        Class<T> class_ = aju2.getRawType();
        final boolean bl2 = this.a(class_, true);
        final boolean bl3 = this.a(class_, false);
        if (!bl2 && !bl3) {
            return null;
        }
        return new air<T>(){
            private air<T> f;

            private air<T> b() {
                air air2;
                air<T> air3 = this.f;
                if (air3 != null) {
                    return air3;
                }
                this.f = air2 = aih2.a(aja.this, aju2);
                return air2;
            }

            @Override
            public void a(ajw ajw2, T t2) throws IOException {
                if (bl2) {
                    ajw2.f();
                    return;
                }
                super.b().a(ajw2, t2);
            }

            @Override
            public T b(ajv ajv2) throws IOException {
                if (bl3) {
                    ajv2.n();
                    return null;
                }
                return super.b().b(ajv2);
            }
        };
    }

    protected aja a() {
        try {
            aja aja2 = (aja)super.clone();
            return aja2;
        }
        catch (CloneNotSupportedException var1_2) {
            throw new AssertionError((Object)var1_2);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean a(Class<?> class_, boolean bl2) {
        if (this.b != -1.0 && !super.a((aiw)class_.getAnnotation((Class)aiw.class), (aix)class_.getAnnotation((Class)aix.class))) {
            return true;
        }
        if (!this.d && super.b(class_)) {
            return true;
        }
        if (super.a(class_)) {
            return true;
        }
        List<aie> list = bl2 ? this.f : this.g;
        Iterator iterator = list.iterator();
        do {
            if (iterator.hasNext()) continue;
            return false;
        } while (!((aie)iterator.next()).a(class_));
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean a(Field field, boolean bl2) {
        ait ait2;
        if ((this.c & field.getModifiers()) != 0) {
            return true;
        }
        if (this.b != -1.0 && !super.a((aiw)field.getAnnotation((Class)aiw.class), (aix)field.getAnnotation((Class)aix.class))) {
            return true;
        }
        if (field.isSynthetic()) {
            return true;
        }
        if (this.e && ((ait2 = (ait)field.getAnnotation((Class)ait.class)) == null || (bl2 ? !ait2.a() : !ait2.b()))) {
            return true;
        }
        if (!this.d && super.b(field.getType())) {
            return true;
        }
        if (super.a(field.getType())) {
            return true;
        }
        List<aie> list = bl2 ? this.f : this.g;
        if (!list.isEmpty()) {
            aif aif2 = new aif(field);
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                if (!((aie)iterator.next()).a(aif2)) continue;
                return true;
            }
        }
        return false;
    }

    protected /* synthetic */ Object clone() throws CloneNotSupportedException {
        return this.a();
    }

}

