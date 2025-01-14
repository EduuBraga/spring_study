package com.eduubraga.bigfood.domain.service;

import com.eduubraga.bigfood.domain.exception.EntityNotFoundException;
import com.eduubraga.bigfood.domain.model.Kitchen;
import com.eduubraga.bigfood.domain.model.Restaurant;
import com.eduubraga.bigfood.domain.repository.KitchenRepository;
import com.eduubraga.bigfood.domain.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantRegistrationService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private KitchenRepository kitchenRepository;

    public Restaurant add(Restaurant restaurant) {
        Long kitchenId = restaurant.getKitchen().getId();
        Kitchen kitchen = kitchenRepository.byId(kitchenId);

        if (kitchen == null) {
            throw new EntityNotFoundException(
                    String.format("A cozinha referente ao ID: %d não existe.%n", kitchenId)
            );
        }

        return restaurantRepository.add(restaurant);
    }

}
