package com.eduubraga.bigfood.infrastructure.repository;

import com.eduubraga.bigfood.domain.model.Restaurant;
import com.eduubraga.bigfood.domain.repository.RestaurantRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Restaurant> all() {
        return manager.createQuery("from Restaurant", Restaurant.class).getResultList();
    }

    @Override
    public Restaurant byId(Long id) {
        return manager.find(Restaurant.class, id);
    }

    @Override
    public Restaurant add(Restaurant restaurant) {
        return manager.merge(restaurant);
    }

    @Override
    public void remove(Restaurant restaurant) {
        restaurant = byId(restaurant.getId());
        manager.remove(restaurant);
    }
}
