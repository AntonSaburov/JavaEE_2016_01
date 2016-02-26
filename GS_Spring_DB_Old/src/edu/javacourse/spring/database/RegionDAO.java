/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.javacourse.spring.database;

import java.io.Serializable;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 *
 * @author ASaburov
 */
public class RegionDAO {
    
    private HibernateTemplate template;

    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }
    
    public Serializable addEntity(Region region) {
        return template.save(region);
    }

    public void deleteEntity(Region region) {
        template.delete(region);
    }
    
    public Region getEntity(Long regionId) {
        return (Region)template.get(Region.class, regionId);
    }

}
