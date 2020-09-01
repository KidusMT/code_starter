package com.pixel.app.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.provider.Settings;
import android.telephony.SmsManager;
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.pixel.app.R;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by KidusMT.
 */

public final class CommonUtils {

    private static final String TAG = "CommonUtils";

    private CommonUtils() {
        // This utility class is not publicly instantiable
    }

    public static ProgressDialog showLoadingDialog(Context context, boolean cancelable) {
        if (context != null) {
            ProgressDialog progressDialog = new ProgressDialog(context);
            progressDialog.show();
            if (progressDialog.getWindow() != null) {
                progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            }
            progressDialog.setContentView(R.layout.progress_dialog);
            progressDialog.setIndeterminate(true);
            if (!cancelable) {
                progressDialog.setCancelable(false);
                progressDialog.setCanceledOnTouchOutside(false);
            }

            return progressDialog;
        } else {
            return null;
        }
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {

        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }

    /**
     * Create a Notification that is shown as a heads-up notification if possible.
     * <p>
     *
     * @param message Message shown on the notification
     * @param context Context needed to create Toast
     */
//    public static void makeStatusNotification(String message, Context context) {
//
//        // Make a channel if necessary
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            // Create the NotificationChannel, but only on API 26+ because
//            // the NotificationChannel class is new and not in the support library
//            CharSequence name = AppConstants.VERBOSE_NOTIFICATION_CHANNEL_NAME;
//            String description = AppConstants.VERBOSE_NOTIFICATION_CHANNEL_DESCRIPTION;
//            int importance = NotificationManager.IMPORTANCE_HIGH;
//            NotificationChannel channel =
//                    new NotificationChannel(CHANNEL_ID, name, importance);
//            channel.setDescription(description);
//
//            // Add the channel
//            NotificationManager notificationManager =
//                    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
//
//            if (notificationManager != null) {
//                notificationManager.createNotificationChannel(channel);
//            }
//        }
//
//        // Create the notification
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
//                .setSmallIcon(R.drawable.res_logo)
//                .setContentTitle(AppConstants.NOTIFICATION_TITLE)
//                .setContentText(message)
//                .setPriority(NotificationCompat.PRIORITY_HIGH)
//                .setVibrate(new long[0]);
//
//        // Show the notification
//        NotificationManagerCompat.from(context).notify(AppConstants.NOTIFICATION_ID, builder.build());
//    }


    /**
     * Method for sleeping for a fixed about of time to emulate slower work
     */
//    static void sleep() {
//        try {
//            Thread.sleep(DELAY_TIME_MILLIS, 0);
//        } catch (InterruptedException e) {
//            Log.d(TAG, e.getMessage());
//        }
//    }
    @SuppressLint("all")
    public static String getDeviceId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }


    public static String getFileName(Uri uri, Context context) {
        String result = null;

        if (uri.getScheme() != null)
            if (uri.getScheme().equals("content")) {
                Cursor cursor = context.getContentResolver().query(uri, null, null, null, null);

                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                    cursor.close();
                }

            }

        if (result == null) {
            result = uri.getPath();
            if (result != null) {
                int cut = result.lastIndexOf('/');
                if (cut != -1) {
                    result = result.substring(cut + 1);
                }
            }
        }
        return result;
    }

//    public static String getErrorMessage(int code, Context context) {
//        if (code >= 400 && code < 404) {
//            return context.getResources().getString(R.string.error_invalid_credential);
//        } else if (code == 404) {
//            return context.getResources().getString(R.string.error_file_does_not_exist);
//        } else if (code == 500) {
//            return context.getResources().getString(R.string.error_server_error);
//        } else if (code == 503) {
//            return context.getResources().getString(R.string.error_server_unreachable);
//        } else {
//
//            return context.getResources().getString(R.string.error_something_wrong_happend);
//        }
//    }

    public static boolean isEmailValid(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }


    public static boolean hasPermission(String perm, Context context) {
        return (ContextCompat.checkSelfPermission(context, perm) ==
                PackageManager.PERMISSION_GRANTED);
    }

    public static void askPermission(Context context, int ACCESS_CODE, String[] permissions) {
        ActivityCompat.requestPermissions((Activity) context, permissions, ACCESS_CODE);
    }


    public static Intent getCallIntent(String phoneNumber) {
        return new Intent(Intent.ACTION_CALL, Uri.fromParts("tel", phoneNumber, null));
    }

    public static Intent getSMSIntent(String phoneNumber, String messageBody) {
        Intent smsIntent = new Intent(Intent.ACTION_SEND);
        smsIntent.setType("text/plain");
        smsIntent.putExtra(Intent.EXTRA_TEXT, messageBody);
        smsIntent.putExtra("address", phoneNumber);
        return smsIntent;
    }

    public static void sendSMS(Context context, int requestCode, String number, String message) {
        SmsManager sms = SmsManager.getDefault();
        // if message length is too long messages are divided


        String SENT = "SMS_SENT";
        String DELIVERED = "SMS_DELIVERED";

        Intent sms_sent = new Intent(SENT);
        Bundle bundle = new Bundle();
        bundle.putString("PHONE_NUMBER", number);
        bundle.putString("ACTION", "PICKUP_ARRIVAL_NOTICE_SMS_SENT");
        sms_sent.putExtras(bundle);

        Intent sms_sent_delivered = new Intent(DELIVERED);

        Bundle bundle_sms_delivered = new Bundle();
        bundle_sms_delivered.putString("PHONE_NUMBER", number);
        bundle_sms_delivered.putString("ACTION", "PICKUP_ARRIVAL_NOTICE_SMS_DELIVERED");
        sms_sent_delivered.putExtras(bundle_sms_delivered);


        PendingIntent sentPI = PendingIntent.getBroadcast(context, 0,
                sms_sent, 0);

        PendingIntent deliveredPI = PendingIntent.getBroadcast(context, 258,
                sms_sent_delivered, 0);


        List<String> messages = sms.divideMessage(message);
        for (String msg : messages) {
            sms.sendTextMessage(number, null, msg, sentPI, deliveredPI);

        }


    }

    public static byte[] fileToBytes(File file) {
        int size = (int) file.length();
        byte[] bytes = new byte[size];
        try {
            BufferedInputStream buf = new BufferedInputStream(new FileInputStream(file));
            buf.read(bytes, 0, bytes.length);
            buf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    public static void saveImageInInternalStorage(Context context, Bitmap b, String imageName) {
        FileOutputStream foStream;
        try {
            foStream = context.openFileOutput(imageName, Context.MODE_PRIVATE);
            b.compress(Bitmap.CompressFormat.PNG, 100, foStream);
            foStream.close();
        } catch (Exception e) {
            Log.d("saveImage", "Exception 2, Something went wrong!");
            e.printStackTrace();
        }
    }

    public Bitmap loadImageFromInternalStorage(Context context, String imageName) {
        Bitmap bitmap = null;
        FileInputStream fiStream;
        try {
            fiStream = context.openFileInput(imageName);
            bitmap = BitmapFactory.decodeStream(fiStream);
            fiStream.close();
        } catch (Exception e) {
            Log.d("saveImage", "Exception 3, Something went wrong!");
            e.printStackTrace();
        }
        return bitmap;
    }
}
