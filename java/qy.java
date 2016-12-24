/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  java.lang.Exception
 *  java.lang.Object
 */
import android.graphics.drawable.Drawable;

public interface qy<R>
extends pp {
    public qd getRequest();

    public void getSize(qw var1);

    public void onLoadCleared(Drawable var1);

    public void onLoadFailed(Exception var1, Drawable var2);

    public void onLoadStarted(Drawable var1);

    public void onResourceReady(R var1, qk<? super R> var2);

    public void setRequest(qd var1);
}

