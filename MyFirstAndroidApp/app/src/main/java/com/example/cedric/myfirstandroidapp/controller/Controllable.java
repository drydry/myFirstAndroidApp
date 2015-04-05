package com.example.cedric.myfirstandroidapp.controller;

import java.util.List;

/**
 * Created by cedric on 4/4/15.
 */
public interface Controllable<Model> {

    List<Model> index();
    Model save(Model model);
    Model get(int id);
    Model update(Model model);
    void delete(Model model);
}
