package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class UserDao{

    private static final Logger LOGGER = Logger.getLogger(UserDao.class.getName());

//    private SessionFactory sessionFactory;
//
//    public UserDao() {
//        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                .configure("hibernate.cfg.xml")
//                .build();
//
//        try {
//            sessionFactory = new MetadataSources(serviceRegistry)
//                    .buildMetadata()
//                    .buildSessionFactory();
//        } catch (Exception e) {
//            e.printStackTrace();
//            StandardServiceRegistryBuilder.destroy(serviceRegistry);
//        }
//    }

    public UserModel create(UserModel userModel) {
        LOGGER.info("create(" + userModel + ")");
        SessionManager sessionManager = SessionManager.getSessionManager();
        Session session = sessionManager.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.persist(userModel);
        session.getTransaction().commit();
        LOGGER.info("create(...) = " + userModel);

        return userModel;
    }

}
