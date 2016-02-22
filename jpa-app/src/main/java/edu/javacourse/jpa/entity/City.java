package edu.javacourse.jpa.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "jc_city")
public class City implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "citygen")
    @SequenceGenerator(name = "citygen", sequenceName = "jc_city_city_id_seq")
    @Column(name = "city_id")
    private Long cityId;
    @Column(name = "city_name")
    private String cityName;
    @JoinColumn(name = "region_id", referencedColumnName = "region_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Region regionId;

    public City() {
    }

    public City(Long cityId) {
        this.cityId = cityId;
    }

    public City(Long cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Region getRegionId() {
        return regionId;
    }

    public void setRegionId(Region regionId) {
        this.regionId = regionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cityId != null ? cityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof City)) {
            return false;
        }
        City other = (City) object;
        if ((this.cityId == null && other.cityId != null) || (this.cityId != null && !this.cityId.equals(other.cityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.javacourse.jpa.entity.City[ cityId=" + cityId + " ]";
    }
}
