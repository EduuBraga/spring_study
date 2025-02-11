package com.eduubraga.bigfood.api.controller;

import com.eduubraga.bigfood.domain.model.Kitchen;
import com.eduubraga.bigfood.domain.repository.KitchenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class testeController {

    @Autowired
    private KitchenRepository kitchenRepository;

//    @GetMapping("/kitchens/by-name")
//    public List<Kitchen> findByName(@RequestParam String name) {
//        return kitchenRepository.findByName(name);
//    }

}
