package com.example.cedric.myfirstandroidapp.controller;

import android.database.sqlite.SQLiteOpenHelper;

import com.example.cedric.myfirstandroidapp.database.model.Model;

/**
 * Created by cedric on 4/4/15.
 */
public interface Controllable {

    void index();
    void save(Model model);
    void get(Model model);
    void update(Model model);
    void delete(Model model);
}
