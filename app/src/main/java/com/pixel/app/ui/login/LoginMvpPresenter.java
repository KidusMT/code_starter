package com.pixel.app.ui.login;

import com.pixel.app.di.PerActivity;
import com.pixel.app.ui.base.MvpPresenter;

@PerActivity
public interface LoginMvpPresenter<V extends LoginMvpView> extends MvpPresenter<V> {

    void onServerLoginClick(String email, String password);

    void onForgotPasswordClick();

}
