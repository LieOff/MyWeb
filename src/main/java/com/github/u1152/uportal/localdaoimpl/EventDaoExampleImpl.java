package com.github.u1152.uportal.localdaoimpl;

import com.github.u1152.uportal.dao.EventDao;

import com.github.u1152.uportal.model.Event;
import com.github.u1152.uportal.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Илья on 20.04.2016.
 */
public class EventDaoExampleImpl implements EventDao {
    public EventDaoExampleImpl() {

    }

    public void add(Event event) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(event);
        session.getTransaction().commit();
    }

    public void delete(Event event) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(event);
        session.flush();
        session.getTransaction().commit();
    }

    public void update(Event event) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(event);
        session.getTransaction().commit();
    }

    public List<Event> getAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query q = session.createQuery("from Event");
        List<Event> AllNews = q.list();
        session.getTransaction().commit();
         return AllNews;
    }
    public Event getById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        System.out.print("Начали");
        Query q = session.createQuery("from Event where id= :news_id");
        q.setParameter("news_id",id);
        List<Event> newses = q.list();
        System.out.print("Получили");
        session.getTransaction().commit();
        return newses.get(0);
    }

}
