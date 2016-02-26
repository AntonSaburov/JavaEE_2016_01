/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.javacourse.spring.database;

/**
 *
 * @author ASaburov
 */
class RegionView {

    private Long regionId;
    private String regionName;

    public RegionView() {
    }

    public RegionView(Region region) {
        this.regionId = region.getRegionId();
        this.regionName = region.getRegionName();
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public static Region fromView(RegionView rv) {
        Region region = new Region();
        region.setRegionId(rv.getRegionId());
        region.setRegionName(rv.getRegionName());
        return region;
    }
}
