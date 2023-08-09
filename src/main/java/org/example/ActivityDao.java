package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.logging.Logger;

public class ActivityDao {

    private static final Logger LOGGER = Logger.getLogger(ActivityDao.class.getName());
// TODO: 09.08.2023 tu??
    //SessionManager sessionManager = SessionManager.getSessionManager();

//    private SessionFactory sessionFactory;
//
//    public ActivityDao() {
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

    public ActivityModel create(ActivityModel activityModel) {
        LOGGER.info("create(" + activityModel + ")");
        // TODO: 09.08.2023 czy tu??
        SessionManager sessionManager = SessionManager.getSessionManager();
        //Session session = sessionFactory.openSession();
        Session session = sessionManager.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.persist(activityModel);
        session.getTransaction().commit();
        LOGGER.info("create(...) = " + activityModel);

        return activityModel;
    }

    public ActivityModel read(Long id){
        LOGGER.info("read(" + id + ")");
        SessionManager sessionManager = SessionManager.getSessionManager();
        //Session session = sessionFactory.openSession();
        Session session = sessionManager.getSessionFactory().openSession();
        session.getTransaction().begin();
        ActivityModel activityModel = session.get(ActivityModel.class, id);
        session.getTransaction().commit();
        LOGGER.info("read(...) = " + activityModel);

        return activityModel;
    }

    public ActivityModel update(ActivityModel activityModel){
        LOGGER.info("update(" + activityModel + ")");
        SessionManager sessionManager = SessionManager.getSessionManager();
        Session session = sessionManager.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.merge(activityModel);
        session.getTransaction().commit();
        LOGGER.info("update(...) = " + activityModel);

        return activityModel;
    }
}