package com.eduubraga.bigfood.domain.repository;

import com.eduubraga.bigfood.domain.model.City;

import java.util.List;

public interface CityRepository {

    List<City> all();
    City byId(Long id);
    City add(City city);
    void remove(City city);

}
