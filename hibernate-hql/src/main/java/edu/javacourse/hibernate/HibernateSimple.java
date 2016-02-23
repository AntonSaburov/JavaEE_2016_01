package edu.javacourse.hibernate;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateSimple {

    private SessionFactory sessionFactory;

    public void init() {
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        try {
            sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
        }
    }

    private void destroy() {
        sessionFactory.close();
    }

    public static void main(String[] args) {
        HibernateSimple hs = new HibernateSimple();
        hs.init();

        Session s = hs.sessionFactory.getCurrentSession();
        s.beginTransaction();
        Query q = s.createQuery("from Region as r inner join fetch r.cityList order by r.regionName");
        //q.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

        List<Region> regionList = q.list();
        for (Region r : regionList) {
            System.out.println("Region name:" + r);
            for (City c : r.getCityList()) {
                System.out.println("     City name:" + c);
            }
        }

//        arbitraryHQL1(s);
//        arbitraryHQL2(s);

        s.getTransaction().commit();

        hs.destroy();
    }

    private static void arbitraryHQL1(Session s) {
        Query q = s.createQuery("from Region as r inner join fetch r.cityList as c inner join c.region as r2 order by r.regionName");

        List regionList = q.list();
        for (Object obj1 : regionList) {
            System.out.println("Obj1:" + obj1.getClass().getSimpleName());
            Object[] array = (Object[]) obj1;
            for (Object obj2 : array) {
                System.out.println("Obj2:" + obj2.getClass().getSimpleName());
                Region r = (Region) obj2;
                System.out.println("Region:" + r);
            }
        }
    }

    private static void arbitraryHQL2(Session s) {
        Query q = s.createQuery("from Region as r inner join fetch r.cityList as c inner join c.region as r2 order by r.regionName");
        q.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

        List<Region> regionList = q.list();
        for (Region r : regionList) {
            System.out.println("Region name:" + r);
            for (City c : r.getCityList()) {
                System.out.println("     City name:" + c);
            }
        }
    }
}
