/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.FilenameFilter
 *  java.lang.Object
 *  java.util.Arrays
 *  java.util.Comparator
 */
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;

final class tx {
    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void a(File file, FilenameFilter filenameFilter, int n2, Comparator<File> comparator) {
        Object[] arrobject = file.listFiles(filenameFilter);
        if (arrobject == null || arrobject.length <= n2) return;
        Arrays.sort((Object[])arrobject, comparator);
        int n3 = arrobject.length;
        int n4 = arrobject.length;
        int n5 = 0;
        while (n5 < n4) {
            Object object = arrobject[n5];
            if (n3 <= n2) {
                return;
            }
            object.delete();
            --n3;
            ++n5;
        }
    }
}

