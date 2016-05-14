package com.github.u1152.uportal.dao;

import com.github.u1152.uportal.model.ArticalsProp;

import java.util.List;

/**
 * Created by Илья on 20.04.2016.
 */
public interface ArticalsPropDao {

    void add(ArticalsProp articalsProp);

    void delete(ArticalsProp articalsProp);

    void update(ArticalsProp articalsProp);

    List<ArticalsProp> getAll();

    List<ArticalsProp> getAllPopDesc();

    List<ArticalsProp> getAllValue(String option);

    ArticalsProp getById(int id);

}
