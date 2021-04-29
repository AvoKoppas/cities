package com.example.cities.countries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CitiesRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void addCountry(String name, String capitol, Double pop) {
        String sql = "INSERT INTO countries (name, capital, population) " +
                "VALUES (:a, :b, :c )";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("a", name);
        paramMap.put("b", capitol);
        paramMap.put("c", pop);
        jdbcTemplate.update(sql, paramMap);
    }

    public String getData(String name) {
        String sql = "SELECT capital FROM countries WHERE name = :a";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("a", name);
        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
    }
}
