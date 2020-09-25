package com.pixel.app.ui.login;

import com.pixel.app.ui.base.MvpView;

public interface LoginMvpView extends MvpView {

    void openMainScreen();

    void openForgotPasswordScreen();

    @SuppressWarnings({"unused", "RedundantSuppression"})
    void openSignUpScreen();
}
