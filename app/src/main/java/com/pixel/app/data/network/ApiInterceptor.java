package com.pixel.app.data.network;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by KidusMT.
 */

@Singleton
public class ApiInterceptor implements Interceptor {

    private static final String TAG = ApiInterceptor.class.getSimpleName();

    private ApiHeader mApiHeader;

    @Inject
    public ApiInterceptor(final ApiHeader header) {
        mApiHeader = header;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        final Request request = chain.request();
        final Request.Builder builder = request.newBuilder();
        String apiAuthType = request.header(ApiHeader.API_AUTH_TYPE);
        if (apiAuthType == null) {
            apiAuthType = ApiHeader.PROTECTED_API;
        }

        switch (apiAuthType) {
            case ApiHeader.PROTECTED_API:
                builder.addHeader(ApiHeader.HEADER_PARAM_ACCESS_TOKEN, mApiHeader.getAccessToken());
            case ApiHeader.PUBLIC_API:
        }

        return chain.proceed(builder.build());
    }
}
