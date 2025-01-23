package com.eduubraga.bigfood.infrastructure.repository;

import com.eduubraga.bigfood.domain.exception.EntityNotFoundException;
import com.eduubraga.bigfood.domain.model.Kitchen;
import com.eduubraga.bigfood.domain.repository.KitchenRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class KitchenRepositoryImpl implements KitchenRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Kitchen> all() {
        return manager.createQuery("from Kitchen", Kitchen.class).getResultList();
    }

    @Override
    public Optional<Kitchen> findById(Long id) {
        return Optional.ofNullable(manager.find(Kitchen.class, id));
    }

    @Transactional
    @Override
    public Kitchen save(Kitchen kitchen) {
        return manager.merge(kitchen);
    }

    @Transactional
    @Override
    public void remove(Long kitchenId) {
        Kitchen kitchenToRemove = findById(kitchenId)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("A cozinha com o ID %d não foi encontrada.", kitchenId)
                ));

        manager.remove(kitchenToRemove);
    }

}
