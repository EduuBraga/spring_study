package com.eduubraga.bigfood.api.controller;

import com.eduubraga.bigfood.domain.exception.EntityInUseException;
import com.eduubraga.bigfood.domain.exception.EntityNotFoundException;
import com.eduubraga.bigfood.domain.model.Kitchen;
import com.eduubraga.bigfood.domain.repository.KitchenRepository;
import com.eduubraga.bigfood.domain.service.KitchenRegistrationService;
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

    @Autowired
    private KitchenRegistrationService kitchenRegistrationService;

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
        return kitchenRegistrationService.add(kitchen);
    }

    @PutMapping("{kitchenId}")
    public ResponseEntity<Kitchen> update(@PathVariable Long kitchenId, @RequestBody Kitchen kitchen) {
        Kitchen currentKitchen = kitchenRepository.byId(kitchenId);

        if (Objects.isNull(currentKitchen)) {
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(kitchen, currentKitchen, "id");

        currentKitchen = kitchenRegistrationService.add(currentKitchen);

        return ResponseEntity.ok(currentKitchen);
    }

    @DeleteMapping("{kitchenId}")
    public ResponseEntity<Kitchen> delete(@PathVariable Long kitchenId) {
        try {
            kitchenRegistrationService.delete(kitchenId);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (EntityInUseException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

}
