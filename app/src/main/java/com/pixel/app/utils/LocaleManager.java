package com.pixel.app.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;

import java.util.Locale;

import static com.pixel.app.data.prefs.AppPreferencesHelper.PREF_KEY_CURRENT_LANGUAGE;

public class LocaleManager {

    public static void setLocale(Context c) {
        setNewLocale(c, getLanguage(c));
    }

    public static void setNewLocale(Context c, String language) {
        persistLanguage(c, language);
        updateResources(c, language);
    }

    public static String getLanguage(Context c) {
        SharedPreferences sharedPreferences = c.getSharedPreferences(AppConstants.PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(PREF_KEY_CURRENT_LANGUAGE, "en");// defaults to English
    }

    private static void persistLanguage(Context c, String language) {
        SharedPreferences sharedPreferences = c.getSharedPreferences(AppConstants.PREF_NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().putString(PREF_KEY_CURRENT_LANGUAGE, language).apply();// a
    }

    private static void updateResources(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Resources res = context.getResources();
        Configuration config = new Configuration();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            config.setLocale(locale);
        } else {
            config.locale = locale;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            context.getApplicationContext().createConfigurationContext(res.getConfiguration());
        } else {
            context.getResources().updateConfiguration(config, res.getDisplayMetrics());
        }

        res.updateConfiguration(config, res.getDisplayMetrics());
    }
}
