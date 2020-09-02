package com.pixel.app.ui.login;

import com.pixel.app.data.DataManager;
import com.pixel.app.utils.rx.TestSchedulerProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.TestScheduler;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {

    @Mock
    LoginMvpView mMockLoginMvpView;
    @Mock
    DataManager mMockDataManager;

    private LoginPresenter<LoginMvpView> mLoginPresenter;
    private TestScheduler mTestScheduler;

    @BeforeClass
    public static void onlyOnce() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testServerLoginSuccess() {

        CompositeDisposable compositeDisposable = new CompositeDisposable();
        mTestScheduler = new TestScheduler();
        TestSchedulerProvider testSchedulerProvider = new TestSchedulerProvider(mTestScheduler);
        mLoginPresenter = new LoginPresenter<>(
                mMockDataManager,
                testSchedulerProvider,
                compositeDisposable);
        mLoginPresenter.onAttach(mMockLoginMvpView);

        String email = "dummy@gmail.com";
        String password = "password";

//        LoginResponse loginResponse = new LoginResponse();

//        doReturn(Observable.just(loginResponse))
//                .when(mMockDataManager)
//                .login(new LoginRequest(email, password));
//
        mLoginPresenter.onServerLoginClick(email, password);

        mTestScheduler.triggerActions();

        verify(mMockLoginMvpView).showLoading();
        verify(mMockLoginMvpView).hideLoading();
        verify(mMockLoginMvpView).openMainScreen();
    }


    @After
    public void tearDown() throws Exception {
        mLoginPresenter.onDetach();
    }

}