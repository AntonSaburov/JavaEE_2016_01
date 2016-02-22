package edu.javacourse.spring.dao;

import java.util.List;
import org.springframework.orm.hibernate5.HibernateTemplate;
import edu.javacourse.spring.entity.Region;

public class RegionDAOImpl implements RegionDAO {

    private HibernateTemplate template;

    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    @Override
    public Long addRegion(Region p) {
        return (Long)template.save(p);
    }

    @Override
    public void updateRegion(Region p) {
        template.saveOrUpdate(p);
    }

    @Override
    public void deleteRegion(Region p) {
        template.delete(p);
    }

    @Override
    public Region getRegion(Long id) {
        return (Region) template.load(Region.class, id);
    }

    @Override
    public List findRegion() {
        return template.find("FROM Region");
    }
}
