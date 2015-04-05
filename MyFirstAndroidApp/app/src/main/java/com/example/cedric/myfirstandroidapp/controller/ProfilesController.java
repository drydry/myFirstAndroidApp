package com.example.cedric.myfirstandroidapp.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.cedric.myfirstandroidapp.database.model.Gender;
import com.example.cedric.myfirstandroidapp.database.model.Profile;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by cedric on 4/4/15.
 */
public class ProfilesController extends AbstractController<Profile> {

    // Table name
    private static final String TABLE_PROFILES = "profiles";
    // Columns names
    private static final String KEY_ID      = "id";
    private static final String KEY_NAME    = "name";
    private static final String KEY_AGE     = "age";
    private static final String KEY_GENDER  = "gender";

    // Columns
    private static final String[] COLUMNS = {KEY_ID, KEY_NAME, KEY_AGE, KEY_GENDER};

    public ProfilesController(Context context) {
        super(context);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create book table
        String CREATE_PROFILE_TABLE = "CREATE TABLE " + TABLE_PROFILES + " ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, "+
                "age INTEGER, "+
                "gender TEXT )";

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


    @Override
    public List<Profile> index() {
        List<Profile> profiles = new LinkedList<Profile>();

        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_PROFILES;

        // 2. get reference to writable DB
        SQLiteDatabase db = super.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // 3. go over each row, build profile and add it to list
        Profile profile = null;
        if (cursor.moveToFirst()) {
            do {
                profile = new Profile();
                profile.setId(Integer.parseInt(cursor.getString(0)));
                profile.setName(cursor.getString(1));
                profile.setAge(cursor.getInt(2));
                profile.setGender(cursor.getString(3));

                // Add profile to profiles
                profiles.add(profile);
            } while (cursor.moveToNext());
        }

        Log.d("getAllProfiles()", profiles.toString());

        // return profiles
        return profiles;
    }

    @Override
    public Profile save(Profile profile) {
        //for logging
        Log.d("addProfile", profile.toString());

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, profile.getName()); // get name
        values.put(KEY_AGE, profile.getAge()); // get age
        values.put(KEY_GENDER, profile.getGender()); // get gender

        // 3. insert
        db.insert(TABLE_PROFILES, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values

        // 4. close
        db.close();

        return profile;
    }

    @Override
    public Profile get(int id) {
        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor cursor =
                db.query(TABLE_PROFILES, // a. table
                        COLUMNS, // b. column names
                        " id = ?", // c. selections
                        new String[] { String.valueOf(id) }, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        // 4. build profile object
        Profile profile = new Profile();
        profile.setId(Integer.parseInt(cursor.getString(0)));
        profile.setName(cursor.getString(1));
        profile.setAge(cursor.getInt(2));
        profile.setGender(cursor.getString(3));

        //log
        Log.d("getProfile(" + id + ")", profile.toString());

        // 5. return profile
        return profile;

    }

    @Override
    public Profile update(Profile profile) {
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, profile.getName()); // get name
        values.put(KEY_AGE, profile.getAge()); // get age
        values.put(KEY_GENDER, profile.getGender()); // get gender

        // 3. updating row
        int i = db.update(TABLE_PROFILES, //table
                values, // column/value
                KEY_ID+" = ?", // selections
                new String[] { String.valueOf(profile.getId()) }); //selection args

        // 4. close
        db.close();

        //log
        Log.d("updateProfile", profile.toString());

        return profile;
    }

    @Override
    public void delete(Profile profile) {
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. delete
        db.delete(TABLE_PROFILES, //table name
                KEY_ID+" = ?",  // selections
                new String[] { String.valueOf(profile.getId()) }); //selections args

        // 3. close
        db.close();

        //log
        Log.d("deleteProfile", profile.toString());

    }
}
