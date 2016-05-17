package com.github.u1152.uportal.localdaoimpl;

import com.github.u1152.uportal.dao.ArticalsDao;
import com.github.u1152.uportal.dao.NewsDao;
import com.github.u1152.uportal.model.Articals;
import com.github.u1152.uportal.model.News;
import com.github.u1152.uportal.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Илья on 20.04.2016.
 */
public class NewsDaoExampleImpl implements NewsDao {
    public NewsDaoExampleImpl() {

    }

    public void add(News news) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(news);
        session.getTransaction().commit();
    }

    public void delete(News news) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(news);
        session.flush();
        session.getTransaction().commit();
    }

    public void update(News news) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(news);
        session.getTransaction().commit();
    }

    public List<News> getAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query q = session.createQuery("from News");
        List<News> AllNews = q.list();
        session.getTransaction().commit();
         return AllNews;
    }
    public News getById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        System.out.print("Начали");
        Query q = session.createQuery("from News where id= :news_id");
        q.setParameter("news_id",id);
        List<News> newses = q.list();
        System.out.print("Получили");
        session.getTransaction().commit();
        return newses.get(0);
    }

}
