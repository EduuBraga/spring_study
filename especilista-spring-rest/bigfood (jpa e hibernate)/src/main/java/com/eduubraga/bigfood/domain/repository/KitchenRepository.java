package com.eduubraga.bigfood.domain.repository;

import com.eduubraga.bigfood.domain.model.Kitchen;

import java.util.List;
import java.util.Optional;

public interface KitchenRepository {

    // Baseado em coleções do java
    List<Kitchen> all();
    Optional<Kitchen> findById(Long id);
    Kitchen save(Kitchen kitchen);
    void remove(Long kitchenId);

}
