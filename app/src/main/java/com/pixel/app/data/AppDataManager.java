package com.pixel.app.data;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pixel.app.data.db.DbHelper;
import com.pixel.app.data.network.ApiHelper;
import com.pixel.app.data.network.model.login.LoginRequest;
import com.pixel.app.data.network.model.login.LoginResponse;
import com.pixel.app.data.prefs.PreferencesHelper;
import com.pixel.app.di.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import retrofit2.Retrofit;

@SuppressWarnings({"unused", "RedundantSuppression", "FieldCanBeLocal"})
@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = AppDataManager.class.getSimpleName();

    private final Context mContext;
    private final DbHelper mDbHelper;
    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          DbHelper dbHelper,
                          PreferencesHelper preferencesHelper,
                          ApiHelper apiHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
    }

    @Override
    public String getCurrentLanguage() {
        return mPreferencesHelper.getCurrentLanguage();
    }

    @Override
    public void setCurrentLanguage(String language) {
        mPreferencesHelper.setCurrentLanguage(language);
    }

    @Override
    public String getCurrentBaseUrl() {
        return mPreferencesHelper.getCurrentBaseUrl();
    }

    @Override
    public void setCurrentBaseUrl(String baseUrl) {
        mPreferencesHelper.setCurrentBaseUrl(baseUrl);
    }

    @Override
    public boolean getAuthPrivilege() {
        return mPreferencesHelper.getAuthPrivilege();
    }

    @Override
    public void setAuthPrivilege(boolean isAuthorized) {
        mPreferencesHelper.setAuthPrivilege(isAuthorized);
    }

    @Override
    public void updateApiHeader(String accessToken) {
//        mApiHelper.getApiHeader().getProtectedApiHeader().setUserId(userId);
//        mApiHelper.getApiHeader().getProtectedApiHeader().setAccessToken(accessToken);
    }

    @Override
    public void updateUserInfo(
            String accessToken,
            Long applicantId,
            LoggedInMode loggedInMode,
            String fullName,
            String email
    ) {
        setAccessToken(accessToken);
        setCurrentApplicantId(applicantId);
        setCurrentUserLoggedInMode(loggedInMode);
        setCurrentFullName(fullName);
        setCurrentUserEmail(email);
    }

    @Override
    public void setUserAsLoggedOut() {
        updateUserInfo(
                null,
                null,
                LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT,
                null,
                null//,
//                null
        );
    }

    @Override
    public Observable<Boolean> seedDatabaseQuestions() {

        GsonBuilder builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();

//        return mDbHelper.isQuestionEmpty()
//                .concatMap(new Function<Boolean, ObservableSource<? extends Boolean>>() {
//                    @Override
//                    public ObservableSource<? extends Boolean> apply(Boolean isEmpty)
//                            throws Exception {
//                        if (isEmpty) {
//                            Type type = $Gson$Types
//                                    .newParameterizedTypeWithOwner(null, List.class,
//                                            Question.class);
//                            List<Question> questionList = gson.fromJson(
//                                    com.pixel.CommonUtils.loadJSONFromAsset(mContext,
//                                            com.pixel.AppConstants.SEED_DATABASE_QUESTIONS),
//                                    type);
//
//                            return saveQuestionList(questionList);
//                        }
//                        return Observable.just(false);
//                    }
//                });
        return null;
    }

    @Override
    public Observable<Boolean> seedDatabaseOptions() {

        GsonBuilder builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();

//        return mDbHelper.isOptionEmpty()
//                .concatMap(new Function<Boolean, ObservableSource<? extends Boolean>>() {
//                    @Override
//                    public ObservableSource<? extends Boolean> apply(Boolean isEmpty)
//                            throws Exception {
//                        if (isEmpty) {
//                            Type type = new TypeToken<List<Option>>() {
//                            }
//                                    .getType();
//                            List<Option> optionList = gson.fromJson(
//                                    com.pixel.CommonUtils.loadJSONFromAsset(mContext,
//                                            com.pixel.AppConstants.SEED_DATABASE_OPTIONS),
//                                    type);
//
//                            return saveOptionList(optionList);
//                        }
//                        return Observable.just(false);
//                    }
//                });

        return null;
    }

    @Override
    public int getCurrentUserLoggedInMode() {
        return mPreferencesHelper.getCurrentUserLoggedInMode();
    }

    @Override
    public void setCurrentUserLoggedInMode(LoggedInMode mode) {
        mPreferencesHelper.setCurrentUserLoggedInMode(mode);
    }

    @Override
    public Long getCurrentApplicantId() {
        return mPreferencesHelper.getCurrentApplicantId();
    }

    @Override
    public void setCurrentApplicantId(Long applicantId) {
        mPreferencesHelper.setCurrentApplicantId(applicantId);
    }

    @Override
    public String getCurrentFullName() {
        return mPreferencesHelper.getCurrentFullName();
    }

    @Override
    public void setCurrentFullName(String userName) {
        mPreferencesHelper.setCurrentFullName(userName);
    }

    @Override
    public String getApplicantFullName() {
        return mPreferencesHelper.getApplicantFullName();
    }

    @Override
    public void setApplicantFullName(String userName) {
        mPreferencesHelper.setApplicantFullName(userName);
    }

    @Override
    public String getCurrentUserEmail() {
        return mPreferencesHelper.getCurrentUserEmail();
    }

    @Override
    public void setCurrentUserEmail(String email) {
        mPreferencesHelper.setCurrentUserEmail(email);
    }

    @Override
    public String getCurrentUserProfilePicUrl() {
        return mPreferencesHelper.getCurrentUserProfilePicUrl();
    }

    @Override
    public void setCurrentUserProfilePicUrl(String profilePicUrl) {
        mPreferencesHelper.setCurrentUserProfilePicUrl(profilePicUrl);
    }

    @Override
    public String getAccessToken() {
        return mPreferencesHelper.getAccessToken();
    }

    @Override
    public void setAccessToken(String accessToken) {
        mPreferencesHelper.setAccessToken(accessToken);
    }

    @Override
    public Retrofit getRetrofitInstance() {
        return mApiHelper.getRetrofitInstance();
    }

    @Override
    public Observable<LoginResponse> login(LoginRequest request) {
        return mApiHelper.login(request);
    }

}
