package edu.javacourse.jpa;

import edu.javacourse.jpa.entity.Region;
import edu.javacourse.jpa.manager.RegionManager;
import java.util.List;

public class SimpleExample {

    public static void main(String[] args) {
        RegionManager rm = new RegionManager();
        rm.init();
        for(int i=0; i<10; i++){
            addRegion(rm);
        }
        firstSelect(rm);
        rm.finish();
    }

    private static void addRegion(RegionManager rm) {
        System.out.println("First Add ===>");
        Region r = new Region();
        r.setRegionName("Region:" + System.currentTimeMillis());
        rm.addRegion(r);
    }
    
    private static void firstSelect(RegionManager rm) {
        System.out.println("First Select ===>");
        List<Region> result = rm.getRegionList();
        for(Region r : result) {
            System.out.println(r);
        }
    }
}
