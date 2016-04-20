package com.github.u1152.uportal.dao;

import com.github.u1152.uportal.model.Articals;

import java.util.List;

/**
 * Created by Илья on 20.04.2016.
 */
public interface ArticalsDao {

    void add(Articals articals);

    void delete(Articals articals);

    void update(Articals articals);

    List<Articals> getAll();

    Articals getById(int id);

}
