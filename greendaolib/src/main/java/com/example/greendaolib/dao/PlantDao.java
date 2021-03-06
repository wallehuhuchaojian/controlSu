package com.example.greendaolib.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.greendaolib.pojo.db.Plant;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "PLANT".
*/
public class PlantDao extends AbstractDao<Plant, Long> {

    public static final String TABLENAME = "PLANT";

    /**
     * Properties of entity Plant.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property BeLongsId = new Property(1, long.class, "beLongsId", false, "BE_LONGS_ID");
        public final static Property Name = new Property(2, String.class, "name", false, "NAME");
        public final static Property SummaryId = new Property(3, long.class, "summaryId", false, "SUMMARY_ID");
        public final static Property StatusId = new Property(4, long.class, "statusId", false, "STATUS_ID");
    };


    public PlantDao(DaoConfig config) {
        super(config);
    }
    
    public PlantDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"PLANT\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"BE_LONGS_ID\" INTEGER NOT NULL ," + // 1: beLongsId
                "\"NAME\" TEXT NOT NULL ," + // 2: name
                "\"SUMMARY_ID\" INTEGER NOT NULL ," + // 3: summaryId
                "\"STATUS_ID\" INTEGER NOT NULL );"); // 4: statusId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"PLANT\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Plant entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getBeLongsId());
        stmt.bindString(3, entity.getName());
        stmt.bindLong(4, entity.getSummaryId());
        stmt.bindLong(5, entity.getStatusId());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Plant entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getBeLongsId());
        stmt.bindString(3, entity.getName());
        stmt.bindLong(4, entity.getSummaryId());
        stmt.bindLong(5, entity.getStatusId());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Plant readEntity(Cursor cursor, int offset) {
        Plant entity = new Plant( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getLong(offset + 1), // beLongsId
            cursor.getString(offset + 2), // name
            cursor.getLong(offset + 3), // summaryId
            cursor.getLong(offset + 4) // statusId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Plant entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setBeLongsId(cursor.getLong(offset + 1));
        entity.setName(cursor.getString(offset + 2));
        entity.setSummaryId(cursor.getLong(offset + 3));
        entity.setStatusId(cursor.getLong(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Plant entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Plant entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
