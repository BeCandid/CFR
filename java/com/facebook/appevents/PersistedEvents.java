/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 */
package com.facebook.appevents;

import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersistedEvents
extends HashMap<AccessTokenAppIdPair, List<AppEvent>> {
    public PersistedEvents() {
    }

    public PersistedEvents(HashMap<AccessTokenAppIdPair, List<AppEvent>> hashMap) {
        super(hashMap);
    }
}

