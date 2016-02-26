package edu.javacourse.spring.database;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        FileSystemXmlApplicationContext context =
                new FileSystemXmlApplicationContext(
                new String[]{"springDatabase.xml", "region-cfg.xml"});

        // Обращение к бину с транзакциями
        RegionFacade rf = context.getBean("regionFacade", RegionFacade.class);
        RegionView rv = new RegionView();
        rv.setRegionName("RegionName");
        Long id = rf.addRegion(rv);

        RegionView rv2 = rf.getRegion(id);
        System.out.println("===> Transaction");
        System.out.println(rv2.getRegionId() + ":" + rv2.getRegionName());
        System.out.println();

        rf.deleteRegion(id);

        // Destroy
        context.destroy();
    }
}
