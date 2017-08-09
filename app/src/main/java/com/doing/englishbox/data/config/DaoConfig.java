package com.doing.englishbox.data.config;

import android.content.Context;

import com.doing.englishbox.data.greendao.DaoMaster;
import com.doing.englishbox.data.greendao.DaoSession;

/**
 * Class description here
 *
 * @author doing
 * @version 1.0.0
 * @since 2017-08-07.
 */

class DaoConfig {

    static DaoSession getDaoSession(Context context, String name) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, name, null);
        DaoMaster master = new DaoMaster(helper.getWritableDatabase());
        return master.newSession();
    }
}
