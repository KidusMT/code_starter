package com.pixel.app.ui.settings;

import com.pixel.app.di.PerActivity;
import com.pixel.app.ui.base.MvpPresenter;

@PerActivity
public interface SettingsMvpPresenter<V extends SettingsMvpView> extends MvpPresenter<V> {

    void resolveCurrentLanguage();

    void getCurrentBaseUrl();

    void getAuthPrivilege();

    @SuppressWarnings({"unused", "RedundantSuppression"})
    void setAuthPrivilege(boolean isAuthorized);
}
