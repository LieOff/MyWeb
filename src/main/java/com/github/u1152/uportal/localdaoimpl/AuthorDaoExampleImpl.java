package com.github.u1152.uportal.localdaoimpl;

import com.github.u1152.uportal.dao.AuthorDao;
import com.github.u1152.uportal.model.Author;
import com.github.u1152.uportal.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * author Aleksandr
 */

public class AuthorDaoExampleImpl implements AuthorDao{
    private static final Random r = new Random();
    private static final Map<Integer, Author> AUTHOR_MAP = new HashMap<Integer, Author>();
    public static final String IMAGE = "img/placeholders/avatar.jpg";

    public AuthorDaoExampleImpl() {

    }

    public void add(Author author) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //author.setId(r.nextInt(Integer.MAX_VALUE));
        author.setImage(IMAGE);
        //AUTHOR_MAP.put(author.getId(), author);
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
    }

    public void delete(Author author) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(author);
        session.flush();
        session.getTransaction().commit();
    }

    public void update(Author author) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        //author = (Author) session.merge(author);
        session.update(author);
        session.getTransaction().commit();
    }

    public List<Author> getAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query q = session.createQuery("from Author");
        List<Author> AllAuthors = q.list();
        session.getTransaction().commit();
        return AllAuthors;
    }

    public Author getById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query q = session.createQuery("from Author A where A.id= :author_id");
        q.setParameter("author_id",id);
        List<Author> Aut = q.list();
        session.getTransaction().commit();
        return Aut.get(0);
    }
}
