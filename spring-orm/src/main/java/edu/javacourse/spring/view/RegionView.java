package edu.javacourse.spring.view;

import edu.javacourse.spring.entity.Region;

public class RegionView {

    private Long regionId;
    private String regionName;

    public RegionView() {
    }

    public RegionView(Region p) {
        this.regionId = p.getRegionId();
        this.regionName = p.getRegionName();
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
}
