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

    /**
     * Insert a profile in the table
     * @param profile the profile.
     */
    public Profile addProfile(Profile profile){
        //for logging
        Log.d("addProfile", profile.toString());

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, profile.getName()); // get name
        values.put(KEY_AGE, profile.getAge()); // get age

        // 3. insert
        db.insert(TABLE_PROFILES, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values

        // 4. close
        db.close();

        return profile;
    }

    /**
     *  Return a profile, based on its id.
     * @param id id of the searched profile
     * @return the profile.
     */
    public Profile getProfile(int id){

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

        //log
        Log.d("getProfile(" + id + ")", profile.toString());

        // 5. return profile
        return profile;
    }

    /**
     * Return all existing profiles in a List.
     * @return the profiles.
     */
    public List<Profile> getAllBooks() {
        List<Profile> profiles = new LinkedList<Profile>();

        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_PROFILES;

        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // 3. go over each row, build profile and add it to list
        Profile profile = null;
        if (cursor.moveToFirst()) {
            do {
                profile = new Profile();
                profile.setId(Integer.parseInt(cursor.getString(0)));
                profile.setName(cursor.getString(1));
                profile.setAge(cursor.getInt(2));

                // Add profile to profiles
                profiles.add(profile);
            } while (cursor.moveToNext());
        }

        Log.d("getAllProfiles()", profiles.toString());

        // return profiles
        return profiles;
    }

    /**
     * Update a profile by its id
     * @param profile the profile to update
     * @return the updated profile
     */
    public int updateProfile(Profile profile) {

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put("name", profile.getName()); // get name
        values.put("age", profile.getAge()); // get age

        // 3. updating row
        int i = db.update(TABLE_PROFILES, //table
                values, // column/value
                KEY_ID+" = ?", // selections
                new String[] { String.valueOf(profile.getId()) }); //selection args

        // 4. close
        db.close();

        //log
        Log.d("updateProfile", profile.toString());

        return i;
    }

    /**
     * Delete a profile
     * @param profile the profile to delete
     */
    public void deleteProfile(Profile profile) {

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
