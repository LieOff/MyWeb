package com.github.u1152.uportal.dao;

import com.github.u1152.uportal.model.DocApp;
import com.github.u1152.uportal.model.News;

import java.util.List;

/**
 * Created by Илья on 20.04.2016.
 */
public interface DocAppDao {

    void add(DocApp docApp);

    void delete(DocApp docApp);

    void update(DocApp docApp);

    List<DocApp> getAll();

    DocApp getById(int id);

}
