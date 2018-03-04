package com.erwin.sqlite.sqlitepracticas;

import android.provider.BaseColumns;

/**
 * Created by erwin on 3/4/2018.
 */

public class TaskReaderContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private TaskReaderContract() {}

    /* Inner class that defines the table contents */
    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "tasks";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
        public static final String COLUMN_NAME_DATE = "date";

    }
}

