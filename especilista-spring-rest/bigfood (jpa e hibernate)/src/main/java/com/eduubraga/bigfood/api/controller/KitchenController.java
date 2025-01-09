package com.eduubraga.bigfood.api.controller;

import com.eduubraga.bigfood.domain.model.Kitchen;
import com.eduubraga.bigfood.domain.repository.KitchenRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/kitchens")
public class KitchenController {

    @Autowired
    private KitchenRepository kitchenRepository;

    @GetMapping
    public List<Kitchen> list() {
        return kitchenRepository.all();
    }

    @GetMapping("/{kitchenId}")
    public ResponseEntity<Kitchen> searchById(@PathVariable Long kitchenId) {
        Kitchen kitchen = kitchenRepository.byId(kitchenId);

        if (Objects.isNull(kitchen)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(kitchen);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Kitchen add(@RequestBody Kitchen kitchen) {
        return kitchenRepository.add(kitchen);
    }

    @PutMapping("{kitchenId}")
    public ResponseEntity<Kitchen> update(@PathVariable Long kitchenId, @RequestBody Kitchen kitchen) {
        Kitchen currentKitchen = kitchenRepository.byId(kitchenId);

        if (Objects.isNull(currentKitchen)) {
            return ResponseEntity.notFound().build();
        }

//        currentKitchen.setName(kitchen.getName());
        BeanUtils.copyProperties(kitchen, currentKitchen, "id");

        currentKitchen = kitchenRepository.add(currentKitchen);

        return ResponseEntity.ok(currentKitchen);
    }   

}
