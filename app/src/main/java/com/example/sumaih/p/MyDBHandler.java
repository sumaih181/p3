package com.example.sumaih.p;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Created by sumaih on 03/04/2018 AD. */
public class MyDBHandler extends SQLiteOpenHelper { //DB info
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "info.db"; //Tables and its columns
    public static final String TABLE_NAME = "tblAMIGO";
    public static final String COLUMN_SERVICE = "service";
    public static final String COLUMN_USER = "user";
    public static final String COLUMN_PASSWORD = "password";

    public MyDBHandler(Context context) {
//Create a helper object to create, open, and/or manage a database
        super(context, DATABASE_NAME, null, DATABASE_VERSION); }
        @Override
    public void onCreate(SQLiteDatabase db) {
// A SQL statement to create a table of three columns
        String sqlStmt = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_SERVICE +
                " TEXT PRIMARY KEY  ," + COLUMN_USER + " TEXT," +
                COLUMN_PASSWORD + " TEXT " + ");"; db.execSQL(sqlStmt); }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    Log.d("DB", "The table has been removed!"); onCreate(db); }



       }