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

//        UsersEntity user = new UsersEntity(0, "Armen", "Poghosyan", 25, "Armen@mail.ru", "123456", "12345");
//        HibernateUtil.save(user);

        UsersEntity user2 = HibernateUtil.getById(29);
        user2.setLast_name("Kirakosyan");
        HibernateUtil.update(user2);


    }


}
