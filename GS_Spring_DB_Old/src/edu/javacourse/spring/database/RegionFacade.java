/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.javacourse.spring.database;

/**
 *
 * @author ASaburov
 */
public class RegionFacade {
    
    private RegionDAO regionDAO;

    public void setRegionDAO(RegionDAO regionDAO) {
        this.regionDAO = regionDAO;
    }

    public Long addRegion(RegionView rv) {
        Region r = RegionView.fromView(rv);
        Long id = (Long)regionDAO.addEntity(r);
        return id;
    }

    public void deleteRegion(Long regionId) {
        regionDAO.deleteEntity(regionDAO.getEntity(regionId));
    }
    
    public RegionView getRegion(Long regionId) {
        return new RegionView(regionDAO.getEntity(regionId));
    }
}
