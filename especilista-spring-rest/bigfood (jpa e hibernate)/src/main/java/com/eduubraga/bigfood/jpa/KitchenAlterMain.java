package com.eduubraga.bigfood.jpa;


import com.eduubraga.bigfood.BigfoodApi;
import com.eduubraga.bigfood.domain.model.Kitchen;
import com.eduubraga.bigfood.domain.repository.KitchenRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class KitchenAlterMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(BigfoodApi.class)
                .web(WebApplicationType.NONE)
                .run(args);

        KitchenRepository kitchens = applicationContext.getBean(KitchenRepository.class);

        Kitchen kitchen = new Kitchen();
        kitchen.setName("Brasileira");
        kitchen.setId(1L);

        kitchens.save(kitchen);

    }

}