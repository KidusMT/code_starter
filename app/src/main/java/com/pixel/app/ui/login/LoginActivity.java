package com.pixel.app.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.pixel.app.R;
import com.pixel.app.ui.base.BaseActivity;
import com.pixel.app.ui.main.MainActivity;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginMvpView {

    @Inject
    LoginMvpPresenter<LoginMvpView> mPresenter;

    @BindView(R.id.et_username)
    EditText etUserName;

    @BindView(R.id.et_password)
    EditText etPassword;

    @BindView(R.id.login_site)
    Spinner spinnerSite;
    int check = 0;
    int selectedSite = -1;// default - not selected
    ArrayList<String> siteOptions = new ArrayList<>();

    public static Intent getStartIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(LoginActivity.this);

        setUp();
    }

    @OnClick(R.id.btn_signup)
    void onSignUpClicked() {
        openSignUpScreen();
    }

    @Override
    protected void setUp() {
        hideKeyboard();
    }

    @OnClick(R.id.btn_login)
    void onServerLoginClick(View v) {
        mPresenter.onServerLoginClick(etUserName.getText().toString(), etPassword.getText().toString());
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void openMainScreen() {
        startActivity(MainActivity.getStartIntent(this));
        finish();
    }

    @Override
    public void openForgotPasswordScreen() {
//        startActivity(ForgetPasswordActivity.getStartIntent(this));
        finish();
    }

    @Override
    public void openSignUpScreen() {
//        startActivity(SignUpActivity.getStartIntent(this));
        finish();
    }

    @OnClick(R.id.btn_forgot_your_password)
    void onForgotPasswordClick() {
        mPresenter.onForgotPasswordClick();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }


}
