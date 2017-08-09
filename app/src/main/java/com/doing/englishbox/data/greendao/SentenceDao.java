package com.doing.englishbox.data.greendao;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import com.doing.englishbox.data.entity.Chinese;

import com.doing.englishbox.data.entity.Sentence;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "SENTENCE".
*/
public class SentenceDao extends AbstractDao<Sentence, Long> {

    public static final String TABLENAME = "SENTENCE";

    /**
     * Properties of entity Sentence.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property SentenceId = new Property(0, Long.class, "sentenceId", true, "_id");
        public final static Property Content = new Property(1, String.class, "content", false, "CONTENT");
        public final static Property ChineseId = new Property(2, Long.class, "chineseId", false, "CHINESE_ID");
        public final static Property BoxItemId = new Property(3, Long.class, "boxItemId", false, "BOX_ITEM_ID");
    }

    private DaoSession daoSession;

    private Query<Sentence> boxItem_SentencesQuery;

    public SentenceDao(DaoConfig config) {
        super(config);
    }
    
    public SentenceDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"SENTENCE\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: sentenceId
                "\"CONTENT\" TEXT NOT NULL ," + // 1: content
                "\"CHINESE_ID\" INTEGER," + // 2: chineseId
                "\"BOX_ITEM_ID\" INTEGER);"); // 3: boxItemId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"SENTENCE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Sentence entity) {
        stmt.clearBindings();
 
        Long sentenceId = entity.getSentenceId();
        if (sentenceId != null) {
            stmt.bindLong(1, sentenceId);
        }
        stmt.bindString(2, entity.getContent());
 
        Long chineseId = entity.getChineseId();
        if (chineseId != null) {
            stmt.bindLong(3, chineseId);
        }
 
        Long boxItemId = entity.getBoxItemId();
        if (boxItemId != null) {
            stmt.bindLong(4, boxItemId);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Sentence entity) {
        stmt.clearBindings();
 
        Long sentenceId = entity.getSentenceId();
        if (sentenceId != null) {
            stmt.bindLong(1, sentenceId);
        }
        stmt.bindString(2, entity.getContent());
 
        Long chineseId = entity.getChineseId();
        if (chineseId != null) {
            stmt.bindLong(3, chineseId);
        }
 
        Long boxItemId = entity.getBoxItemId();
        if (boxItemId != null) {
            stmt.bindLong(4, boxItemId);
        }
    }

    @Override
    protected final void attachEntity(Sentence entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Sentence readEntity(Cursor cursor, int offset) {
        Sentence entity = new Sentence( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // sentenceId
            cursor.getString(offset + 1), // content
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2), // chineseId
            cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3) // boxItemId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Sentence entity, int offset) {
        entity.setSentenceId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setContent(cursor.getString(offset + 1));
        entity.setChineseId(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
        entity.setBoxItemId(cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Sentence entity, long rowId) {
        entity.setSentenceId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Sentence entity) {
        if(entity != null) {
            return entity.getSentenceId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Sentence entity) {
        return entity.getSentenceId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "sentences" to-many relationship of BoxItem. */
    public List<Sentence> _queryBoxItem_Sentences(Long boxItemId) {
        synchronized (this) {
            if (boxItem_SentencesQuery == null) {
                QueryBuilder<Sentence> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.BoxItemId.eq(null));
                boxItem_SentencesQuery = queryBuilder.build();
            }
        }
        Query<Sentence> query = boxItem_SentencesQuery.forCurrentThread();
        query.setParameter(0, boxItemId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getChineseDao().getAllColumns());
            builder.append(" FROM SENTENCE T");
            builder.append(" LEFT JOIN CHINESE T0 ON T.\"CHINESE_ID\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Sentence loadCurrentDeep(Cursor cursor, boolean lock) {
        Sentence entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Chinese chinese = loadCurrentOther(daoSession.getChineseDao(), cursor, offset);
        entity.setChinese(chinese);

        return entity;    
    }

    public Sentence loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<Sentence> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Sentence> list = new ArrayList<Sentence>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<Sentence> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Sentence> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}