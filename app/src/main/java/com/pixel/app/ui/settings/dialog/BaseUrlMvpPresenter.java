package com.pixel.app.ui.settings.dialog;

import com.pixel.app.ui.base.MvpPresenter;

public interface BaseUrlMvpPresenter<V extends BaseUrlMvpView> extends MvpPresenter<V> {

    void onCancelClick();

    void setBaseUrl(String baseUrl);

    void getCurrentBaseUrl();

}
