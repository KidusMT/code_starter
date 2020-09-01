package com.pixel.app.data.network;


import com.pixel.app.data.network.model.login.LoginRequest;
import com.pixel.app.data.network.model.login.LoginResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {

    String HEADER_PARAM_SEPARATOR = ":";

    @POST(ApiEndPoint.LOGIN)
    @Headers(ApiHeader.API_AUTH_TYPE + HEADER_PARAM_SEPARATOR + ApiHeader.PUBLIC_API)
    Observable<LoginResponse> login(@Body LoginRequest request);

}
