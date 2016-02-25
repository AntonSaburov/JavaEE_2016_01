package edu.javacourse.jpa.manager;

import edu.javacourse.jpa.entity.Region;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RegionManager {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("GS_JPA_FirstPU1");
        System.out.println(entityManagerFactory.getClass().getSimpleName());
        entityManager = entityManagerFactory.createEntityManager();
        System.out.println(entityManager.getClass().getSimpleName());
    }
    
    public void finish() {
        entityManager.close();
        entityManagerFactory.close();
    }

    public List<Region> getRegionList() {
        List result = entityManager.createQuery("select r from Region r").getResultList();
        return result;
    }

    public Region getRegion(Integer regionId) {
        return entityManager.find(Region.class, 1);
    }

    public void addRegion(Region region) {
        entityManager.getTransaction().begin();
        entityManager.persist(region);
        entityManager.getTransaction().commit();
    }

    public void updateRegion(Region region) {
        entityManager.getTransaction().begin();
        entityManager.merge(region);
        entityManager.getTransaction().commit();
    }

    public void deleteRegion(Region region) {
        entityManager.getTransaction().begin();
        entityManager.remove(region);
        entityManager.getTransaction().commit();
    }

}
