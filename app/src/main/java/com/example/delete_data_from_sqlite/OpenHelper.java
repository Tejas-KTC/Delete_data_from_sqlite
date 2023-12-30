package com.example.delete_data_from_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class OpenHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "data";
    private static final int DB_VERSION = 1;
    public static final String DB_TABLE_NAME = "course_data";
    public static final String ID_COL = "id";
    public static final String NAME = "name";
    public static final String CO_NAME = "co_name";

    public OpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + DB_TABLE_NAME
                + " (" + ID_COL + " INTEGER PRIMARY KEY ,"
                + NAME + " TEXT,"
                + CO_NAME + " TEXT)";

        db.execSQL(query);
    }

    public void add_data(String name,String co_name){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(NAME,name);
        values.put(CO_NAME,co_name);

        db.insert(DB_TABLE_NAME,null,values);
        db.close();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+DB_TABLE_NAME);
        onCreate(db);
    }
}
