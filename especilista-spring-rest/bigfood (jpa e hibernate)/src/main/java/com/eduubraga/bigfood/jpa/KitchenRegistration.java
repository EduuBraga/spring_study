package com.eduubraga.bigfood.jpa;

import com.eduubraga.bigfood.domain.model.Kitchen;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class KitchenRegistration {

    @PersistenceContext
    private EntityManager manager;

    public List<Kitchen> listKitchen() {
        TypedQuery<Kitchen> query = manager.createQuery("from Kitchen", Kitchen.class);

        return query.getResultList();
    }

    @Transactional
    public Kitchen saveKitchen(Kitchen kitchen) {
        return manager.merge(kitchen);
    }

    public Kitchen queryKitchenByID(Long id) {
        return manager.find(Kitchen.class, id);
    }

}
