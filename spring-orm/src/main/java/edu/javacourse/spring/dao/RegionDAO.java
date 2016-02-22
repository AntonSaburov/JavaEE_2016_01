package edu.javacourse.spring.dao;

import java.util.List;
import edu.javacourse.spring.entity.Region;

public interface RegionDAO {

    public Long addRegion(Region p);

    public void updateRegion(Region p);

    public void deleteRegion(Region p);

    public Region getRegion(Long id);

    public List<Region> findRegion();
}
