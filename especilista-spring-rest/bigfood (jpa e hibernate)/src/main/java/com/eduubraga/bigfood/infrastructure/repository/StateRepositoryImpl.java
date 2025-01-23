package com.eduubraga.bigfood.infrastructure.repository;

import com.eduubraga.bigfood.domain.exception.EntityNotFoundException;
import com.eduubraga.bigfood.domain.model.City;
import com.eduubraga.bigfood.domain.model.State;
import com.eduubraga.bigfood.domain.repository.StateRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StateRepositoryImpl implements StateRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<State> all() {
        return manager.createQuery("from State", State.class).getResultList();
    }

    @Override
    public Optional<State> findById(Long id) {
        State state = manager.find(State.class, id);

        return Optional.ofNullable(state);
    }

    @Override
    @Transactional
    public State save(State state) {
        return manager.merge(state);
    }

    @Override
    @Transactional
    public void remove(Long stateId) {
        State stateCurrent = findById(stateId)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("O estado com o ID %d não foi encontrado.", stateId)
                ));

        manager.remove(stateCurrent);
    }

}