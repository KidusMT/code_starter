package com.pixel.app.data.db;

import android.content.Context;

import com.pixel.app.data.db.model.DaoMaster;
import com.pixel.app.di.ApplicationContext;
import com.pixel.app.di.DatabaseInfo;
import com.pixel.app.utils.AppLogger;

import org.greenrobot.greendao.database.Database;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DbOpenHelper extends DaoMaster.OpenHelper {

    @Inject
    public DbOpenHelper(@ApplicationContext Context context, @DatabaseInfo String name) {
        super(context, name);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        AppLogger.d("DEBUG", "DB_OLD_VERSION : " + oldVersion + ", DB_NEW_VERSION : " + newVersion);
//        switch (oldVersion) {
//                db.execSQL("ALTER TABLE " + CheckInDao.TABLENAME + " ADD COLUMN "
//                 + CheckInDao.Properties.BeforeMorningOT + " INTEGER DEFAULT 'DEFAULT_VAL'");
//        }
//        MigrationHelper.migrate(new StandardDatabase((SQLiteDatabase) db.getRawDatabase()),
//                CrewIDImageDao.class);
    }
}
