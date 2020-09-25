package com.pixel.app.data.network;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.pixel.app.BuildConfig;
import com.pixel.app.data.network.model.login.LoginRequest;
import com.pixel.app.data.network.model.login.LoginResponse;
import com.pixel.app.di.ApplicationContext;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@SuppressWarnings({"unused", "RedundantSuppression", "FieldCanBeLocal"})
@Singleton
public class AppApiHelper implements ApiHelper {

    private static final HttpLoggingInterceptor logger =
            new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY);
    private final Context mContext;
    private final ApiHeader mApiHeader;

    @Inject
    public AppApiHelper(ApiHeader apiHeader, @ApplicationContext Context context) {
        mApiHeader = apiHeader;
        mContext = context;
    }

    @Override
    public Observable<LoginResponse> login(LoginRequest request) {
        return getRetrofitInstance().create(APIService.class).login(request);
    }

    @Override
    public Retrofit getRetrofitInstance() {

        int cacheSize = 10 * 1024 * 1024; // 10 MB
        Cache cache = new Cache(mContext.getCacheDir(), cacheSize);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(logger)
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(interceptor)//for logging the okHttpResponseAndRequest
                .cache(cache)
                .build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        // todo have to find a way for notifying the user without crashing the application
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)//localhost
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

}

