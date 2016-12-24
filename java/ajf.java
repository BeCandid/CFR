/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.ObjectInputStream
 *  java.io.ObjectStreamClass
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.lang.reflect.Field
 *  java.lang.reflect.Method
 */
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class ajf {
    public static ajf a() {
        try {
            Class class_ = Class.forName((String)"sun.misc.Unsafe");
            Field field = class_.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            Object object = field.get((Object)null);
            ajf ajf2 = new ajf(class_.getMethod("allocateInstance", new Class[]{Class.class}), object){
                final /* synthetic */ Method a;
                final /* synthetic */ Object b;

                @Override
                public <T> T a(Class<T> class_) throws Exception {
                    return (T)this.a.invoke(this.b, new Object[]{class_});
                }
            };
            return ajf2;
        }
        catch (Exception var0_4) {
            try {
                Method method = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});
                method.setAccessible(true);
                final int n2 = (Integer)method.invoke((Object)null, new Object[]{Object.class});
                Class[] arrclass = new Class[]{Class.class, Integer.TYPE};
                final Method method2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", arrclass);
                method2.setAccessible(true);
                ajf ajf3 = new ajf(){

                    @Override
                    public <T> T a(Class<T> class_) throws Exception {
                        Method method = method2;
                        Object[] arrobject = new Object[]{class_, n2};
                        return (T)method.invoke((Object)null, arrobject);
                    }
                };
                return ajf3;
            }
            catch (Exception var1_10) {
                try {
                    final Method method = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Class.class});
                    method.setAccessible(true);
                    ajf ajf4 = new ajf(){

                        @Override
                        public <T> T a(Class<T> class_) throws Exception {
                            return (T)method.invoke((Object)null, new Object[]{class_, Object.class});
                        }
                    };
                    return ajf4;
                }
                catch (Exception var2_13) {
                    return new ajf(){

                        @Override
                        public <T> T a(Class<T> class_) {
                            throw new UnsupportedOperationException("Cannot allocate " + class_);
                        }
                    };
                }
            }
        }
    }

    public abstract <T> T a(Class<T> var1) throws Exception;

}

