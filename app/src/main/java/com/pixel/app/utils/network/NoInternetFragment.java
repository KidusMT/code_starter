package com.pixel.app.utils.network;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.pixel.app.R;
import com.pixel.app.di.component.ActivityComponent;
import com.pixel.app.ui.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NoInternetFragment extends BaseFragment {

    @BindView(R.id.image)
    ImageView image;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, NoInternetFragment.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_no_internet, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
        }

        setUp(view);

        return view;
    }


    @Override
    protected void setUp(View view) {
        hideKeyboard();
        hideLoading();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @OnClick(R.id.btn_retry)
    void onCheckInTimeClick() {

    }

    @Override
    public void showFullScreenConnectionLostPage() {

    }

    @Override
    public void hideFullScreenConnectionLostPage() {

    }
}
