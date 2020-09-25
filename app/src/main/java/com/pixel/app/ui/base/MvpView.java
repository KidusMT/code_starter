package com.pixel.app.ui.base;


import androidx.annotation.StringRes;

/**
 * Base interface that any class that wants to act as a View in the MVP (Model View Presenter)
 * pattern must implement. Generally this interface will be extended by a more specific interface
 * that then usually will be implemented by an Activity or Fragment.
 */

@SuppressWarnings({"unused", "RedundantSuppression"})
public interface MvpView {

    void showLoading();

    void hideLoading();

    void openActivityOnTokenExpire();

    void onError(@StringRes int resId);

    void onError(String message);

    void showMessage(String message);

    void showMessage(@StringRes int resId);

    boolean isNetworkConnected();

    void hideKeyboard();

    void showAlertDialog(int alertDialogType, String title, String content);

    /*
        Override on a specific activity or fragment to show connection lost page.
     */
    void showFullScreenConnectionLostPage();

    /*
        Override on a specific activity or fragment to hide connection lost page.
     */
    void hideFullScreenConnectionLostPage();

}
