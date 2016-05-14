package com.github.u1152.uportal.localdaoimpl;

import com.github.u1152.uportal.dao.ArticalsPropDao;
import com.github.u1152.uportal.model.ArticalsProp;
import com.github.u1152.uportal.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Илья on 20.04.2016.
 */
public class ArticalsPropDaoExampleImpl implements ArticalsPropDao {
    public ArticalsPropDaoExampleImpl() {

    }

    public void add(ArticalsProp articalsProp) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(articalsProp);
        session.getTransaction().commit();
    }

    public void delete(ArticalsProp articalsProp) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.delete(articalsProp);
        session.flush();
        session.getTransaction().commit();
    }

    public void update(ArticalsProp articalsProp) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(articalsProp);
        session.getTransaction().commit();
    }
    public List<ArticalsProp> getAllPopDesc(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query q = session.createQuery("from ArticalsProp AP GROUP BY AP.description");
        List<ArticalsProp> AllArticals = q.list();
        session.getTransaction().commit();
        return AllArticals;
    }
    public List<ArticalsProp> getAllValue(String option){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query q = session.createQuery("from ArticalsProp AP WHERE AP.description = :option").setString("option",option);
        List<ArticalsProp> AllArticals = q.list();
        session.getTransaction().commit();
        return AllArticals;
    }
    public List<ArticalsProp> getAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query q = session.createQuery("from ArticalsProp");
        List<ArticalsProp> AllArticals = q.list();
        session.getTransaction().commit();
         return AllArticals;
    }
    public ArticalsProp getById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query q = session.createQuery("from ArticalsProp A where A.id= :articals_id");
        q.setParameter("articals_id",id);
        List<ArticalsProp> Aut = q.list();
        session.getTransaction().commit();
        return Aut.get(0);
    }

}
