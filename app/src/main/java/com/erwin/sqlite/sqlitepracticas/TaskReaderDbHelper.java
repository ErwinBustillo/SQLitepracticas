package com.erwin.sqlite.sqlitepracticas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by erwin on 3/4/2018.
 */

public class TaskReaderDbHelper extends SQLiteOpenHelper {


    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "tasks.db";

    // constants
    private static final String TEXT_TYPE = " TEXT";
    private static final String DATE_TYPE = " DATE";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TaskReaderContract.FeedEntry.TABLE_NAME + " (" +
                    TaskReaderContract.FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    TaskReaderContract.FeedEntry.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                    TaskReaderContract.FeedEntry.COLUMN_NAME_DESCRIPTION + TEXT_TYPE + COMMA_SEP+
                    TaskReaderContract.FeedEntry.COLUMN_NAME_DATE + DATE_TYPE  + " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TaskReaderContract.FeedEntry.TABLE_NAME;

    public TaskReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
