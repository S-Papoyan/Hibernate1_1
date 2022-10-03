package com.util;

import com.entity.UsersEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        NativeQuery<UsersEntity> nativeQuery = session.createNativeQuery("select * from users", UsersEntity.class);
        List<UsersEntity> resultList = nativeQuery.getResultList();
        for (UsersEntity usersEntity : resultList) {
            System.out.println(usersEntity.print());
        }

        session.close();
        HibernateUtil.close();
    }
}
