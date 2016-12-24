/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.IllegalAccessException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 */
package okhttp3.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class OptionalMethod<T> {
    private final String methodName;
    private final Class[] methodParams;
    private final Class<?> returnType;

    public /* varargs */ OptionalMethod(Class<?> class_, String string2, Class ... arrclass) {
        this.returnType = class_;
        this.methodName = string2;
        this.methodParams = arrclass;
    }

    private Method getMethod(Class<?> class_) {
        String string2 = this.methodName;
        Method method = null;
        if (string2 != null && (method = OptionalMethod.getPublicMethod(class_, this.methodName, this.methodParams)) != null && this.returnType != null && !this.returnType.isAssignableFrom(method.getReturnType())) {
            method = null;
        }
        return method;
    }

    private static Method getPublicMethod(Class<?> class_, String string2, Class[] arrclass) {
        int n2;
        Method method = null;
        try {
            method = class_.getMethod(string2, arrclass);
            n2 = method.getModifiers();
        }
        catch (NoSuchMethodException var4_5) {
            return method;
        }
        if ((n2 & 1) == 0) {
            method = null;
        }
        return method;
    }

    public /* varargs */ Object invoke(T t2, Object ... arrobject) throws InvocationTargetException {
        Method method = super.getMethod(t2.getClass());
        if (method == null) {
            throw new AssertionError((Object)("Method " + this.methodName + " not supported for object " + t2));
        }
        try {
            Object object = method.invoke(t2, arrobject);
            return object;
        }
        catch (IllegalAccessException var4_5) {
            AssertionError assertionError = new AssertionError((Object)("Unexpectedly could not call: " + (Object)method));
            assertionError.initCause((Throwable)var4_5);
            throw assertionError;
        }
    }

    public /* varargs */ Object invokeOptional(T t2, Object ... arrobject) throws InvocationTargetException {
        Method method = super.getMethod(t2.getClass());
        if (method == null) {
            return null;
        }
        try {
            Object object = method.invoke(t2, arrobject);
            return object;
        }
        catch (IllegalAccessException var4_5) {
            return null;
        }
    }

    public /* varargs */ Object invokeOptionalWithoutCheckedException(T t2, Object ... arrobject) {
        try {
            Object object = this.invokeOptional(t2, arrobject);
            return object;
        }
        catch (InvocationTargetException var3_4) {
            Throwable throwable = var3_4.getTargetException();
            if (throwable instanceof RuntimeException) {
                throw (RuntimeException)throwable;
            }
            AssertionError assertionError = new AssertionError((Object)"Unexpected exception");
            assertionError.initCause(throwable);
            throw assertionError;
        }
    }

    public /* varargs */ Object invokeWithoutCheckedException(T t2, Object ... arrobject) {
        try {
            Object object = this.invoke(t2, arrobject);
            return object;
        }
        catch (InvocationTargetException var3_4) {
            Throwable throwable = var3_4.getTargetException();
            if (throwable instanceof RuntimeException) {
                throw (RuntimeException)throwable;
            }
            AssertionError assertionError = new AssertionError((Object)"Unexpected exception");
            assertionError.initCause(throwable);
            throw assertionError;
        }
    }

    public boolean isSupported(T t2) {
        if (super.getMethod(t2.getClass()) != null) {
            return true;
        }
        return false;
    }
}

