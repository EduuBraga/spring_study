package com.eduubraga.bigfood.api.controller;

import com.eduubraga.bigfood.domain.model.Restaurant;
import com.eduubraga.bigfood.domain.repository.RestaurantRepositoryQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/test")
public class testController {

    @Autowired
    private RestaurantRepositoryQueries restaurantRepositoryQueries;

    @GetMapping("/restaurants/by-name")
    public List<Restaurant> findByName(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) BigDecimal shippingFeeStart,
            @RequestParam(required = false) BigDecimal shippingFeeEnd
    ) {
        return restaurantRepositoryQueries.find(name, shippingFeeStart, shippingFeeEnd);
    }

}
