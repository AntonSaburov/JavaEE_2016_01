package edu.javacourse.spring.database;

import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class Main {

    public static void main(String[] args) {

        FileSystemXmlApplicationContext context =
                new FileSystemXmlApplicationContext(
                new String[]{"springDatabase.xml"});

        NamedParameterJdbcTemplate jdbc = context.getBean("jdbcTemplate", NamedParameterJdbcTemplate.class);
        String sql = "select count(*) from jc_region where region_name = :region_name";
        SqlParameterSource namedParameters = new MapSqlParameterSource("region_name", "Moscow");
        Integer answer = jdbc.queryForInt(sql, namedParameters);
        System.out.println("ANSWER:" + answer);
    }
}
