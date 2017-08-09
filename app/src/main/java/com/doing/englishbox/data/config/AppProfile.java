package com.doing.englishbox.data.config;

import android.content.Context;

import com.doing.englishbox.data.greendao.DaoSession;

/**
 * Class description here
 *
 * @author doing
 * @version 1.0.0
 * @since 2017-08-07.
 */

public class AppProfile {

    private static DaoSession sDaoSession;

    public static void init(Context context) {
        sDaoSession = DaoConfig.getDaoSession(context, "EnglishBox");
    }

    public static DaoSession getDaoSession() {
        return sDaoSession;
    }
}
