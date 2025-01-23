package com.eduubraga.bigfood.domain.repository;

import com.eduubraga.bigfood.domain.model.City;

import java.util.List;
import java.util.Optional;

public interface CityRepository {

    List<City> all();
    Optional<City> findById(Long id);
    City save(City city);
    void remove(Long cityId);

}
