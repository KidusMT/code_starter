package com.pixel.app.ui.main;

import com.pixel.app.data.DataManager;
import com.pixel.app.ui.base.BasePresenter;
import com.pixel.app.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {

    @SuppressWarnings({"unused", "RedundantSuppression"})
    private static final String TAG = MainPresenter.class.getSimpleName();

    @Inject
    public MainPresenter(DataManager dataManager,
                         SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @SuppressWarnings({"unused", "RedundantSuppression"})
    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }

    @SuppressWarnings({"unused", "RedundantSuppression"})
    @Override
    public void onViewInitialized() {

    }

    @SuppressWarnings({"unused", "RedundantSuppression"})
    @Override
    public void loadApplications() {
//        getMvpView().showLoading();
//        getCompositeDisposable().add(getDataManager().filterApplication(request)
//                .subscribeOn(getSchedulerProvider().io())
//                .observeOn(getSchedulerProvider().ui())
//                .subscribe(applicationFilterResponse -> {
//
//                    if (!isViewAttached()) {
//                        return;
//                    }
//
//                    getMvpView().hideLoading();
//                    getMvpView().hideFullScreenConnectionLostPage();
//
//                    if (applicationFilterResponse.isSuccess()) {
//                        getMvpView().showApplicationForms(applicationFilterResponse);
//                    }
//                }, throwable -> {
//                    if (!isViewAttached()) {
//                        return;
//                    }
//
//                    // handle the login error here
//                    getMvpView().hideLoading();
//                    if (throwable instanceof ConnectException) {
//                        getMvpView().showFullScreenConnectionLostPage();
//                        return;
//                    }
//                    ErrorUtils.handleApiError(throwable, getMvpView());
//                }));
    }

    @SuppressWarnings({"unused", "RedundantSuppression"})
    @Override
    public void onSettingsClicked() {
        getMvpView().openSettings();
    }

    @SuppressWarnings({"unused", "RedundantSuppression"})
    @Override
    public void onLogoutClicked() {
        getDataManager().setUserAsLoggedOut();
        getMvpView().openLoginScreen();
    }
}
