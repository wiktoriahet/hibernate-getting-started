package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.logging.Logger;

public class SessionManager {

    private static final Logger LOGGER = Logger.getLogger(SessionManager.class.getName());
    private SessionFactory sessionFactory;
    private static SessionManager sessionManager = null;

    private SessionManager() {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        try {
            sessionFactory = new MetadataSources(serviceRegistry)
                    .buildMetadata()
                    .buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
        }
    }

    public static SessionManager getSessionManager(){
        LOGGER.info("getSessionFactory()");
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        LOGGER.info("getSessionFactory(...)");
        return sessionManager;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
