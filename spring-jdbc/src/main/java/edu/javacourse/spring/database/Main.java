package edu.javacourse.spring.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"springDatabase.xml"});

        JdbcTemplate jdbc = context.getBean("jdbcTemplate", JdbcTemplate.class);

        Long countOfRegion = jdbc.queryForObject("select count(*) from jc_region where region_id = 25", Long.class);        
        System.out.println("COUNT:" + countOfRegion);

        String regionName = jdbc.queryForObject("select region_name from jc_region "
                + "where region_id = ? and region_name = ?",
            new Object[]{25L, "Moscow"}, String.class);
        System.out.println("NAME:" + regionName);

        jdbc.update("insert into jc_region (region_name) values (?)", "HMAO");
        
        List<Region> list = jdbc.query("SELECT * FROM jc_region",
                new RowMapper<Region>() {

                    public Region mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Region region = new Region();
                        region.setRegionId(rs.getLong("region_id"));
                        region.setRegionName(rs.getString("region_name"));
                        return region;
                    }
                });
        for(Region r : list) {
            System.out.println(r);
        }
    }
}
