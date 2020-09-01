package com.pixel.app.utils;

import java.text.DecimalFormat;

public final class AppUtils {

    // file picker constants
    public static final String EXTRA_FILENAME = "com.pixel.bits.fileprovider";
    public static final int CAPTURE_PICTURE_REQUEST_CODE = 12;
    public static final int PICK_PHOTO_REQUEST_CODE = 13;
    private static final DecimalFormat format = new DecimalFormat("#.##");

    private static final long MiB = 1024 * 1024;
    private static final long KiB = 1024;

    private AppUtils() {
    }

}
