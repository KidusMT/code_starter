package com.pixel.app.di.component;

import android.app.Application;
import android.content.Context;

import com.pixel.app.MvpApp;
import com.pixel.app.data.DataManager;
import com.pixel.app.di.ApplicationContext;
import com.pixel.app.di.module.ApplicationModule;
import com.pixel.app.service.SyncService;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MvpApp app);

    void inject(SyncService service);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}