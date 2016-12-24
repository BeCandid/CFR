/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 */
package okhttp3;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Response;

public interface Callback {
    public void onFailure(Call var1, IOException var2);

    public void onResponse(Call var1, Response var2) throws IOException;
}

