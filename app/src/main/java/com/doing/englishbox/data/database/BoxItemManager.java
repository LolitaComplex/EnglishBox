package com.doing.englishbox.data.database;

import com.doing.englishbox.data.config.AppProfile;
import com.doing.englishbox.data.entity.AboutItem;
import com.doing.englishbox.data.entity.BoxItem;
import com.doing.englishbox.data.entity.Chinese;
import com.doing.englishbox.data.entity.Item;
import com.doing.englishbox.data.entity.Sentence;
import com.doing.englishbox.data.greendao.AboutItemDao;
import com.doing.englishbox.data.greendao.BoxItemDao;
import com.doing.englishbox.data.greendao.ChineseDao;
import com.doing.englishbox.data.greendao.SentenceDao;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.query.WhereCondition;

import java.util.List;

import rx.functions.Action2;

import static android.R.attr.action;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;


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
        long result = 1;
        if (item instanceof BoxItem) {
            BoxItem boxItem = (BoxItem) item;
            insertOrUpdate(sBoxItemDao, boxItem,
                    BoxItemDao.Properties.Content.eq(boxItem.getContent()));
        } else if (item instanceof Chinese) {
            Chinese chinesItem = (Chinese) item;
            insertOrUpdate(sChineseDao, chinesItem,
                    ChineseDao.Properties.Content.eq(chinesItem.getContent()));
        } else if (item instanceof AboutItem) {
            AboutItem aboutItem = (AboutItem) item;
            insertOrUpdate(sAboutItemDao, aboutItem,
                    AboutItemDao.Properties.Content.eq(aboutItem.getContent()));
        } else if (item instanceof Sentence) {
            Sentence sentenceItem = (Sentence) item;
            insertOrUpdate(sSentenceDao, sentenceItem,
                    SentenceDao.Properties.Content.eq(sentenceItem.getContent()));
        } else {
            result = -1;
        }

        return result;
    }

    private <S extends AbstractDao<T, Long>, T extends Item> void insertOrUpdate(S dao , T item, WhereCondition condition) {
        List<T> list = dao.queryBuilder()
                .where(condition)
                .build()
                .list();

        if (list.size() > 0) {
            T updateItem = list.get(0);
            updateItem.setContent(item.getContent());
            dao.update(updateItem);
        } else {
            dao.insert(item);
        }
    }

    public List<BoxItem> getBoxItemList() {
        return sBoxItemDao.queryBuilder()
                .build()
                .list();
    }

    public List<Chinese> getChineseList() {
        return sChineseDao.queryBuilder()
                .build()
                .list();
    }

    public List<AboutItem> getAboutList() {
        return sAboutItemDao.queryBuilder()
                .build()
                .list();
    }

    public List<Sentence> getSentenceList() {
        return sSentenceDao.queryBuilder()
                .build()
                .list();
    }

}
