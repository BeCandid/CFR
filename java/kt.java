/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.Priority
 *  java.io.ByteArrayInputStream
 *  java.io.InputStream
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
import com.bumptech.glide.Priority;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class kt
implements ku<InputStream> {
    private final byte[] a;
    private final String b;

    public kt(byte[] arrby, String string2) {
        this.a = arrby;
        this.b = string2;
    }

    public InputStream a(Priority priority) {
        return new ByteArrayInputStream(this.a);
    }

    @Override
    public void a() {
    }

    @Override
    public /* synthetic */ Object b(Priority priority) throws Exception {
        return this.a(priority);
    }

    @Override
    public String b() {
        return this.b;
    }

    @Override
    public void c() {
    }
}

