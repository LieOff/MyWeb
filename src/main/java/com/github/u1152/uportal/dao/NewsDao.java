package com.github.u1152.uportal.dao;

import com.github.u1152.uportal.model.Articals;
import com.github.u1152.uportal.model.News;

import java.util.List;

/**
 * Created by Илья on 20.04.2016.
 */
public interface NewsDao {

    void add(News news);

    void delete(News news);

    void update(News news);

    List<News> getAll();

    News getById(int id);

}
