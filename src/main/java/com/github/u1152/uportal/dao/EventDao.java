package com.github.u1152.uportal.dao;

import com.github.u1152.uportal.model.Event;


import java.util.List;

/**
 * Created by Илья on 20.04.2016.
 */
public interface EventDao {

    void add(Event event);

    void delete(Event event);

    void update(Event event);

    List<Event> getAll();

    Event getById(int id);

}
