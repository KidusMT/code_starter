package com.pixel.app.ui.login;

import com.pixel.app.R;
import com.pixel.app.data.DataManager;
import com.pixel.app.data.network.model.login.LoginRequest;
import com.pixel.app.ui.base.BasePresenter;
import com.pixel.app.utils.CommonUtils;
import com.pixel.app.utils.ErrorUtils;
import com.pixel.app.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class LoginPresenter<V extends LoginMvpView> extends BasePresenter<V>
        implements LoginMvpPresenter<V> {

    private static final String TAG = LoginPresenter.class.getSimpleName();

    @Inject
    public LoginPresenter(DataManager dataManager,
                          SchedulerProvider schedulerProvider,
                          CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
        decideScreen();
    }

    private void decideScreen() {
        if (getDataManager().getCurrentUserLoggedInMode() == DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER.getType()) {
            getMvpView().openMainScreen();
        }
    }

    @Override
    public void onServerLoginClick(String email, String password) {
        //validate email and password
        if (email == null || email.isEmpty()) {
            getMvpView().onError(R.string.empty_email);
            return;
        }
        if (!CommonUtils.isEmailValid(email)) {
            getMvpView().onError(R.string.invalid_email);
            return;
        }
        if (password == null || password.isEmpty()) {
            getMvpView().onError(R.string.empty_password);
            return;
        }
        // todo shouldn't let user with password less than 8 char to pass...
        //
        getMvpView().showLoading();

        getCompositeDisposable().add(getDataManager()
                .login(new LoginRequest(email, password))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {

                    if (!isViewAttached()) {
                        return;
                    }

                    getMvpView().hideLoading();
                    if (response.getSuccess()) {
//                        String decoded = AppUtils.decodeToken(response.getJwt());
//                        JSONObject decObj = new JSONObject(decoded);
//                        Long applicantId = decObj.getLong("id");
//                        String applicantName = decObj.getString("first_name") + " " +
//                                decObj.getString("last_name");
//                        String applicantFullName =
//                                decObj.getString("first_name") + " " +
//                                        (decObj.has("middle_name") ? decObj.getString("middle_name") + " " : "") +
//                                        decObj.getString("last_name");
//
//                        getDataManager().setApplicantFullName(applicantFullName);
//
//                        String applicantEmail = decObj.getString("email");
//
//                        getDataManager().updateUserInfo(
//                                response.getJwt(),
//                                applicantId,
//                                DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER,
//                                applicantName,
//                                applicantEmail
//                        );

                        getMvpView().openMainScreen();
//                    } else if (response.getErrors().get(0).equalsIgnoreCase("Invalid username or password !")){
                    } else if (response.getErrors() != null && response.getErrors().size() > 0) {
                        // if single line then should display only the first but if multiple
                        // then it should display multiple line snackbar with custom snack bar
                        getMvpView().onError(response.getErrors().get(0));
                    }
                }, throwable -> {
                    if (!isViewAttached()) {
                        return;
                    }
                    // handle the login error here
                    getMvpView().hideLoading();
                    ErrorUtils.handleApiError(throwable, getMvpView());
                }));
    }

    @Override
    public void onForgotPasswordClick() {
        getMvpView().openForgotPasswordScreen();
    }

}
