package edu.javacourse.spring;

import edu.javacourse.spring.facade.RegionFacade;
import edu.javacourse.spring.view.RegionView;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExampleMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"RegionExample.xml","RegionDatabase.xml"});
        
        RegionFacade rf = context.getBean("regionFacade", RegionFacade.class);
        List<RegionView> list = rf.findRegion();
        for(RegionView rv : list) {
            System.out.println("Region:" + rv.getRegionId() + ":" + rv.getRegionName());
        }
        rf.addRegion(list.get(0));
    }
}
