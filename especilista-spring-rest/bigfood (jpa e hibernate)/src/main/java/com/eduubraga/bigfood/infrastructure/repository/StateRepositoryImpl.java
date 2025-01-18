package com.eduubraga.bigfood.infrastructure.repository;

import com.eduubraga.bigfood.domain.model.State;
import com.eduubraga.bigfood.domain.repository.StateRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StateRepositoryImpl implements StateRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<State> all() {
        return manager.createQuery("from State", State.class).getResultList();
    }

    @Override
    public State byId(Long id) {
        return manager.find(State.class, id);
    }

    @Override
    @Transactional
    public State add(State state) {
        return manager.merge(state);
    }

    @Override
    @Transactional
    public void remove(State state) {
        state = byId(state.getId());
        manager.remove(state);
    }

}