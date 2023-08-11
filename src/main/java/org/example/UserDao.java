package org.example;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDao{

    private static final Logger LOGGER = Logger.getLogger(UserDao.class.getName());
    private static final SessionFactory SESSION_FACTORY;

    static {
        SESSION_FACTORY = SessionFactoryManager.getInstance().getSessionFactory();
    }

    public UserModel create(UserModel userModel) {
        LOGGER.info("create(" + userModel + ")");
        Session session = SESSION_FACTORY.openSession();
        session.getTransaction().begin();
        session.persist(userModel);
        session.getTransaction().commit();
        LOGGER.info("create(...) = " + userModel);

        return userModel;
    }

    public boolean delete(UserModel userModel){
        LOGGER.info("delete(" + userModel + ")");
        boolean deleted;

        Session session = SESSION_FACTORY.openSession();

        try {
            session.getTransaction().begin();
            session.remove(userModel);
            session.getTransaction().commit();

            deleted = true;
            return deleted;
        } catch (HibernateException e) {
            LOGGER.log(Level.SEVERE, "Error while deleting Activity", e);
            deleted = false;
            session.getTransaction().rollback();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error while deleting Activity", e);
            deleted = false;
            session.getTransaction().rollback();
        }
        LOGGER.info("delete(...) = " + userModel);
        return deleted;
    }

}
