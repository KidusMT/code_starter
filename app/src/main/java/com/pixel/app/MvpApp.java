package com.pixel.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.Log;

import androidx.multidex.MultiDex;

import com.pixel.app.data.DataManager;
import com.pixel.app.di.component.ApplicationComponent;
import com.pixel.app.di.component.DaggerApplicationComponent;
import com.pixel.app.di.module.ApplicationModule;
import com.pixel.app.utils.AppConstants;
import com.pixel.app.utils.AppLogger;
import com.pixel.app.utils.LocaleManager;

import net.danlew.android.joda.JodaTimeAndroid;

import java.util.HashMap;
import java.util.Locale;

import javax.inject.Inject;

import static com.pixel.app.data.prefs.AppPreferencesHelper.PREF_KEY_CURRENT_LANGUAGE;

public class MvpApp extends Application {

    public static Context mContext;
    public static HashMap<String, String> qualification;
    @Inject
    DataManager mDataManager;
    private ApplicationComponent mApplicationComponent;

    public static Context getContext() {
        return mContext;
    }

    public static void setContext(Context context) {
        mContext = context;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);

        AppLogger.init();

        JodaTimeAndroid.init(this);

        MultiDex.install(mContext);

        setupLanguagePreferences();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LocaleManager.setLocale(this);
    }

    private void setupLanguagePreferences() {

        String default_language = getSharedPreferences(AppConstants.PREF_NAME, Context.MODE_PRIVATE).getString(PREF_KEY_CURRENT_LANGUAGE, "en");

        Log.e("Language:P", default_language + "");

        Locale locale = new Locale(default_language);
        Locale.setDefault(locale);
        Configuration config = new Configuration(getResources().getConfiguration());
        if (Build.VERSION.SDK_INT >= 17) {
            config.setLocale(locale);
        } else {
            config.locale = locale;
        }
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }


    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
