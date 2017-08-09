package com.doing.englishbox.ui.base;

import com.artron.baselib.base.BaseApplication;
import com.doing.englishbox.data.config.AppProfile;

/**
 * Class description here
 *
 * @author doing
 * @version 1.0.0
 * @since 2017-08-07.
 */

public class AppBaseApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        AppProfile.init(this);
    }
}
