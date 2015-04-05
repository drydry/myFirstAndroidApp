package com.example.cedric.myfirstandroidapp.database.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by cedric on 4/5/15.
 */
public class Gender {
    public final static String MALE = "Male";
    public final static String FEMALE = "Female";
    public final static List<String> GENDER_VALUES = Collections.unmodifiableList(Arrays.asList(MALE, FEMALE));
}
