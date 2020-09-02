package com.pixel.app.ui.main;

import com.pixel.app.data.DataManager;
import com.pixel.app.ui.base.BasePresenter;
import com.pixel.app.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {

    private static final String TAG = MainPresenter.class.getSimpleName();

    @Inject
    public MainPresenter(DataManager dataManager,
                         SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }

    @Override
    public void onViewInitialized() {

    }

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

    @Override
    public void onLogoutClicked() {
        getDataManager().setUserAsLoggedOut();
        getMvpView().openLoginScreen();
    }
}
