package edu.javacourse.spring.database;

public class Region {

    private Long regionId;
    private String regionName;

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

    @Override
    public String toString() {
        return "Region{" + "regionId=" + regionId + ", regionName=" + regionName + '}';
    }
}
