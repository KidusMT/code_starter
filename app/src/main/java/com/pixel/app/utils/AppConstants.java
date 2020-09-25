package com.pixel.app.utils;

@SuppressWarnings({"unused", "RedundantSuppression"})
public final class AppConstants {

    public static final String STATUS_CODE_SUCCESS = "success";
    public static final String STATUS_CODE_FAILED = "failed";

    public static final int API_STATUS_CODE_LOCAL_ERROR = 0;

    public static final String DB_NAME = "bits.app";
    public static final String PREF_NAME = "bits_pref";

    public static final long NULL_INDEX = -1L;

    public static final String TIMESTAMP_FORMAT = "yyyyMMdd_HHmmss";

    public static final int AN_HOUR = 3600000;

    public static final int PICK_FILE_REQUEST_CODE = 105;

    public static final int APPLICATION_FORM_DEMOGRAPHIC = 0;
    public static final int APPLICATION_FORM_CONTACT = 1;
    public static final int APPLICATION_FORM_SELECT_PROGRAM = 2;
    public static final int APPLICATION_FORM_DOCUMENT = 3;
    public static final int APPLICATION_FORM_PAYMENT = 4;
    public static final int APPLICATION_FORM_DONE = 5;

    private AppConstants() {
        // This utility class is not publicly instantiable
    }
}
