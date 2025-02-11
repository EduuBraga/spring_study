package com.eduubraga.bigfood.jpa;


import com.eduubraga.bigfood.BigfoodApi;
import com.eduubraga.bigfood.domain.model.Kitchen;
import com.eduubraga.bigfood.domain.model.Restaurant;
import com.eduubraga.bigfood.domain.repository.KitchenRepository;
import com.eduubraga.bigfood.domain.repository.RestaurantRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class RestaurantQueryMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(BigfoodApi.class)
                .web(WebApplicationType.NONE)
                .run(args);

        RestaurantRepository restaurants = applicationContext.getBean(RestaurantRepository.class);

//        List<Restaurant> restaurantsAll = restaurants.all();
//
//        for (Restaurant restaurant : restaurantsAll) {
//            System.out.printf("Nome do Restaurante: %s | Taxa de frete: %.2f | Nome da Cozinha: %s%n",
//                    restaurant.getName(),
//                    restaurant.getShippingFee(),
//                    restaurant.getKitchen().getName()
//            );
//        }

    }

}
