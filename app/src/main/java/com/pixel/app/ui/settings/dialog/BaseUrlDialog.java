package com.pixel.app.ui.settings.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import com.pixel.app.R;
import com.pixel.app.di.component.ActivityComponent;
import com.pixel.app.ui.base.BaseDialog;
import com.pixel.app.ui.settings.BaseUrlDialogCommunicator;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@SuppressWarnings({"unused", "RedundantSuppression"})
public class BaseUrlDialog extends BaseDialog implements BaseUrlMvpView {


    public static final String TAG = BaseUrlDialog.class.getSimpleName();

    @Inject
    BaseUrlMvpPresenter<BaseUrlMvpView> mPresenter;

    @BindView(R.id.base_url)
    EditText etBaseUrl;

    BaseUrlDialogCommunicator communicator;

    public static BaseUrlDialog newInstance() {
        BaseUrlDialog fragment = new BaseUrlDialog();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_base_url, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {

            component.inject(this);

            setUnBinder(ButterKnife.bind(this, view));

            mPresenter.onAttach(this);
        }

        setUp(view);

        return view;
    }

    public void show(FragmentManager fragmentManager) {
        super.show(fragmentManager, TAG);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        communicator = (BaseUrlDialogCommunicator) getBaseActivity();
    }

    @Override
    protected void setUp(View view) {
        mPresenter.getCurrentBaseUrl();
    }

    @Override
    public void setCurrentBaseUrl(String baseUrl) {
        if (!TextUtils.isEmpty(baseUrl))
            etBaseUrl.setText(baseUrl);
    }

    @OnClick(R.id.btn_dialog_cancel)
    void onCancelClick() {
        mPresenter.onCancelClick();
    }

    @OnClick(R.id.btn_dialog_save)
    void onSaveClick() {
        String baseUrl = etBaseUrl.getText().toString();
        if (!TextUtils.isEmpty(baseUrl))
            mPresenter.setBaseUrl(baseUrl);
        mPresenter.onCancelClick();
    }

    @Override
    public void dismissDialog() {
        super.dismissDialog(TAG);
        communicator.baseUrlReload();
    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }

    @Override
    public void showFullScreenConnectionLostPage() {

    }

    @Override
    public void hideFullScreenConnectionLostPage() {

    }
}