package com.pixel.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import androidx.multidex.MultiDex;

import com.pixel.app.di.component.ApplicationComponent;
import com.pixel.app.di.component.DaggerApplicationComponent;
import com.pixel.app.di.module.ApplicationModule;
import com.pixel.app.utils.AppLogger;
import com.pixel.app.utils.LocaleManager;

import net.danlew.android.joda.JodaTimeAndroid;


public class MvpApp extends Application {

    public static Context mContext;
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

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LocaleManager.setLocale(this);
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }


    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
