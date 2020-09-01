package com.pixel.app.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CalendarUtils {

    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.US);
        return simpleDateFormat.format(date);
    }
}
