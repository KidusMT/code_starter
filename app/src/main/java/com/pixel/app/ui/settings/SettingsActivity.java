package com.pixel.app.ui.settings;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.SwitchCompat;

import com.pixel.app.R;
import com.pixel.app.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingsActivity extends BaseActivity implements SettingsMvpView, BaseUrlDialogCommunicator {

    @Inject
    SettingsMvpPresenter<SettingsMvpView> mPresenter;

    @BindView(R.id.lbl_current_language)
    TextView mCurrentLanguage;

    @BindView(R.id.switch_location)
    SwitchCompat mLocationSwitch;

    @BindView(R.id.switch_microphone)
    SwitchCompat mMicrophoneSwitch;

    @BindView(R.id.switch_storage)
    SwitchCompat mStorageSwitch;

    @BindView(R.id.switch_camera)
    SwitchCompat mCameraSwitch;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, SettingsActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        // the presenter
        mPresenter.onAttach(SettingsActivity.this);

        setUp();

    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {
        mPresenter.getAuthPrivilege();
        mStorageSwitch.setClickable(false);
        mLocationSwitch.setClickable(false);
        mMicrophoneSwitch.setClickable(false);
        mCameraSwitch.setClickable(false);
        mPresenter.resolveCurrentLanguage();
        mPresenter.getCurrentBaseUrl();
    }

    @SuppressWarnings({"unused", "RedundantSuppression"})
    @Override
    public void setCurrentLanguage(String language) {
        if (language.equals("en")) {
            mCurrentLanguage.setText(R.string.settings_activity_english);
        } else if (language.equals("am")) {
            mCurrentLanguage.setText(R.string.settings_activity_amharic);
        }
    }

    @SuppressWarnings({"unused", "RedundantSuppression"})
    @Override
    public void setCurrentBaseUrl(String baseUrl) {
//        if (!TextUtils.isEmpty(baseUrl))
//            etBaseUrl.setText(baseUrl);
    }

    @SuppressWarnings({"unused", "RedundantSuppression"})
    @Override
    public void setAuthPrivilege(boolean isAuthorized) {
//        mAuthSwitch.setChecked(isAuthorized);
    }

    @SuppressWarnings({"unused", "RedundantSuppression"})
    @Override
    public void openProjectSetup() {
//        startActivity(SetupActivity.getStartIntent(this, true));
    }

    @SuppressWarnings({"unused", "RedundantSuppression"})
    @OnClick(R.id.layout_current_language)
    public void onClickCurrentLanguage(View view) {
        startActivity(new Intent(this, LanguageListActivity.class));
    }

    private boolean checkLocationPermissionStatus() {
        return hasPermission(Manifest.permission.ACCESS_FINE_LOCATION);
    }

    private boolean checkStoragePermissionStatus() {
        return hasPermission(Manifest.permission.READ_EXTERNAL_STORAGE);
    }

    private boolean checkMicrophonePermissionStatus() {
        return hasPermission(Manifest.permission.RECORD_AUDIO);
    }

    private boolean checkCameraPermissionStatus() {
        return hasPermission(Manifest.permission.CAMERA);
    }

    @Override
    protected void onResume() {
        super.onResume();
        resolvePermissionStatuses();
        mPresenter.getCurrentBaseUrl();
    }

    private void resolvePermissionStatuses() {
        if (checkCameraPermissionStatus()) {
            mCameraSwitch.setChecked(true);
        } else {
            mCameraSwitch.setChecked(false);
        }

        if (checkLocationPermissionStatus()) {
            mLocationSwitch.setChecked(true);
        } else {
            mLocationSwitch.setChecked(false);
        }

        if (checkMicrophonePermissionStatus()) {
            mMicrophoneSwitch.setChecked(true);
        } else {
            mMicrophoneSwitch.setChecked(false);
        }

        if (checkStoragePermissionStatus()) {
            mStorageSwitch.setChecked(true);
        } else {
            mStorageSwitch.setChecked(false);
        }
    }

    @SuppressWarnings({"unused", "RedundantSuppression"})
    @OnClick(R.id.back_button)
    public void OnClickBack(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @SuppressWarnings({"unused", "RedundantSuppression"})
    @OnClick({R.id.switch_storage_wrapper, R.id.switch_camera_wrapper, R.id.switch_location_wrapper, R.id.switch_microphone_wrapper})
    public void goToPermissionsSetting(View v) {
        Intent intent = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                Uri.fromParts("package", getPackageName(), null));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void baseUrlReload() {
        mPresenter.getCurrentBaseUrl();
    }
}
