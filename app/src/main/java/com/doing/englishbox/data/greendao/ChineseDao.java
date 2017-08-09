package com.doing.englishbox.data.greendao;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import com.doing.englishbox.data.entity.Chinese;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CHINESE".
*/
public class ChineseDao extends AbstractDao<Chinese, Long> {

    public static final String TABLENAME = "CHINESE";

    /**
     * Properties of entity Chinese.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property BoxItemId = new Property(1, Long.class, "boxItemId", false, "BOX_ITEM_ID");
        public final static Property Content = new Property(2, String.class, "content", false, "CONTENT");
    }

    private Query<Chinese> boxItem_ChineseQuery;

    public ChineseDao(DaoConfig config) {
        super(config);
    }
    
    public ChineseDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CHINESE\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"BOX_ITEM_ID\" INTEGER," + // 1: boxItemId
                "\"CONTENT\" TEXT NOT NULL );"); // 2: content
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CHINESE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Chinese entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long boxItemId = entity.getBoxItemId();
        if (boxItemId != null) {
            stmt.bindLong(2, boxItemId);
        }
        stmt.bindString(3, entity.getContent());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Chinese entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long boxItemId = entity.getBoxItemId();
        if (boxItemId != null) {
            stmt.bindLong(2, boxItemId);
        }
        stmt.bindString(3, entity.getContent());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Chinese readEntity(Cursor cursor, int offset) {
        Chinese entity = new Chinese( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // boxItemId
            cursor.getString(offset + 2) // content
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Chinese entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setBoxItemId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setContent(cursor.getString(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Chinese entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Chinese entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Chinese entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "chinese" to-many relationship of BoxItem. */
    public List<Chinese> _queryBoxItem_Chinese(Long boxItemId) {
        synchronized (this) {
            if (boxItem_ChineseQuery == null) {
                QueryBuilder<Chinese> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.BoxItemId.eq(null));
                boxItem_ChineseQuery = queryBuilder.build();
            }
        }
        Query<Chinese> query = boxItem_ChineseQuery.forCurrentThread();
        query.setParameter(0, boxItemId);
        return query.list();
    }

}
