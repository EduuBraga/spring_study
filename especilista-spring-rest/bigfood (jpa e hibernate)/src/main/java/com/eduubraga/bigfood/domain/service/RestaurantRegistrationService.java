package com.eduubraga.bigfood.domain.service;

import com.eduubraga.bigfood.domain.exception.EntityNotFoundException;
import com.eduubraga.bigfood.domain.exception.RestaurantNotFoundException;
import com.eduubraga.bigfood.domain.model.Kitchen;
import com.eduubraga.bigfood.domain.model.PaymentMethod;
import com.eduubraga.bigfood.domain.model.Restaurant;
import com.eduubraga.bigfood.domain.repository.KitchenRepository;
import com.eduubraga.bigfood.domain.repository.PaymentMethodRepository;
import com.eduubraga.bigfood.domain.repository.RestaurantRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantRegistrationService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private KitchenRepository kitchenRepository;

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    public Restaurant save(Restaurant restaurant) {
        restaurant = checkNullAssociation(restaurant);

        return restaurantRepository.save(restaurant);
    }

    public Restaurant update(Long restaurantId, Restaurant restaurantInput) {
        Restaurant restaurantCurrent = restaurantRepository.byId(restaurantId);

        if (restaurantCurrent == null) {
            throw new RestaurantNotFoundException(
                    String.format("O restaurante representado pelo ID: %d não existe.%n", restaurantId)
            );
        }

        restaurantInput = checkNullAssociation(restaurantInput);

        BeanUtils.copyProperties(restaurantInput, restaurantCurrent, "id");

        return save(restaurantCurrent);
    }

    private Restaurant checkNullAssociation(Restaurant restaurant) {
        Long kitchenId = restaurant.getKitchen().getId();
        Kitchen kitchen = kitchenRepository.byId(kitchenId);

        if (kitchen == null) {
            throw new EntityNotFoundException(
                    String.format("A cozinha referente ao ID: %d não existe.%n", kitchenId)
            );
        }

        Long paymentMethodId = restaurant.getPaymentMethod().getId();
        PaymentMethod paymentMethod = paymentMethodRepository.byId(paymentMethodId);

        if (paymentMethod == null) {
            throw new EntityNotFoundException(
                    String.format("O método de pagemento referente ao ID: %d não existe.%n", paymentMethodId)
            );
        }

        restaurant.setPaymentMethod(paymentMethod);
        restaurant.setKitchen(kitchen);

        return restaurant;
    }

}
