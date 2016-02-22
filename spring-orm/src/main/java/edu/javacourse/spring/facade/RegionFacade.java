package edu.javacourse.spring.facade;

import java.util.LinkedList;
import java.util.List;
import edu.javacourse.spring.dao.RegionDAO;
import edu.javacourse.spring.entity.Region;
import edu.javacourse.spring.view.RegionView;

public class RegionFacade {
    private RegionDAO dao;

    public void setDao(RegionDAO dao) {
        this.dao = dao;
    }

    public Long addRegion(RegionView pv) {
        return dao.addRegion(createRegionFromView(pv));
    }

    public void updateRegion(RegionView pv) {
        dao.updateRegion(createRegionFromView(pv));
    }

    public void deleteRegion(RegionView pv) {
        dao.deleteRegion(dao.getRegion(pv.getRegionId()));
    }

    public RegionView getRegion(Long id) {
        return new RegionView(dao.getRegion(id));
    }

    public List<RegionView> findRegion() {
        List<RegionView> pvList = new LinkedList<RegionView>();
        List<Region> pList = dao.findRegion();
        for(Region p : pList) {
            pvList.add(new RegionView(p));
        }

        return pvList;
    }

    private Region createRegionFromView(RegionView pv) {
        Region p = new Region();
        p.setRegionId(pv.getRegionId());
        p.setRegionName(pv.getRegionName());
        return p;
    }
}
