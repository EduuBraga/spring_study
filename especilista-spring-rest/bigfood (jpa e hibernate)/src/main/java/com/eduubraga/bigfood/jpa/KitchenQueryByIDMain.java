package com.eduubraga.bigfood.jpa;


import com.eduubraga.bigfood.BigfoodApi;
import com.eduubraga.bigfood.domain.model.Kitchen;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class KitchenQueryByIDMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(BigfoodApi.class)
                .web(WebApplicationType.NONE)
                .run(args);

        KitchenRegistration kitchenRegistration = applicationContext.getBean(KitchenRegistration.class);

        Kitchen kitchen = kitchenRegistration.queryKitchenByID(2L);

        System.out.println(kitchen.getName());

    }

}

