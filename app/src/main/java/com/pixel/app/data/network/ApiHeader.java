package com.pixel.app.data.network;

import javax.inject.Singleton;

@SuppressWarnings({"unused", "RedundantSuppression"})
@Singleton
public class ApiHeader {

    public static final String API_AUTH_TYPE = "API_AUTH_TYPE";
    public static final String PUBLIC_API = "PUBLIC_API";
    public static final String PROTECTED_API = "PROTECTED_API";

    public static final String HEADER_PARAM_API_KEY = "api_key";
    public static final String HEADER_PARAM_ACCESS_TOKEN = "Authorization";
    public static final String HEADER_PARAM_USER_ID = "user_id";

    private String mApiKey;
    private Long mUserId;
    private String mAccessToken;

    public ApiHeader(String mAccessToken) {
        this.mAccessToken = mAccessToken;
    }


    public String getAccessToken() {
        return "Bearer " + mAccessToken;
    }

    public void setAccessToken(String accessToken) {
        mAccessToken = accessToken;
    }
}
