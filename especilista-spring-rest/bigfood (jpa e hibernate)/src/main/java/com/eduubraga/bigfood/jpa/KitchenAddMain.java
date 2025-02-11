package com.eduubraga.bigfood.jpa;


import com.eduubraga.bigfood.BigfoodApi;
import com.eduubraga.bigfood.domain.model.Kitchen;
import com.eduubraga.bigfood.domain.repository.KitchenRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class KitchenAddMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(BigfoodApi.class)
                .web(WebApplicationType.NONE)
                .run(args);

        KitchenRepository kitchenRepository = applicationContext.getBean(KitchenRepository.class);

//        List<Kitchen> kitchens = kitchenRepository.all();
//
//        Kitchen kitchen1 = new Kitchen();
//        kitchen1.setName("Brasileira");
//
//        Kitchen kitchen2 = new Kitchen();
//        kitchen2.setName("Japonesa");
//
//        kitchen1 = kitchenRepository.save(kitchen1);
//        kitchen2 = kitchenRepository.save(kitchen2);
//
//        System.out.printf("%d - %s\n", kitchen1.getId(), kitchen1.getName());
//        System.out.printf("%d - %s\n", kitchen2.getId(), kitchen2.getName());

    }

}

