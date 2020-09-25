package com.pixel.app.data.network;

import com.pixel.app.data.network.model.login.LoginRequest;
import com.pixel.app.data.network.model.login.LoginResponse;

import io.reactivex.Observable;
import retrofit2.Retrofit;

@SuppressWarnings({"unused", "RedundantSuppression"})
public interface ApiHelper {
    Retrofit getRetrofitInstance();

    Observable<LoginResponse> login(LoginRequest request);
}
