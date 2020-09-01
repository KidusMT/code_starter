package com.pixel.app.ui.splash;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.pixel.app.R;
import com.pixel.app.ui.base.BaseActivity;
import com.pixel.app.ui.login.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends BaseActivity {

    @BindView(R.id.textView41)
    TextView tvWelcome;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
    }

    @Override
    protected void setUp() {

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        tvWelcome.postDelayed(() -> {
            startActivity(LoginActivity.getStartIntent(this));
            finish();
        }, 1000);
    }
}
