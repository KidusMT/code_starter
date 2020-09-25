package com.pixel.app.ui.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.pixel.app.R;
import com.pixel.app.ui.base.BaseActivity;
import com.pixel.app.ui.login.LoginActivity;
import com.pixel.app.ui.settings.SettingsActivity;
import com.pixel.app.utils.NetworkUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainMvpView, MenuAdapter.Callback {

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    @Inject
    MenuAdapter mAdapter;

    @Inject
    LinearLayoutManager mLayoutManager;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.drawer_view)
    DrawerLayout mDrawer;

    @BindView(R.id.layout_content)
    View layout_content;

    @BindView(R.id.layout_no_internet)
    View layout_no_internet;

    @BindView(R.id.appbarLayout)
    AppBarLayout appBarLayout;

    @BindView(R.id.rv_application)
    RecyclerView mRecyclerView;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);

        mAdapter.setCallback(this);

        setUp();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        hideLoading();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mDrawer != null)
            mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @SuppressWarnings({"unused", "RedundantSuppression"})
    @Override
    public void showFullScreenConnectionLostPage() {
        super.showFullScreenConnectionLostPage();
        layout_content.setVisibility(View.GONE);
//        appBarLayout.setVisibility(View.GONE);
        layout_no_internet.setVisibility(View.VISIBLE);

    }

    @SuppressWarnings({"unused", "RedundantSuppression"})
    @Override
    public void hideFullScreenConnectionLostPage() {
        super.hideFullScreenConnectionLostPage();
        layout_content.setVisibility(View.VISIBLE);
//        appBarLayout.setVisibility(View.VISIBLE);
        layout_no_internet.setVisibility(View.GONE);
    }


    @SuppressWarnings({"unused", "RedundantSuppression"})
    @OnClick(R.id.btn_retry)
    public void onClickRetry(View view) {
        mPresenter.loadApplications();
    }

    @SuppressWarnings({"unused", "RedundantSuppression", "EmptyMethod"})
    @Override
    public void onFragmentAttached() {
    }

    @SuppressWarnings({"unused", "RedundantSuppression"})
    @Override
    public void onFragmentDetached(String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragment != null) {
            fragmentManager
                    .beginTransaction()
                    .disallowAddToBackStack()
                    .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                    .remove(fragment)
                    .commitNow();
//            unlockDrawer();
        }
    }

    @Override
    public void openLoginScreen() {
        startActivity(LoginActivity.getStartIntent(this));
        finish();
    }

//    @Override
//    public void showApplicationForms(ApplicationFilterResponse applicationForms) {
////        applicationForms.getDatum().get(0).
//        this.applicationForms = applicationForms;
//        if (applicationForms != null && applicationForms.getDatum() != null && applicationForms.getDatum().size() > 0) {
//            if (noContentContainer != null && noContentContainer.getVisibility() == View.VISIBLE) {
//                noContentContainer.setVisibility(View.GONE);
////                btnNewApplication.setVisibility(View.GONE);
//            }
//            if (mRecyclerView != null && mRecyclerView.getVisibility() == View.GONE)
//                mRecyclerView.setVisibility(View.VISIBLE);
//            mAdapter.addItems(applicationForms.getDatum());
//        } else {
//            if (noContentContainer != null && noContentContainer.getVisibility() == View.GONE) {
//                noContentContainer.setVisibility(View.VISIBLE);
////                noContentContainer.setVisibility(View.VISIBLE);
////                mNoAssignedTask.setText("No crew member record found. \nPlease, Register a crew with the add button below.");
//            }
//            if (mRecyclerView != null && mRecyclerView.getVisibility() == View.VISIBLE)
//                mRecyclerView.setVisibility(View.GONE);
//        }
//        hideLoading();
//    }


    @Override
    public void openSettings() {
        startActivity(SettingsActivity.getStartIntent(this));
    }

    @Override
    protected void setUp() {
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        setupMenuRecyclerView();
        mPresenter.loadApplications();
    }

    private void setupMenuRecyclerView() {
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
    }

    public void promptLogout() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.are_you_sure_you_want_to_logout)
                .setPositiveButton(getString(R.string.logout_dialog), (dialog, id) -> mPresenter.onLogoutClicked())
                .setNegativeButton(getString(R.string.cancel), (dialog, id) -> dialog.dismiss());
        AlertDialog alert = builder.create();
        alert.show();
    }

    @SuppressWarnings({"unused", "RedundantSuppression"})
    @Override
    public void onItemClicked(/*Data application*/) {
//        openApplicationScreen(application.getId());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Drawable drawable = item.getIcon();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }

        if (item.getItemId() == R.id.menu_settings) {
            if (NetworkUtils.isNetworkConnected(this)) {
                openSettings();
            } else {
                showMessage("No internet connection. Please try again.");
            }

            return true;
        }

        if (item.getItemId() == R.id.menu_logout) {
            promptLogout();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
}
