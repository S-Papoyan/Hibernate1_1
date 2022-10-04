package com.util;

import com.entity.UsersEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.io.File;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure(new File("src\\main\\resources\\hibernate.cfg.xml")).buildSessionFactory();
        } catch (Throwable e) {
            System.err.println("Initial SessionFactory creation failed: " + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void close() {
        getSessionFactory().close();
    }

    public static void save(UsersEntity users) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(users);
        session.getTransaction().commit();
    }

    public static UsersEntity getById(Integer id) {
        Session session = sessionFactory.openSession();
        NativeQuery<UsersEntity> nativeQuery = session.createNativeQuery("select  * from users where id = ?", UsersEntity.class);
        nativeQuery.setParameter(1, id);
        UsersEntity user = nativeQuery.uniqueResult();
        return user;
    }

    public static void update(UsersEntity users) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(users);
        session.getTransaction().commit();
    }

    public static void delete(UsersEntity users) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(users);
        session.getTransaction().commit();
    }
}
