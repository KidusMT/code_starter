package com.pixel.app.ui.settings.dialog;

import com.pixel.app.data.DataManager;
import com.pixel.app.ui.base.BasePresenter;
import com.pixel.app.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class BaseUrlPresenter<V extends BaseUrlMvpView> extends BasePresenter<V>
        implements BaseUrlMvpPresenter<V> {

    public static final String TAG = BaseUrlPresenter.class.getSimpleName();

    @Inject
    public BaseUrlPresenter(DataManager dataManager,
                            SchedulerProvider schedulerProvider,
                            CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onCancelClick() {
        getMvpView().dismissDialog();
    }

    @Override
    public void setBaseUrl(String baseUrl) {
        getDataManager().setCurrentBaseUrl(baseUrl);
    }

    @Override
    public void getCurrentBaseUrl() {
        getMvpView().setCurrentBaseUrl(getDataManager().getCurrentBaseUrl());
    }
}
