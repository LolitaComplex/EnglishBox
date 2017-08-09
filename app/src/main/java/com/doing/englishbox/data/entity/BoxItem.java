package com.doing.englishbox.data.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.doing.englishbox.data.greendao.DaoSession;
import com.doing.englishbox.data.greendao.SentenceDao;
import com.doing.englishbox.data.greendao.AboutItemDao;
import com.doing.englishbox.data.greendao.ChineseDao;
import com.doing.englishbox.data.greendao.BoxItemDao;

/**
 * Class description here
 *
 * @author doing
 * @version 1.0.0
 * @since 2017-08-02.
 */
@Entity
public class BoxItem {

    @Id(autoincrement = true)
    private Long id;

    @Index(unique = true)
    @NotNull
    private String content;

    @ToMany(referencedJoinProperty = "boxItemId")
    private List<Chinese> chinese;

    @ToMany(referencedJoinProperty = "boxItemId")
    private List<AboutItem> about;

    @ToMany(referencedJoinProperty = "boxItemId")
    private List<Sentence> sentences;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 734372337)
    private transient BoxItemDao myDao;

    public BoxItem(String content, List<Chinese> chinese, List<AboutItem> about, List<Sentence> sentences) {
        this.content = content;
        this.chinese = chinese;
        this.about = about;
        this.sentences = sentences;
    }

    @Generated(hash = 379936489)
    public BoxItem(Long id, @NotNull String content) {
        this.id = id;
        this.content = content;
    }

    @Generated(hash = 1418613820)
    public BoxItem() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 526855415)
    public List<Chinese> getChinese() {
        if (chinese == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ChineseDao targetDao = daoSession.getChineseDao();
            List<Chinese> chineseNew = targetDao._queryBoxItem_Chinese(id);
            synchronized (this) {
                if (chinese == null) {
                    chinese = chineseNew;
                }
            }
        }
        return chinese;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 272544991)
    public synchronized void resetChinese() {
        chinese = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1508601150)
    public List<AboutItem> getAbout() {
        if (about == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            AboutItemDao targetDao = daoSession.getAboutItemDao();
            List<AboutItem> aboutNew = targetDao._queryBoxItem_About(id);
            synchronized (this) {
                if (about == null) {
                    about = aboutNew;
                }
            }
        }
        return about;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 187185894)
    public synchronized void resetAbout() {
        about = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 231352939)
    public List<Sentence> getSentences() {
        if (sentences == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            SentenceDao targetDao = daoSession.getSentenceDao();
            List<Sentence> sentencesNew = targetDao._queryBoxItem_Sentences(id);
            synchronized (this) {
                if (sentences == null) {
                    sentences = sentencesNew;
                }
            }
        }
        return sentences;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1238561480)
    public synchronized void resetSentences() {
        sentences = null;
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
    @Generated(hash = 754873063)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getBoxItemDao() : null;
    }


}
