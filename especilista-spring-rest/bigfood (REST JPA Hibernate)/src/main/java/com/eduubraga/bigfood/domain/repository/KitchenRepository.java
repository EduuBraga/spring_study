package com.eduubraga.bigfood.domain.repository;

import com.eduubraga.bigfood.domain.model.Kitchen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface KitchenRepository extends JpaRepository<Kitchen, Long> {

}
