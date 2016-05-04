package com.github.u1152.uportal.localdaoimpl;

import com.github.u1152.uportal.dao.ArticalsDao;
import com.github.u1152.uportal.model.Articals;
import com.github.u1152.uportal.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Илья on 20.04.2016.
 */
public class ArticalsDaoExampleImpl implements ArticalsDao {
    public ArticalsDaoExampleImpl() {

    }

    public void add(Articals articals) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(articals);
        session.getTransaction().commit();
    }

    public void delete(Articals articals) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.delete(articals);
        session.flush();
        session.getTransaction().commit();
    }

    public void update(Articals articals) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(articals);
        session.getTransaction().commit();
    }

    public List<Articals> getAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query q = session.createQuery("from Articals");
        List<Articals> AllArticals = q.list();
        session.getTransaction().commit();
         return AllArticals;
    }
    public Articals getById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query q = session.createQuery("from Articals A where A.id= :articals_id");
        q.setParameter("articals_id",id);
        List<Articals> Aut = q.list();
        session.getTransaction().commit();
        return Aut.get(0);
    }

}
