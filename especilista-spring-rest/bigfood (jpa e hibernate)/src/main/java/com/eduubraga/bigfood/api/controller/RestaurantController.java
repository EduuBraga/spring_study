package com.eduubraga.bigfood.api.controller;

import com.eduubraga.bigfood.domain.exception.EntityNotFoundException;
import com.eduubraga.bigfood.domain.model.Restaurant;
import com.eduubraga.bigfood.domain.repository.RestaurantRepository;
import com.eduubraga.bigfood.domain.service.RestaurantRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantRegistrationService restaurantRegistrationService;

    @GetMapping
    public List<Restaurant> list() {
        return restaurantRepository.all();
    }

    @GetMapping("{restaurantId}")
    public ResponseEntity<Restaurant> searchById(@PathVariable Long restaurantId) {
        Restaurant restaurant = restaurantRepository.byId(restaurantId);

        if (restaurant == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(restaurant);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Restaurant restaurant) {
        try {
            restaurant = restaurantRegistrationService.add(restaurant);

            return ResponseEntity.status(HttpStatus.CREATED).body(restaurant);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
