package com.eduubraga.bigfood.domain.repository;

import com.eduubraga.bigfood.domain.model.Kitchen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface KitchenRepository extends JpaRepository<Kitchen, Long> {

    List<Kitchen> findByName(String name);

}
