package com.eduubraga.bigfood.jpa;


import com.eduubraga.bigfood.BigfoodApi;
import com.eduubraga.bigfood.domain.model.Kitchen;
import com.eduubraga.bigfood.domain.repository.KitchenRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class KitchenQueryMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(BigfoodApi.class)
                .web(WebApplicationType.NONE)
                .run(args);

        KitchenRepository kitchens = applicationContext.getBean(KitchenRepository.class);

//        List<Kitchen> kitchensAll = kitchens.all();
//
//        for (Kitchen kitchen : kitchensAll) {
//            System.out.println(kitchen.getId());
//            System.out.println(kitchen.getName());
//            System.out.println("-----------");
//        }

    }

}
