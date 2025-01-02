package com.eduubraga.bigfood.infrastructure.repository;

import com.eduubraga.bigfood.domain.model.City;
import com.eduubraga.bigfood.domain.repository.CityRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CityRepositoryImpl implements CityRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<City> all() {
        return manager.createQuery("from City", City.class).getResultList();
    }

    @Override
    public City byId(Long id) {
        return manager.find(City.class, id);
    }

    @Transactional
    @Override
    public City add(City city) {
        return manager.merge(city);
    }

    @Transactional
    @Override
    public void remove(City city) {
        city = byId(city.getId());
        manager.remove(city);
    }
}