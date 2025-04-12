package com.eduubraga.bigfood.domain.service;

import com.eduubraga.bigfood.domain.exception.EntityNotFoundException;
import com.eduubraga.bigfood.domain.exception.ForeignKeyNotFoundException;
import com.eduubraga.bigfood.domain.model.Kitchen;
import com.eduubraga.bigfood.domain.model.PaymentMethod;
import com.eduubraga.bigfood.domain.model.Restaurant;
import com.eduubraga.bigfood.domain.repository.KitchenRepository;
import com.eduubraga.bigfood.domain.repository.PaymentMethodRepository;
import com.eduubraga.bigfood.domain.repository.RestaurantRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;

@Service
public class RestaurantRegistrationService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private KitchenRepository kitchenRepository;

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    public Restaurant findById(Long restaurantId) {
        return findRestaurantByIdOrThrow(restaurantId);
    }

    public Restaurant save(Restaurant restaurant) {
        restaurant = checkNullAssociation(restaurant);

        return restaurantRepository.save(restaurant);
    }

    public Restaurant update(Long restaurantId, Restaurant restaurantInput) {
        Restaurant restaurantCurrent = findRestaurantByIdOrThrow(restaurantId);

        restaurantInput = checkNullAssociation(restaurantInput);

        BeanUtils.copyProperties(restaurantInput, restaurantCurrent, "id");

        return restaurantRepository.save(restaurantCurrent);
    }

    public Restaurant updatePartial(Long restaurantId, Map<String, Object> restaurantFields) {
        Restaurant restaurant = findRestaurantByIdOrThrow(restaurantId);

        merge(restaurantFields, restaurant);

        restaurant = update(restaurantId, restaurant);

        return restaurant;
    }

    // Métodos privados auxiliares

    private Restaurant checkNullAssociation(Restaurant restaurant) {
        Long kitchenId = restaurant.getKitchen().getId();
        Kitchen kitchen = kitchenRepository
                .findById(kitchenId)
                .orElseThrow(() -> new ForeignKeyNotFoundException(
                        String.format("A cozinha relacionada com o ID %d não foi encontrada.", kitchenId)
                ));

        Long paymentMethodId = restaurant.getPaymentMethod().getId();
        PaymentMethod paymentMethod = paymentMethodRepository
                .findById(paymentMethodId)
                .orElseThrow(() -> new ForeignKeyNotFoundException(
                        String.format("O método de pagamento relacionado com o ID %d não foi encontrado.", paymentMethodId)
                ));

        restaurant.setKitchen(kitchen);
        restaurant.setPaymentMethod(paymentMethod);

        return restaurant;
    }

    private Restaurant findRestaurantByIdOrThrow(Long restaurantId) {
        return restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("O restaurante com o ID %d não foi encontrada.", restaurantId)
                ));
    }

    private void merge(Map<String, Object> originData, Restaurant destinationRestaurant) {
        ObjectMapper objectMapper = new ObjectMapper();
        Restaurant restaurantOrigin = objectMapper.convertValue(originData, Restaurant.class);

        originData.forEach((propName, propValue) -> {
            Field field = ReflectionUtils.findField(Restaurant.class, propName);
            field.setAccessible(true);

            Object newValue = ReflectionUtils.getField(field, restaurantOrigin);

            ReflectionUtils.setField(field, destinationRestaurant, newValue);
        });
    }

}