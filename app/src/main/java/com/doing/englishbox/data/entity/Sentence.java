package com.doing.englishbox.data.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.doing.englishbox.data.greendao.DaoSession;
import com.doing.englishbox.data.greendao.ChineseDao;
import com.doing.englishbox.data.greendao.SentenceDao;

/**
 * Class description here
 *
 * @author doing
 * @version 1.0.0
 * @since 2017-08-07.
 */
@Entity
public class Sentence implements Item{

    @Id(autoincrement = true)
    private Long id;

    @NotNull
    private String content;

    private Long chineseId;

    @ToOne(joinProperty = "chineseId")
    private Chinese chinese;
    private Long boxItemId;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 159520501)
    private transient SentenceDao myDao;

    @Generated(hash = 1928824282)
    public Sentence(Long id, @NotNull String content, Long chineseId,
            Long boxItemId) {
        this.id = id;
        this.content = content;
        this.chineseId = chineseId;
        this.boxItemId = boxItemId;
    }

    @Generated(hash = 300356185)
    public Sentence() {
    }

    @Generated(hash = 1835936282)
    private transient Long chinese__resolvedKey;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getChineseId() {
        return this.chineseId;
    }

    public void setChineseId(Long chineseId) {
        this.chineseId = chineseId;
    }

    public Long getBoxItemId() {
        return this.boxItemId;
    }

    public void setBoxItemId(Long boxItemId) {
        this.boxItemId = boxItemId;
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
    @Generated(hash = 1485501826)
    public void setChinese(Chinese chinese) {
        synchronized (this) {
            this.chinese = chinese;
            chineseId = chinese == null ? null : chinese.getId();
            chinese__resolvedKey = chineseId;
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
    @Generated(hash = 586060153)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getSentenceDao() : null;
    }



}
