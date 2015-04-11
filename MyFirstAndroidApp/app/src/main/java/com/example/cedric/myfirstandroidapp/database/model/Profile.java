package com.example.cedric.myfirstandroidapp.database.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cedric on 4/4/15.
 */
public final class Profile implements Model {

    private int id;
    private String name;
    private int age;
    private String gender;

    public Profile(){}

    public Profile(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    public final static ArrayList<String> getNames( List<Profile> profiles ){
        ArrayList<String> names = new ArrayList<String>();
        for( Profile profile : profiles ){
            names.add(profile.name);
        }
        return names;
    }

    @Override
    public String toString() {
        return "Profile [id=" + id + ", name=" + name + ", age=" + age + "gender=" + gender +"]";
    }
}
