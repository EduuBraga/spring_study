package com.eduubraga.bigfood.infrastructure.repository;

import com.eduubraga.bigfood.domain.exception.EntityNotFoundException;
import com.eduubraga.bigfood.domain.model.Restaurant;
import com.eduubraga.bigfood.domain.repository.RestaurantRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Restaurant> all() {
        return manager.createQuery("from Restaurant", Restaurant.class).getResultList();
    }

    @Override
    public Optional<Restaurant> findById(Long id) {
        return Optional.ofNullable(manager.find(Restaurant.class, id));
    }

    @Override
    @Transactional
    public Restaurant save(Restaurant restaurant) {
        return manager.merge(restaurant);
    }

    @Override
    @Transactional
    public void remove(Long restaurantId) {
        Restaurant restaurantToRemove = findById(restaurantId)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("O restaurante com o ID %d não foi encontrado.", restaurantId)
                ));

        manager.remove(restaurantToRemove);
    }
}
