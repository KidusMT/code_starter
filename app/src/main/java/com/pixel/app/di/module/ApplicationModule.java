package com.pixel.app.di.module;

import android.app.Application;
import android.content.Context;

import com.pixel.app.data.AppDataManager;
import com.pixel.app.data.DataManager;
import com.pixel.app.data.db.AppDbHelper;
import com.pixel.app.data.db.DbHelper;
import com.pixel.app.data.network.ApiHeader;
import com.pixel.app.data.network.ApiHelper;
import com.pixel.app.data.network.AppApiHelper;
import com.pixel.app.data.prefs.AppPreferencesHelper;
import com.pixel.app.data.prefs.PreferencesHelper;
import com.pixel.app.di.ApiInfo;
import com.pixel.app.di.ApplicationContext;
import com.pixel.app.di.DatabaseInfo;
import com.pixel.app.di.PreferenceInfo;
import com.pixel.app.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @SuppressWarnings("SameReturnValue")
    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @SuppressWarnings("SameReturnValue")
    @Provides
    @ApiInfo
    String provideApiKey() {
        return null;//BuildConfig.API_KEY;
    }

    @SuppressWarnings("SameReturnValue")
    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }


    @Provides
    @Singleton
    ApiHeader provideApiHeader(PreferencesHelper preferencesHelper) {
        return new ApiHeader(preferencesHelper.getAccessToken());
    }
}
