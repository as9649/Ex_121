package com.example.ex_121;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class HelperDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "dbexam.db";
    private static final int DATABASE_VERSION = 1;
    String strCreate, strDelete;
    public HelperDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        strCreate = "CREATE TABLE " + Students.TABLE_USERS;
        strCreate += " (" + Students.KEY_ID + " INTEGER PRIMARY KEY,";
        strCreate += " " + Students.NAME + " TEXT,";
        strCreate += " " + Students.ACTIVE + " TEXT,";
        strCreate += " " + Students.ADDRESS + " TEXT,";
        strCreate += " " + Students.PHONE_NUMBER + " TEXT,";
        strCreate += " " + Students.HOME_PHONE + " TEXT,";
        strCreate += " " + Students.MOM + " TEXT,";
        strCreate += " " + Students.DAD + " TEXT,";
        strCreate += " " + Students.MOM_PHONE + " TEXT,";
        strCreate += " " + Students.DAD_PHONE + " TEXT";
        strCreate += ");";
        db.execSQL(strCreate);

        strCreate = "CREATE TABLE " + Grades.TABLE_GRADES;
        strCreate += " (" + Students.KEY_ID + " INTEGER PRIMARY KEY,";
        strCreate += " " + Students.NAME + " TEXT,";
        strCreate += " " + Grades.SUBJECT + " TEXT,";
        strCreate += " " + Grades.QUARTER_1 + " INTEGER,";
        strCreate += " " + Grades.QUARTER_2 + " INTEGER,";
        strCreate += " " + Grades.QUARTER_3 + " INTEGER,";
        strCreate += " " + Grades.QUARTER_4 + " INTEGER";
        strCreate += ");";
        db.execSQL(strCreate);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {

        strDelete="DROP TABLE IF EXISTS "+Students.TABLE_USERS;
        db.execSQL(strDelete);
        strDelete="DROP TABLE IF EXISTS "+Grades.TABLE_GRADES;
        db.execSQL(strDelete);

        onCreate(db);
    }

}

