package com.pixel.app.ui.settings;

import com.pixel.app.data.DataManager;
import com.pixel.app.ui.base.BasePresenter;
import com.pixel.app.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class SettingsPresenter<V extends SettingsMvpView> extends BasePresenter<V>
        implements SettingsMvpPresenter<V> {

    private static final String TAG = SettingsPresenter.class.getSimpleName();

    @Inject
    public SettingsPresenter(DataManager dataManager,
                             SchedulerProvider schedulerProvider,
                             CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }


    @Override
    public void resolveCurrentLanguage() {
        getMvpView().setCurrentLanguage(getDataManager().getCurrentLanguage());
    }

    @Override
    public void getCurrentBaseUrl() {
        getMvpView().setCurrentBaseUrl(getDataManager().getCurrentBaseUrl());
    }

    @Override
    public void getAuthPrivilege() {
        getMvpView().setAuthPrivilege(getDataManager().getAuthPrivilege());
    }

    @Override
    public void setAuthPrivilege(boolean isAuthorized) {
        getDataManager().setAuthPrivilege(isAuthorized);
    }

}
