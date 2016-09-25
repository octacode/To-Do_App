package com.example.kumarshashwat.Any_Do;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Data extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="Shasha";
    public static final String KEY_ID="id";
    public static final String KEY_TASK="task";
    public static final String TABLE_TASK="shasha";
    public Data(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists shasha(task text,id integer primary key)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_TASK);
        onCreate(db);
    }

    public void myInsert(ContentValues cv){

        getWritableDatabase().insert("shasha", null, cv);
    }

    public Cursor mySelect() {
        Cursor c = getReadableDatabase().rawQuery("Select * from shasha", null);
        return c;
    }

}
