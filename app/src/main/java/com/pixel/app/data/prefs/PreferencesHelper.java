package com.pixel.app.data.prefs;

import com.pixel.app.data.DataManager;

public interface PreferencesHelper {

    int getCurrentUserLoggedInMode();

    void setCurrentUserLoggedInMode(DataManager.LoggedInMode mode);

    Long getCurrentApplicantId();

    void setCurrentApplicantId(Long applicantId);

    String getCurrentFullName();

    void setCurrentFullName(String userName);

    String getApplicantFullName();

    void setApplicantFullName(String userName);

    String getCurrentUserEmail();

    void setCurrentUserEmail(String email);

    String getCurrentUserProfilePicUrl();

    void setCurrentUserProfilePicUrl(String profilePicUrl);

    String getAccessToken();

    void setAccessToken(String accessToken);

    String getCurrentLanguage();

    void setCurrentLanguage(String language);

    String getCurrentBaseUrl();

    void setCurrentBaseUrl(String baseUrl);

    void setAuthPrivilege(boolean isAuthorized);

    boolean getAuthPrivilege();
}
