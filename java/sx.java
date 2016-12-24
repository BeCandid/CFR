/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Process
 *  io.fabric.sdk.android.services.common.CommonUtils
 *  io.fabric.sdk.android.services.common.IdManager
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.util.Date
 *  java.util.Locale
 *  java.util.concurrent.atomic.AtomicLong
 */
import android.os.Process;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.IdManager;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

class sx {
    private static final AtomicLong a = new AtomicLong(0);
    private static String b;

    public sx(IdManager idManager) {
        byte[] arrby = new byte[10];
        super.a(arrby);
        super.b(arrby);
        super.c(arrby);
        String string2 = CommonUtils.a((String)idManager.b());
        String string3 = CommonUtils.a((byte[])arrby);
        Locale locale = Locale.US;
        Object[] arrobject = new Object[]{string3.substring(0, 12), string3.substring(12, 16), string3.subSequence(16, 20), string2.substring(0, 12)};
        b = String.format((Locale)locale, (String)"%s-%s-%s-%s", (Object[])arrobject).toUpperCase(Locale.US);
    }

    private void a(byte[] arrby) {
        long l2 = new Date().getTime();
        long l3 = l2 / 1000;
        long l4 = l2 % 1000;
        byte[] arrby2 = sx.a(l3);
        arrby[0] = arrby2[0];
        arrby[1] = arrby2[1];
        arrby[2] = arrby2[2];
        arrby[3] = arrby2[3];
        byte[] arrby3 = sx.b(l4);
        arrby[4] = arrby3[0];
        arrby[5] = arrby3[1];
    }

    private static byte[] a(long l2) {
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)4);
        byteBuffer.putInt((int)l2);
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        byteBuffer.position(0);
        return byteBuffer.array();
    }

    private void b(byte[] arrby) {
        byte[] arrby2 = sx.b(a.incrementAndGet());
        arrby[6] = arrby2[0];
        arrby[7] = arrby2[1];
    }

    private static byte[] b(long l2) {
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)2);
        byteBuffer.putShort((short)l2);
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        byteBuffer.position(0);
        return byteBuffer.array();
    }

    private void c(byte[] arrby) {
        byte[] arrby2 = sx.b(Integer.valueOf((int)Process.myPid()).shortValue());
        arrby[8] = arrby2[0];
        arrby[9] = arrby2[1];
    }

    public String toString() {
        return b;
    }
}

