package com.doing.englishbox.data.database;

import com.doing.englishbox.data.config.AppProfile;
import com.doing.englishbox.data.entity.AboutItem;
import com.doing.englishbox.data.entity.BoxItem;
import com.doing.englishbox.data.entity.Chinese;
import com.doing.englishbox.data.entity.Sentence;
import com.doing.englishbox.data.greendao.AboutItemDao;
import com.doing.englishbox.data.greendao.BoxItemDao;
import com.doing.englishbox.data.greendao.ChineseDao;
import com.doing.englishbox.data.greendao.SentenceDao;


/**
 * Class description here
 *
 * @author doing
 * @version 1.0.0
 * @since 2017-08-07.
 */

public class BoxItemManager {

    private static BoxItemDao sBoxItemDao =
            AppProfile.getDaoSession().getBoxItemDao();
    private static ChineseDao sChineseDao =
            AppProfile.getDaoSession().getChineseDao();
    private static AboutItemDao sAboutItemDao =
            AppProfile.getDaoSession().getAboutItemDao();
    private static SentenceDao sSentenceDao =
            AppProfile.getDaoSession().getSentenceDao();

    private static BoxItemManager sInstance = new BoxItemManager();

    private BoxItemManager(){}

    public static BoxItemManager getInstance() {
        return sInstance;
    }

    public <T> long add(T item) {
        long result;
        if (item instanceof BoxItem) {
            result = sBoxItemDao.insertOrReplace((BoxItem) item);
        } else if (item instanceof Chinese) {
            result = sChineseDao.insertOrReplace((Chinese) item);
        } else if (item instanceof AboutItem) {
            result = sAboutItemDao.insertOrReplace((AboutItem) item);
        } else if (item instanceof SentenceDao) {
            result = sSentenceDao.insertOrReplace((Sentence) item);
        } else {
            result = -1;
        }

        return result;
    }

}
