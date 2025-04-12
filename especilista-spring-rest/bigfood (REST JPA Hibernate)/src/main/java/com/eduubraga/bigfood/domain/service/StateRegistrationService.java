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
        State state = findStateByIdOrThrow(stateId);

        return state;
    }

    public State save(State stateInput) {
        return stateRepository.save(stateInput);
    }

    public State update(Long stateId, State stateInput) {
        State state = findStateByIdOrThrow(stateId);

        state.setName(stateInput.getName());

        return save(state);
    }

    public void delete(Long stateId) {

        try {
            State state = findStateByIdOrThrow(stateId);
            stateRepository.delete(state);
        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException(String.format(
                    "O estado com o ID %d não pode ser removida pois está em uso.%n",
                    stateId)
            );
        } catch (EntityNotFoundException e) {
            throw new EntityInUseException(e.getMessage());
        }
    }

    private State findStateByIdOrThrow(Long stateId) {
        return stateRepository.findById(stateId)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("O estado com o ID %d não foi encontrada.%n", stateId)
                ));
    }

}
