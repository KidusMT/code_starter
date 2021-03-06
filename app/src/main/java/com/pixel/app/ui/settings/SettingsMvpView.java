package com.pixel.app.ui.settings;

import com.pixel.app.ui.base.MvpView;

@SuppressWarnings({"unused", "RedundantSuppression", "EmptyMethod"})
public interface SettingsMvpView extends MvpView {

    void setCurrentLanguage(String language);

    void setCurrentBaseUrl(String baseUrl);

    void setAuthPrivilege(boolean isAuthorized);

    void openProjectSetup();
}
