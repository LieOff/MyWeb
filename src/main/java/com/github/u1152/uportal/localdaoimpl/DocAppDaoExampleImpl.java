package com.github.u1152.uportal.localdaoimpl;

import com.github.u1152.uportal.dao.DocAppDao;
import com.github.u1152.uportal.dao.NewsDao;
import com.github.u1152.uportal.model.DocApp;
import com.github.u1152.uportal.model.News;
import com.github.u1152.uportal.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Илья on 20.04.2016.
 */
public class DocAppDaoExampleImpl implements DocAppDao {
    public DocAppDaoExampleImpl() {

    }

    public void add(DocApp docApp) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(docApp);
        session.getTransaction().commit();
    }

    public void delete(DocApp docApp) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.delete(docApp);
        session.flush();
        session.getTransaction().commit();
    }

    public void update(DocApp docApp) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(docApp);
        session.getTransaction().commit();
    }

    public List<DocApp> getAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query q = session.createQuery("from DocApp");
        List<DocApp> AllNews = q.list();
        session.getTransaction().commit();
         return AllNews;
    }
    public DocApp getById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query q = session.createQuery("from DocApp A where A.id= :news_id");
        q.setParameter("news_id",id);
        List<DocApp> Aut = q.list();
        session.getTransaction().commit();
        return Aut.get(0);
    }

}
