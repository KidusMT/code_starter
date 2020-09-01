package com.pixel.app.ui.settings.dialog;

import com.pixel.app.ui.base.DialogMvpView;

public interface BaseUrlMvpView extends DialogMvpView {

    void dismissDialog();

    void setCurrentBaseUrl(String baseUrl);
}
