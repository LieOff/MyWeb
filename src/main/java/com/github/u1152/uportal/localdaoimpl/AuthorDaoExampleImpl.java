package com.github.u1152.uportal.localdaoimpl;

import com.github.u1152.uportal.dao.AuthorDao;
import com.github.u1152.uportal.model.Author;

import java.util.*;

/**
 * author Aleksandr
 */
public class AuthorDaoExampleImpl implements AuthorDao{
    private static final Random r = new Random();
    private static final Map<Integer, Author> AUTHOR_MAP = new HashMap<Integer, Author>();
    public static final String IMAGE = "img/placeholders/avatar.jpg";


    public AuthorDaoExampleImpl() {
        AUTHOR_MAP.put(0, new Author(0, "Ivan", "Ivanovich", "Ivanov", "ivan@u1152.ru", IMAGE));
        AUTHOR_MAP.put(1, new Author(1, "Petr", "P", "Petrov", "petr@u1152.ru", IMAGE));
        AUTHOR_MAP.put(2, new Author(2, "Sergey", "S", "Sergeev", "sergeev@u1152.ru", IMAGE));
        AUTHOR_MAP.put(3, new Author(3, "Fedor", "F", "Fedorov", "fedorov@u1152.ru", IMAGE));
    }

    public void add(Author author) {
        author.setId(r.nextInt(Integer.MAX_VALUE));
        author.setImage(IMAGE);
        AUTHOR_MAP.put(author.getId(), author);
    }

    public void delete(Author author) {
        AUTHOR_MAP.remove(author.getId());
    }

    public void update(Author author) {
        if (AUTHOR_MAP.containsKey(author.getId())) {
            author.setImage(IMAGE);
            AUTHOR_MAP.put(author.getId(), author);
        }
    }

    public List<Author> getAll() {
        return new ArrayList<>(AUTHOR_MAP.values());
    }

    public Author getById(int id) {
        return AUTHOR_MAP.get(id);
    }
}
