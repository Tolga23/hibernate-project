package com.uniyaz.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.domain.Rehber;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class RehberDao {

    public List<Rehber> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery("Select rehber From Rehber rehber");
        List<Rehber> rehberList = query.list();
        return rehberList;
    }

    public Rehber save(Rehber rehber) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        rehber = (Rehber) currentSession.merge(rehber);
        transaction.commit();
        return rehber;
    }

    public void delete(Rehber rehber) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.delete(rehber);
        transaction.commit();
    }
}