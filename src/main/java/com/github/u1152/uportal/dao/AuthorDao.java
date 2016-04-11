package com.github.u1152.uportal.dao;

import com.github.u1152.uportal.model.Author;

import java.util.List;

/**
 * author Aleksandr
 */
public interface AuthorDao {

    void add(Author author);

    void delete(Author author);

    void update(Author author);

    List<Author> getAll();

    Author getById(int id);
}
