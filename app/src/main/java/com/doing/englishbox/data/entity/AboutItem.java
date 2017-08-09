package com.doing.englishbox.data.entity;

import com.doing.englishbox.data.greendao.AboutItemDao;
import com.doing.englishbox.data.greendao.ChineseDao;
import com.doing.englishbox.data.greendao.DaoSession;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.ToOne;

/**
 * Class description here
 *
 * @author doing
 * @version 1.0.0
 * @since 2017-08-02.
 */
@Entity
public class AboutItem {

    @Id(autoincrement = true)
    private Long aboutId;

    @ToOne(joinProperty = "aboutOtherId")
    private AboutItem item;

    private Long aboutOtherId;

    @Index(unique = true)
    private String content;

    @ToOne(joinProperty = "chineseId")
    private Chinese chinese;

    private Long chineseId;

    private Long boxItemId;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1632368313)
    private transient AboutItemDao myDao;

    @Generated(hash = 1864644456)
    private transient Long item__resolvedKey;

    @Generated(hash = 1835936282)
    private transient Long chinese__resolvedKey;

    @Generated(hash = 402033187)
    public AboutItem(Long aboutId, Long aboutOtherId, String content, Long chineseId,
            Long boxItemId) {
        this.aboutId = aboutId;
        this.aboutOtherId = aboutOtherId;
        this.content = content;
        this.chineseId = chineseId;
        this.boxItemId = boxItemId;
    }

    @Generated(hash = 1404466184)
    public AboutItem() {
    }

    public Long getBoxItemId() {
        return boxItemId;
    }

    public void setBoxItemId(Long boxItemId) {
        this.boxItemId = boxItemId;
    }


    public Long getAboutId() {
        return aboutId;
    }

    public void setAboutId(Long aboutId) {
        this.aboutId = aboutId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1904435164)
    public AboutItem getItem() {
        Long __key = this.aboutOtherId;
        if (item__resolvedKey == null || !item__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            AboutItemDao targetDao = daoSession.getAboutItemDao();
            AboutItem itemNew = targetDao.load(__key);
            synchronized (this) {
                item = itemNew;
                item__resolvedKey = __key;
            }
        }
        return item;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 782788041)
    public void setItem(AboutItem item) {
        synchronized (this) {
            this.item = item;
            aboutOtherId = item == null ? null : item.getAboutId();
            item__resolvedKey = aboutOtherId;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1233975458)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getAboutItemDao() : null;
    }

    public Long getAboutOtherId() {
        return this.aboutOtherId;
    }

    public void setAboutOtherId(Long aboutOtherId) {
        this.aboutOtherId = aboutOtherId;
    }

    public Long getChineseId() {
        return this.chineseId;
    }

    public void setChineseId(Long chineseId) {
        this.chineseId = chineseId;
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1596988088)
    public Chinese getChinese() {
        Long __key = this.chineseId;
        if (chinese__resolvedKey == null || !chinese__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ChineseDao targetDao = daoSession.getChineseDao();
            Chinese chineseNew = targetDao.load(__key);
            synchronized (this) {
                chinese = chineseNew;
                chinese__resolvedKey = __key;
            }
        }
        return chinese;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 670412746)
    public void setChinese(Chinese chinese) {
        synchronized (this) {
            this.chinese = chinese;
            chineseId = chinese == null ? null : chinese.getChineseId();
            chinese__resolvedKey = chineseId;
        }
    }
}
