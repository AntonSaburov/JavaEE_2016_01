package edu.javacourse.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "jc_region")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "regiongen")
    @SequenceGenerator(name = "regiongen", sequenceName = "jc_region_region_id_seq")
    @Column(name = "region_id")
    private Long regionId;
    @Column(name = "region_name")
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
}
