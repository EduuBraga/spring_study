package com.eduubraga.bigfood.domain.repository;

import com.eduubraga.bigfood.domain.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}
