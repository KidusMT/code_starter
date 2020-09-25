package com.pixel.app.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.pixel.app.data.DataManager;
import com.pixel.app.di.ApplicationContext;
import com.pixel.app.di.PreferenceInfo;
import com.pixel.app.utils.AppConstants;

import javax.inject.Inject;
import javax.inject.Singleton;

@SuppressWarnings({"unused", "RedundantSuppression"})
@Singleton
public class AppPreferencesHelper implements PreferencesHelper {

    public static final String PREF_KEY_CURRENT_LANGUAGE = "PREF_KEY_CURRENT_LANGUAGE";
    public static final String PREF_KEY_CURRENT_BASE_URL = "PREF_KEY_CURRENT_BASE_URL";
    public static final String PREF_KEY_AUTH_PRIVILEGE = "PREF_KEY_AUTH_PRIVILEGE";
    private static final String PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE";
    private static final String PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID";
    private static final String PREF_KEY_CURRENT_USER_NAME = "PREF_KEY_CURRENT_USER_NAME";
    private static final String PREF_KEY_APPLICANT_FULL_NAME = "PREF_KEY_APPLICANT_FULL_NAME";
    private static final String PREF_KEY_CURRENT_USER_EMAIL = "PREF_KEY_CURRENT_USER_EMAIL";
    private static final String PREF_KEY_CURRENT_USER_PROFILE_PIC_URL
            = "PREF_KEY_CURRENT_USER_PROFILE_PIC_URL";
    private static final String PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN";
    private final SharedPreferences mPrefs;

    @Inject
    public AppPreferencesHelper(@ApplicationContext Context context,
                                @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

    @Override
    public Long getCurrentApplicantId() {
        long userId = mPrefs.getLong(PREF_KEY_CURRENT_USER_ID, AppConstants.NULL_INDEX);
        return userId == AppConstants.NULL_INDEX ? null : userId;
    }

    @Override
    public void setCurrentApplicantId(Long applicantId) {
        long id = applicantId == null ? AppConstants.NULL_INDEX : applicantId;
        mPrefs.edit().putLong(PREF_KEY_CURRENT_USER_ID, id).apply();
    }

    @Override
    public String getCurrentFullName() {
        return mPrefs.getString(PREF_KEY_CURRENT_USER_NAME, null);
    }

    @Override
    public void setCurrentFullName(String userName) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_NAME, userName).apply();
    }

    @Override
    public String getApplicantFullName() {
        return mPrefs.getString(PREF_KEY_APPLICANT_FULL_NAME, null);
    }

    @Override
    public void setApplicantFullName(String userName) {
        mPrefs.edit().putString(PREF_KEY_APPLICANT_FULL_NAME, userName).apply();
    }

    @Override
    public String getCurrentUserEmail() {
        return mPrefs.getString(PREF_KEY_CURRENT_USER_EMAIL, null);
    }

    @Override
    public void setCurrentUserEmail(String email) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_EMAIL, email).apply();
    }

    @Override
    public String getCurrentUserProfilePicUrl() {
        return mPrefs.getString(PREF_KEY_CURRENT_USER_PROFILE_PIC_URL, null);
    }

    @Override
    public void setCurrentUserProfilePicUrl(String profilePicUrl) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_PROFILE_PIC_URL, profilePicUrl).apply();
    }

    @Override
    public int getCurrentUserLoggedInMode() {
        return mPrefs.getInt(PREF_KEY_USER_LOGGED_IN_MODE,
                DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.getType());
    }

    @Override
    public void setCurrentUserLoggedInMode(DataManager.LoggedInMode mode) {
        mPrefs.edit().putInt(PREF_KEY_USER_LOGGED_IN_MODE, mode.getType()).apply();
    }

    @Override
    public String getAccessToken() {
        return mPrefs.getString(PREF_KEY_ACCESS_TOKEN, null);
    }

    @Override
    public void setAccessToken(String accessToken) {
        mPrefs.edit().putString(PREF_KEY_ACCESS_TOKEN, accessToken).apply();
    }

    @Override
    public String getCurrentLanguage() {
        return mPrefs.getString(PREF_KEY_CURRENT_LANGUAGE, "en");
    }

    @Override
    public void setCurrentLanguage(String language) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_LANGUAGE, language).apply();
    }

    @Override
    public String getCurrentBaseUrl() {
        return mPrefs.getString(PREF_KEY_CURRENT_BASE_URL, "localhost:3000");
    }

    @Override
    public void setCurrentBaseUrl(String baseUrl) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_BASE_URL, baseUrl).apply();
    }

    @Override
    public boolean getAuthPrivilege() {
        return mPrefs.getBoolean(PREF_KEY_AUTH_PRIVILEGE, false);
    }

    @Override
    public void setAuthPrivilege(boolean isAuthorized) {
        mPrefs.edit().putBoolean(PREF_KEY_AUTH_PRIVILEGE, isAuthorized).apply();
    }
}
