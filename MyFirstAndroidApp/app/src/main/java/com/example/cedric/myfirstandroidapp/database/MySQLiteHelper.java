package com.example.cedric.myfirstandroidapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.cedric.myfirstandroidapp.database.model.Profile;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by cedric on 4/4/15.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "MyDB";
    // Table name
    private static final String TABLE_PROFILES = "profiles";
    // Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_AGE = "age";
    // Columns
    private static final String[] COLUMNS = {KEY_ID,KEY_NAME,KEY_AGE};

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create book table
        String CREATE_PROFILE_TABLE = "CREATE TABLE " + TABLE_PROFILES + " ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, "+
                "age INTEGER )";

        // create books table
        db.execSQL(CREATE_PROFILE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older books table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROFILES);

        // create fresh books table
        this.onCreate(db);
    }

}
