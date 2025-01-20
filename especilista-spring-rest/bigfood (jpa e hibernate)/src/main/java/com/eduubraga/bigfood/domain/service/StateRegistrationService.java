package com.eduubraga.bigfood.domain.service;

import com.eduubraga.bigfood.domain.exception.EntityNotFoundException;
import com.eduubraga.bigfood.domain.model.State;
import com.eduubraga.bigfood.domain.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateRegistrationService {

    @Autowired
    private StateRepository stateRepository;

    public State findById(Long stateId) {
        State state = stateIsNull(stateId);

        return state;
    }

    public State save(State stateInput) {
        return stateRepository.save(stateInput);
    }

    public State update(Long stateId, State stateInput) {
        State state = stateIsNull(stateId);

        state.setName(stateInput.getName());

        return save(state);
    }

    public void delete(Long stateId) {
        State state = stateIsNull(stateId);

        stateRepository.remove(state);
    }

    private State stateIsNull(Long stateId) {
        State state = stateRepository.byId(stateId);

        if (state == null) {
            throw new EntityNotFoundException(
                    String.format("O código %d não corresponde a nenhum estado.%n", stateId)
            );
        }

        return state;
    }

}
