package com.eduubraga.bigfood.domain.repository;

import com.eduubraga.bigfood.domain.model.Kitchen;

import java.util.List;

public interface KitchenRepository {

    // Baseado em coleções do java
    List<Kitchen> all();
    Kitchen byId(Long id);
    Kitchen save(Kitchen kitchen);
    void remove(Long kitchenId);

}
