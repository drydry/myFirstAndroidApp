package com.example.cedric.myfirstandroidapp.controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.cedric.myfirstandroidapp.database.model.Model;

/**
 * Created by cedric on 4/4/15.
 */
public abstract class AbstractController<Model> extends SQLiteOpenHelper  implements Controllable<Model> {

    // Database Version
    private static final int DATABASE_VERSION = 2;
    // Database Name
    private static final String DATABASE_NAME = "MyDB";

    public AbstractController(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void AbstractController(){

    }

    public void onCreate(SQLiteDatabase db) {
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

}
