package com.eduubraga.bigfood.api.controller;

import com.eduubraga.bigfood.domain.exception.EntityNotFoundException;
import com.eduubraga.bigfood.domain.exception.ForeignKeyNotFoundException;
import com.eduubraga.bigfood.domain.model.Restaurant;
import com.eduubraga.bigfood.domain.repository.RestaurantRepository;
import com.eduubraga.bigfood.domain.service.RestaurantRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantRegistrationService restaurantRegistrationService;

    @GetMapping
    public List<Restaurant> list() {
        return restaurantRepository.findAll();
    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity<?> findById(@PathVariable Long restaurantId) {
        try {
            Restaurant restaurant = restaurantRegistrationService.findById(restaurantId);
            return ResponseEntity.ok(restaurant);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Restaurant restaurant) {
        try {
            restaurant = restaurantRegistrationService.save(restaurant);

            return ResponseEntity.status(HttpStatus.CREATED).body(restaurant);
        } catch (ForeignKeyNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PutMapping("/{restaurantId}")
    public ResponseEntity<?> update(@PathVariable Long restaurantId, @RequestBody Restaurant restaurant) {
        try {
            restaurant = restaurantRegistrationService.update(restaurantId, restaurant);

            return ResponseEntity.ok(restaurant);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (ForeignKeyNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{restaurantId}")
    public ResponseEntity<?> updatePartial(
            @PathVariable Long restaurantId,
            @RequestBody Map<String, Object> restaurantFields
    ) {
        try {
            Restaurant restaurantCurrent = restaurantRegistrationService
                    .updatePartial(restaurantId, restaurantFields);

            return ResponseEntity.ok().body(restaurantCurrent);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
