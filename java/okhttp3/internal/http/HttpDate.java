/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ThreadLocal
 *  java.text.DateFormat
 *  java.text.ParsePosition
 *  java.text.SimpleDateFormat
 *  java.util.Date
 *  java.util.Locale
 *  java.util.TimeZone
 */
package okhttp3.internal.http;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import okhttp3.internal.Util;

public final class HttpDate {
    private static final DateFormat[] BROWSER_COMPATIBLE_DATE_FORMATS;
    private static final String[] BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS;
    public static final long MAX_DATE = 253402300799999L;
    private static final ThreadLocal<DateFormat> STANDARD_DATE_FORMAT;

    static {
        STANDARD_DATE_FORMAT = new ThreadLocal<DateFormat>(){

            protected DateFormat initialValue() {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
                simpleDateFormat.setLenient(false);
                simpleDateFormat.setTimeZone(Util.UTC);
                return simpleDateFormat;
            }
        };
        BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS = new String[]{"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        BROWSER_COMPATIBLE_DATE_FORMATS = new DateFormat[BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS.length];
    }

    private HttpDate() {
    }

    public static String format(Date date) {
        return ((DateFormat)STANDARD_DATE_FORMAT.get()).format(date);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Date parse(String string2) {
        String[] arrstring;
        if (string2.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date date = ((DateFormat)STANDARD_DATE_FORMAT.get()).parse(string2, parsePosition);
        if (parsePosition.getIndex() == string2.length()) return date;
        String[] arrstring2 = arrstring = BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS;
        synchronized (arrstring2) {
            int n2 = 0;
            int n3 = BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS.length;
            while (n2 < n3) {
                DateFormat dateFormat = BROWSER_COMPATIBLE_DATE_FORMATS[n2];
                if (dateFormat == null) {
                    dateFormat = new SimpleDateFormat(BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS[n2], Locale.US);
                    dateFormat.setTimeZone(Util.UTC);
                    HttpDate.BROWSER_COMPATIBLE_DATE_FORMATS[n2] = dateFormat;
                }
                parsePosition.setIndex(0);
                Date date2 = dateFormat.parse(string2, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return date2;
                }
                ++n2;
            }
            return null;
        }
    }

}

