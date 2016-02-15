package edu.javacourse.crm.dao;

import java.io.Serializable;

import edu.javacourse.crm.entity.CrmProducer;
import edu.javacourse.crm.entity.CrmProduct;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicDAO
{
    private static final Logger log = LoggerFactory.getLogger(BasicDAO.class);

    public static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    public static void init() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public Serializable addEntity(Object entity) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Serializable id = session.save(entity);
        session.getTransaction().commit();
        return id;
    }

    public void updateEntity(Object entity) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(entity);
        session.getTransaction().commit();
    }

    public void deleteEntity(Object entity) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
    }

    public Object getEntity(Class clazz, Serializable entityId) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Object entity = session.get(clazz, entityId);
        session.getTransaction().commit();
        return entity;
    }

/*
    public Serializable addProducer(CrmProducer producer) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Serializable id = session.save(producer);

        session.getTransaction().commit();
        return id;
    }
*/
    public void testMany() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        for(int i=0; i<10; i++) {
            CrmProduct product = new CrmProduct();
            product.setProductName("Product " + i);
            session.save(product);
            session.flush();
            log.info("TEST:{}", i);
        }

        session.getTransaction().commit();
    }

}