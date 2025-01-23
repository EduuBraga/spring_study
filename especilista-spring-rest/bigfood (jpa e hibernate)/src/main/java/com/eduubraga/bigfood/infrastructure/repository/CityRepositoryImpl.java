package com.eduubraga.bigfood.infrastructure.repository;

import com.eduubraga.bigfood.domain.exception.EntityNotFoundException;
import com.eduubraga.bigfood.domain.model.City;
import com.eduubraga.bigfood.domain.model.Kitchen;
import com.eduubraga.bigfood.domain.repository.CityRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CityRepositoryImpl implements CityRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<City> all() {
        return manager.createQuery("from City", City.class).getResultList();
    }

    @Override
    public Optional<City> findById(Long id) {
        City city = manager.find(City.class, id);

        return Optional.ofNullable(city);
    }

    @Transactional
    @Override
    public City save(City city) {
        return manager.merge(city);
    }

    @Transactional
    @Override
    public void remove(Long cityId) {
        City cityToRemove = findById(cityId)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("A cidade com o ID %d não foi encontrada.", cityId)
                ));

        manager.remove(cityToRemove);
    }
}