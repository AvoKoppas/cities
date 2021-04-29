package com.example.cities.countries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CitiesService {
    @Autowired
    private CitiesRepository citiesRepository;
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public void addCountry(String name, String capitol, Double pop) {
        citiesRepository.addCountry(name, capitol, pop);
    }

    public String getData(String name) {
        return citiesRepository.getData(name);
    }
}
