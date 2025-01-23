package com.eduubraga.bigfood.domain.repository;

import com.eduubraga.bigfood.domain.model.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository {

    List<Restaurant> all();
    Optional<Restaurant> findById(Long id);
    Restaurant save(Restaurant restaurant);
    void remove(Long restaurantId);

}
