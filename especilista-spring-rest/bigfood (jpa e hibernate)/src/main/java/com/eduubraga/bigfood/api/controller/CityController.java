package com.eduubraga.bigfood.api.controller;

import com.eduubraga.bigfood.domain.exception.EntityNotFoundException;
import com.eduubraga.bigfood.domain.exception.ForeignKeyNotFoundException;
import com.eduubraga.bigfood.domain.model.City;
import com.eduubraga.bigfood.domain.repository.CityRepository;
import com.eduubraga.bigfood.domain.service.CityRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/citys")
@RestController
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CityRegistrationService cityRegistrationService;

    @GetMapping
    public List<City> list() {
        return cityRepository.all();
    }

    @GetMapping("/{cityId}")
    public ResponseEntity<?> findById(@PathVariable Long cityId) {
        try {
            City city = cityRegistrationService.findById(cityId);
            return ResponseEntity.ok(city);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody City city) {
        try {
            city = cityRegistrationService.save(city);
            return ResponseEntity.status(HttpStatus.CREATED).body(city);
        } catch (ForeignKeyNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{cityId}")
    public ResponseEntity<?> update(@PathVariable Long cityId, @RequestBody City city) {
        try {
            city = cityRegistrationService.update(cityId, city);
            return ResponseEntity.ok(city);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (ForeignKeyNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{cityId}")
    public ResponseEntity<?> delete(@PathVariable Long cityId) {
        try {
            cityRegistrationService.delete(cityId);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
