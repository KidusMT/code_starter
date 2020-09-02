package com.pixel.app.ui.main;

import com.pixel.app.di.PerActivity;
import com.pixel.app.ui.base.MvpPresenter;

@PerActivity
public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {

    void onViewInitialized();

    void loadApplications();

    void onLogoutClicked();

}
