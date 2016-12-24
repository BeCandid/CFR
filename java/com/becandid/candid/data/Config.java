/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package com.becandid.candid.data;

import com.becandid.candid.data.DataUtil;
import java.util.Map;

public class Config {
    public Map<String, Object> experimentConfig;

    public boolean getBoolean(String string2) {
        return this.getBoolean(string2, false);
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean getBoolean(String string2, boolean bl2) {
        if (this.experimentConfig == null || !this.experimentConfig.containsKey((Object)string2)) {
            return bl2;
        }
        return DataUtil.toBoolean(this.experimentConfig.get((Object)string2), bl2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public float getFloat(String string2, float f2) {
        if (this.experimentConfig == null || !this.experimentConfig.containsKey((Object)string2)) {
            return f2;
        }
        return DataUtil.toFloat(this.experimentConfig.get((Object)string2), f2);
    }

    public int getInt(String string2) {
        return this.getInt(string2, 0);
    }

    /*
     * Enabled aggressive block sorting
     */
    public int getInt(String string2, int n2) {
        if (this.experimentConfig == null || !this.experimentConfig.containsKey((Object)string2)) {
            return n2;
        }
        return DataUtil.toInt(this.experimentConfig.get((Object)string2), n2);
    }

    public String getString(String string2) {
        return this.getString(string2, "");
    }

    /*
     * Enabled aggressive block sorting
     */
    public String getString(String string2, String string3) {
        Object object;
        if (this.experimentConfig == null || !this.experimentConfig.containsKey((Object)string2) || !((object = this.experimentConfig.get((Object)string2)) instanceof String)) {
            return string3;
        }
        return (String)object;
    }

    public boolean has(String string2) {
        if (this.experimentConfig != null && this.experimentConfig.containsKey((Object)string2)) {
            return true;
        }
        return false;
    }

    public void setExperimentConfig(Map<String, Object> map) {
        this.experimentConfig = map;
    }
}

