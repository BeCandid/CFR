/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.google.gson.internal.
 *  com.google.gson.internal.$Gson
 *  com.google.gson.internal.$Gson$Types
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.GenericArrayType
 *  java.lang.reflect.ParameterizedType
 *  java.lang.reflect.Type
 *  java.lang.reflect.TypeVariable
 *  java.util.HashMap
 *  java.util.Map
 */
import com.google.gson.internal.;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

public class aju<T> {
    final int hashCode;
    final Class<? super T> rawType;
    final Type type;

    public aju() {
        this.type = aju.getSuperclassTypeParameter(this.getClass());
        this.rawType = .Gson.Types.e((Type)this.type);
        this.hashCode = this.type.hashCode();
    }

    aju(Type type) {
        this.type = .Gson.Types.d((Type)aiy.a(type));
        this.rawType = .Gson.Types.e((Type)this.type);
        this.hashCode = this.type.hashCode();
    }

    private static /* varargs */ AssertionError buildUnexpectedTypeError(Type type, Class<?> ... arrclass) {
        StringBuilder stringBuilder = new StringBuilder("Unexpected type. Expected one of: ");
        int n2 = arrclass.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            stringBuilder.append(arrclass[i2].getName()).append(", ");
        }
        stringBuilder.append("but got: ").append(type.getClass().getName()).append(", for type token: ").append(type.toString()).append('.');
        return new AssertionError((Object)stringBuilder.toString());
    }

    public static <T> aju<T> get(Class<T> class_) {
        return new aju<T>((Type)class_);
    }

    public static aju<?> get(Type type) {
        return new aju<T>(type);
    }

    static Type getSuperclassTypeParameter(Class<?> class_) {
        Type type = class_.getGenericSuperclass();
        if (type instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return .Gson.Types.d((Type)((ParameterizedType)type).getActualTypeArguments()[0]);
    }

    /*
     * Enabled aggressive block sorting
     */
    private static boolean isAssignableFrom(Type type, GenericArrayType genericArrayType) {
        Type type2 = genericArrayType.getGenericComponentType();
        if (!(type2 instanceof ParameterizedType)) return true;
        Type type3 = type;
        if (type instanceof GenericArrayType) {
            type3 = ((GenericArrayType)type).getGenericComponentType();
            return aju.isAssignableFrom(type3, (ParameterizedType)type2, new HashMap());
        }
        if (!(type instanceof Class)) return aju.isAssignableFrom(type3, (ParameterizedType)type2, new HashMap());
        Class class_ = (Class)type;
        do {
            if (!class_.isArray()) {
                type3 = class_;
                return aju.isAssignableFrom(type3, (ParameterizedType)type2, new HashMap());
            }
            class_ = class_.getComponentType();
        } while (true);
    }

    private static boolean isAssignableFrom(Type type, ParameterizedType parameterizedType, Map<String, Type> map) {
        if (type == null) {
            return false;
        }
        if (parameterizedType.equals((Object)type)) {
            return true;
        }
        Class class_ = .Gson.Types.e((Type)type);
        boolean bl2 = type instanceof ParameterizedType;
        ParameterizedType parameterizedType2 = null;
        if (bl2) {
            parameterizedType2 = (ParameterizedType)type;
        }
        if (parameterizedType2 != null) {
            Type[] arrtype = parameterizedType2.getActualTypeArguments();
            TypeVariable[] arrtypeVariable = class_.getTypeParameters();
            for (int i2 = 0; i2 < arrtype.length; ++i2) {
                Type type2 = arrtype[i2];
                TypeVariable typeVariable = arrtypeVariable[i2];
                while (type2 instanceof TypeVariable) {
                    type2 = (Type)map.get((Object)((TypeVariable)type2).getName());
                }
                map.put((Object)typeVariable.getName(), (Object)type2);
            }
            if (aju.typeEquals(parameterizedType2, parameterizedType, map)) {
                return true;
            }
        }
        Type[] arrtype = class_.getGenericInterfaces();
        int n2 = arrtype.length;
        for (int i3 = 0; i3 < n2; ++i3) {
            if (!aju.isAssignableFrom(arrtype[i3], parameterizedType, new HashMap(map))) continue;
            return true;
        }
        return aju.isAssignableFrom(class_.getGenericSuperclass(), parameterizedType, new HashMap(map));
    }

    private static boolean matches(Type type, Type type2, Map<String, Type> map) {
        if (type2.equals((Object)type) || type instanceof TypeVariable && type2.equals(map.get((Object)((TypeVariable)type).getName()))) {
            return true;
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean typeEquals(ParameterizedType parameterizedType, ParameterizedType parameterizedType2, Map<String, Type> map) {
        if (!parameterizedType.getRawType().equals((Object)parameterizedType2.getRawType())) return false;
        Type[] arrtype = parameterizedType.getActualTypeArguments();
        Type[] arrtype2 = parameterizedType2.getActualTypeArguments();
        int n2 = 0;
        while (n2 < arrtype.length) {
            if (!aju.matches(arrtype[n2], arrtype2[n2], map)) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    public final boolean equals(Object object) {
        if (object instanceof aju && .Gson.Types.a((Type)this.type, (Type)((aju)object).type)) {
            return true;
        }
        return false;
    }

    public final Class<? super T> getRawType() {
        return this.rawType;
    }

    public final Type getType() {
        return this.type;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    @Deprecated
    public boolean isAssignableFrom(aju<?> aju2) {
        return this.isAssignableFrom(aju2.getType());
    }

    @Deprecated
    public boolean isAssignableFrom(Class<?> class_) {
        return this.isAssignableFrom((Type)class_);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Deprecated
    public boolean isAssignableFrom(Type type) {
        if (type == null) {
            return false;
        }
        if (this.type.equals((Object)type)) {
            return true;
        }
        if (this.type instanceof Class) {
            return this.rawType.isAssignableFrom(.Gson.Types.e((Type)type));
        }
        if (this.type instanceof ParameterizedType) {
            return aju.isAssignableFrom(type, (ParameterizedType)this.type, new HashMap());
        }
        if (!(this.type instanceof GenericArrayType)) throw aju.buildUnexpectedTypeError(this.type, Class.class, ParameterizedType.class, GenericArrayType.class);
        if (!this.rawType.isAssignableFrom(.Gson.Types.e((Type)type))) return false;
        if (!aju.isAssignableFrom(type, (GenericArrayType)this.type)) return false;
        return true;
    }

    public final String toString() {
        return .Gson.Types.f((Type)this.type);
    }
}

