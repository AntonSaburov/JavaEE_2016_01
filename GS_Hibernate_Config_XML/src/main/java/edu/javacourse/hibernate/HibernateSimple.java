package edu.javacourse.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;
import java.util.List;

/**
 * Простой пример работы с программно загружаемой конфигурацией и мапингом в виде XML
 *
 * @author ASaburov
 */
public class HibernateSimple {

    public static void main(String[] args) {
        HibernateSimple hs = new HibernateSimple();


        Session s = hs.getSessionFactory().getCurrentSession();
        s.beginTransaction();

        Region r1 = new Region("Region One");
        Serializable rId1 = s.save(r1);
        Region r2 = new Region("region Tow");
        Serializable rId2 = s.save(r2);
        s.delete(r1);

        List<Region> regionList = s.createQuery("from Region").list();
        s.getTransaction().commit();

        for (Region r : regionList) {
            System.out.println("Region name:" + r.getRegionName());
        }
    }

    private SessionFactory getSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }
}
