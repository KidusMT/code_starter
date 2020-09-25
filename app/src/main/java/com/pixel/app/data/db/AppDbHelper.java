package com.pixel.app.data.db;

import com.pixel.app.data.db.model.DaoMaster;
import com.pixel.app.data.db.model.DaoSession;

import javax.inject.Inject;
import javax.inject.Singleton;

@SuppressWarnings({"unused", "RedundantSuppression", "FieldCanBeLocal"})
@Singleton
public class AppDbHelper implements DbHelper {

    private final DaoSession mDaoSession;

    @Inject
    public AppDbHelper(DbOpenHelper dbOpenHelper) {
        mDaoSession = new DaoMaster(dbOpenHelper.getWritableDb()).newSession();
    }

}
