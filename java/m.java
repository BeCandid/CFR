/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Outline
 *  android.graphics.Rect
 */
import android.graphics.Outline;
import android.graphics.Rect;

class m
extends l {
    m() {
    }

    public void getOutline(Outline outline) {
        this.copyBounds(this.b);
        outline.setOval(this.b);
    }
}

