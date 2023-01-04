package com.uniyaz.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.domain.Pet;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class PetDao {

    public List<Pet> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery("select pet From Pet pet");
        List<Pet> petList = query.list();

        return petList;
    }

    public Pet save(Pet pet){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        pet = (Pet) currentSession.merge(pet);
        transaction.commit();
        return pet;
    }

    public void delete(Pet pet){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.delete(pet);
        transaction.commit();
    }
}
