package com.pixel.app.di.module;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.pixel.app.di.ActivityContext;
import com.pixel.app.di.PerActivity;
import com.pixel.app.ui.login.LoginMvpPresenter;
import com.pixel.app.ui.login.LoginMvpView;
import com.pixel.app.ui.login.LoginPresenter;
import com.pixel.app.ui.main.MainMvpPresenter;
import com.pixel.app.ui.main.MainMvpView;
import com.pixel.app.ui.main.MainPresenter;
import com.pixel.app.ui.main.MenuAdapter;
import com.pixel.app.utils.rx.AppSchedulerProvider;
import com.pixel.app.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    LoginMvpPresenter<LoginMvpView> provideLoginPresenter(
            LoginPresenter<LoginMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MenuAdapter provideMenuAdapter() {
        return new MenuAdapter(provideContext(), new ArrayList<>());
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(
            MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }
}
