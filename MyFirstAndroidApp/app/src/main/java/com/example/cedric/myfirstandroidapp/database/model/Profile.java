package com.example.cedric.myfirstandroidapp.database.model;

/**
 * Created by cedric on 4/4/15.
 */
public final class Profile implements Model {

    private int id;
    private String name;
    private int age;

    public Profile(){}

    public Profile(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Profile [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
