package com.eduubraga.bigfood.domain.repository;

import com.eduubraga.bigfood.domain.model.Restaurant;

import java.math.BigDecimal;
import java.util.List;

public interface RestaurantRepositoryQueries {

    List<Restaurant> find(String name, BigDecimal shippingFeeStart, BigDecimal shippingFeeEnd);

}
