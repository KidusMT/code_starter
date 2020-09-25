package com.pixel.app.data;

import com.pixel.app.data.db.DbHelper;
import com.pixel.app.data.network.ApiHelper;
import com.pixel.app.data.prefs.PreferencesHelper;

import io.reactivex.Observable;


@SuppressWarnings({"unused", "RedundantSuppression", "EmptyMethod"})
public interface DataManager extends DbHelper, PreferencesHelper, ApiHelper {

    void updateApiHeader(
//            Long userId,
            String accessToken);

    void setUserAsLoggedOut();

    @SuppressWarnings("SameReturnValue")
    Observable<Boolean> seedDatabaseQuestions();

    @SuppressWarnings("SameReturnValue")
    Observable<Boolean> seedDatabaseOptions();

    void updateUserInfo(
            String accessToken,
            Long applicantId,
            LoggedInMode loggedInMode,
            String fullName,
            String email//,
//            String profilePicPath
    );

    enum LoggedInMode {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_GOOGLE(1),
        LOGGED_IN_MODE_FB(2),
        LOGGED_IN_MODE_SERVER(3);

        private final int mType;

        LoggedInMode(int type) {
            mType = type;
        }

        public int getType() {
            return mType;
        }
    }


}
