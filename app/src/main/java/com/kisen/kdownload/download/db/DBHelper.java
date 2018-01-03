package com.kisen.kdownload.download.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by huangwy on 2017/12/26.
 * email: kisenhuang@163.com.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "download.db";
    private static final int VERSION = 1;
    private static final String SQL_CREATE_THREAD = "create table thread_info(" +
            "_id integer primary key autoincrement, " +
            "thread_id integer, " +
            "url text, " +
            "file_name text, " +
            "start integer, " +
            "end integer, " +
            "finished integer)";

    private static final String SQL_CREATE_FILE = "create table file_info(" +
            "_id integer primary key autoincrement, " +
            "file_id integer, " +
            "url text, " +
            "file_name text, " +
            "root_path text, " +
            "length integer, " +
            "finished integer)";

    private static final String SQL_DROP_THREAD = "drop table if exists thread_info";
    private static final String SQL_DROP_FILE = "drop table if exists file_info";

    DBHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_THREAD);
        db.execSQL(SQL_CREATE_FILE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_THREAD);
        db.execSQL(SQL_DROP_FILE);
        db.execSQL(SQL_CREATE_THREAD);
        db.execSQL(SQL_CREATE_FILE);
    }
}
