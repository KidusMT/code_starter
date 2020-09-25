package com.pixel.app.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import androidx.core.content.FileProvider;

import java.io.File;

import static java.lang.String.format;

@SuppressWarnings({"unused", "RedundantSuppression"})
public class ShareUtils {

    public static void shareFile(String filePath, Context context, String projectName, String from,
                                 String to, String reportType, String shareSubject) {
        Intent intentShareFile = new Intent(Intent.ACTION_SEND);
        File fileWithinMyDir = new File(filePath);

        if (fileWithinMyDir.exists()) {
            intentShareFile.setType("application/xlsx");

            File file = new File(filePath);
            Uri bmpUri = FileProvider.getUriForFile(context, "com.pixel.app.file_provider", file);

            intentShareFile.putExtra(Intent.EXTRA_STREAM, bmpUri);

            // todo handle the start and end date later.

            String body = format("Dear Sir/Madam.\n\nAttached please find " +
                    reportType + /*"payroll"*/
                    " report of " +
                    projectName +  /*"bear garden project "*/
                    "for the duration %s to %s.\n\nThank you", from, to
            );

            intentShareFile.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
            intentShareFile.putExtra(Intent.EXTRA_TEXT, body);
            intentShareFile.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

            context.startActivity(Intent.createChooser(intentShareFile, "Share File"));
        }
    }
}
