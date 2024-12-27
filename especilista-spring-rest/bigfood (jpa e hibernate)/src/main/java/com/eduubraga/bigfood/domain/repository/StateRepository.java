package com.eduubraga.bigfood.domain.repository;

import com.eduubraga.bigfood.domain.model.State;

import java.util.List;

public interface StateRepository {

    List<State> all();
    State byId(Long id);
    State add(State state);
    void remove(State state);

}
