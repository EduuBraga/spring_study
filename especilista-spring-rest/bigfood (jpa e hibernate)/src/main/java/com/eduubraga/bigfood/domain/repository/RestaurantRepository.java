package com.eduubraga.bigfood.domain.repository;

import com.eduubraga.bigfood.domain.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {

    List<Restaurant> all();
    Restaurant byId(Long id);
    Restaurant add(Restaurant restaurant);
    void remove(Restaurant restaurant);

}
