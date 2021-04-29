package com.example.cities.countries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CitiesController {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    CitiesService citiesService;

    //http://localhost:8080/addCountry/Latvia/Riga/100000
    @PostMapping("addCountry/{name}/{capitol}/{pop}")
    public String addCountry(@PathVariable("name") String name,
                             @PathVariable("capitol") String capitol,
                             @PathVariable("pop") Double pop) {
        citiesService.addCountry(name, capitol, pop);
        return "Country added!";
    }

    @GetMapping("getData/{name}")
    public String getData(@PathVariable("name") String name) {
        citiesService.getData(name);
        return name + " has a capitol " + citiesService.getData(name);
    }
}
