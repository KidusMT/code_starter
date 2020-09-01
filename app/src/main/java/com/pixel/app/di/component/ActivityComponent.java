package com.pixel.app.di.component;

import com.pixel.app.di.PerActivity;
import com.pixel.app.di.module.ActivityModule;
import com.pixel.app.ui.login.LoginActivity;
import com.pixel.app.ui.main.MainActivity;
import com.pixel.app.ui.main.MenuAdapter;
import com.pixel.app.ui.settings.SettingsActivity;
import com.pixel.app.ui.settings.dialog.BaseUrlDialog;
import com.pixel.app.ui.splash.SplashActivity;
import com.pixel.app.utils.network.NoInternetFragment;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

    void inject(SplashActivity activity);

    void inject(LoginActivity activity);

    void inject(MenuAdapter adapter);

    void inject(SettingsActivity activity);

    void inject(BaseUrlDialog dialog);

    void inject(NoInternetFragment fragment);
}
