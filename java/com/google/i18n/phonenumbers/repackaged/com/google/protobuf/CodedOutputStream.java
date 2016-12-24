/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 */
package com.google.i18n.phonenumbers.repackaged.com.google.protobuf;

import java.io.IOException;

public final class CodedOutputStream {

    public static class OutOfSpaceException
    extends IOException {
        OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

}

