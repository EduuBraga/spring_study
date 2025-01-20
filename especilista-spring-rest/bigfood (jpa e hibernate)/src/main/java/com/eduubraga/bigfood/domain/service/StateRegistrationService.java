package com.eduubraga.bigfood.domain.service;

import com.eduubraga.bigfood.domain.exception.EntityInUseException;
import com.eduubraga.bigfood.domain.exception.EntityNotFoundException;
import com.eduubraga.bigfood.domain.model.State;
import com.eduubraga.bigfood.domain.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

        try {
            stateRepository.remove(state);
        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException(String.format(
                    "O recurso de \"City\" do código: %d não pode ser removido pois está em uso.%n",
                    stateId)
            );
        }
    }

    private State stateIsNull(Long stateId) {
        State state = stateRepository.byId(stateId);

        if (state == null) {
            throw new EntityNotFoundException(
                    String.format("Nenhum recurso encontrado para o código:%d.%n", stateId)
            );
        }

        return state;
    }

}
