package com.eduubraga.bigfood.domain.repository;

import com.eduubraga.bigfood.domain.model.State;

import java.util.List;
import java.util.Optional;

public interface StateRepository {

    List<State> all();
    Optional<State> findById(Long id);
    State save(State state);
    void remove(Long stateId);

}
