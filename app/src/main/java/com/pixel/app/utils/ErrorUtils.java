package com.pixel.app.utils;

import com.google.gson.JsonSyntaxException;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;
import com.pixel.BCMS.data.network.model.WrapperError;
import com.pixel.app.ui.base.MvpView;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.SocketTimeoutException;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class ErrorUtils {

    //    if (throwable instanceof retrofit2.HttpException && ((retrofit2.HttpException)throwable).code() == 403){
    public static void handleApiError(Throwable error, MvpView mView) {
        if (error instanceof HttpException) {
            switch (((HttpException) error).code()) {
                case 401: // unauthorized
                    mView.onError("You are unauthorized to perform this action");
                    break;
                case 402: // payment required
                    mView.showAlertDialog(SweetAlertDialog.ERROR_TYPE,
                            "Unable to create a new service",
                            "You don't have an active subscription, please update your subscription");
                    break;
                case 403: // forbidden
                    mView.showAlertDialog(SweetAlertDialog.ERROR_TYPE,
                            "You are banned",
                            "You have been banned by the system administrator, please contact your nearby Workbook office");
                    break;
                case 412: { // precondition failed
                    String errorBody = String.valueOf(((HttpException) error).response().errorBody());
                    try {
                        JSONObject jsonObject = new JSONObject(errorBody);
                        String shortErrorMessage = jsonObject.getJSONObject("error")
                                .getString("message");
                        mView.showAlertDialog(SweetAlertDialog.ERROR_TYPE,
                                "Request Failed", shortErrorMessage);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 422: // un-processable entity
                    mView.showAlertDialog(SweetAlertDialog.ERROR_TYPE,
                            "Unable to create a new service",
                            "Seems like there is error on your form, please check again and retry");
                    break;
                case 500: // internal server error
                    mView.onError("Oops! something happened, please try again");
                    break;
//            switch (((HttpException) error).code()) {
//                case HttpsURLConnection.HTTP_UNAUTHORIZED:
//                    mView.onError("Unauthorised User ");
//                    break;
//                case HttpsURLConnection.HTTP_FORBIDDEN:
//                    mView.onError("Forbidden");
//                    break;
//                case HttpsURLConnection.HTTP_INTERNAL_ERROR:
//                    mView.onError("Internal Server Error");
//                    break;
//                case HttpsURLConnection.HTTP_BAD_REQUEST:
//                    mView.onError("Bad Request");
//                    break;
//                case API_STATUS_CODE_LOCAL_ERROR:
//                    mView.onError("No Internet Connection");
//                    break;
//                default:
//                    mView.onError(error.getLocalizedMessage());
            }
        } else if (error instanceof WrapperError) {
            mView.onError(error.getMessage());
        } else if (error instanceof SocketTimeoutException) {
            mView.onError("Sorry. Your sign up attempt timed out, please try again.");
        } else if (error instanceof JsonSyntaxException) {
            mView.onError("Something Went Wrong API is not responding properly!");
        } else {
            mView.onError(error.getMessage());
        }
    }
}
