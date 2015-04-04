package com.example.cedric.myfirstandroidapp.myprofile;

import android.media.Image;

/**
 * Created by cedric on 4/4/15.
 */
public class MyProfile {

    private String name;
    private int age;
    private Image image;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * Instanciation of the Profile.
     * @param name name
     * @param age age
     */
    public MyProfile(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Instanciation of the Profile.
     * @param name name
     * @param age age
     * @param image image
     */
    public MyProfile(String name, int age, Image image){
        this.name = name;
        this.age = age;
        this.image = image;
    }
}
