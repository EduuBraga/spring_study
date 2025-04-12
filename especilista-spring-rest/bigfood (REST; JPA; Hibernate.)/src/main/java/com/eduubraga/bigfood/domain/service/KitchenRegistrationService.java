package com.eduubraga.bigfood.domain.service;

import com.eduubraga.bigfood.domain.exception.EntityInUseException;
import com.eduubraga.bigfood.domain.exception.EntityNotFoundException;
import com.eduubraga.bigfood.domain.model.Kitchen;
import com.eduubraga.bigfood.domain.repository.KitchenRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class KitchenRegistrationService {

    @Autowired
    private KitchenRepository kitchenRepository;

    public Kitchen save(Kitchen kitchen) {
        return kitchenRepository.save(kitchen);
    }

    public Kitchen findById(Long kitchenId) {
        Kitchen kitchen = kitchenRepository.findById(kitchenId)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("A cozinha com o ID %d não foi encontrada.", kitchenId)
                ));

        return kitchen;
    }

    public Kitchen update(Long kitchenId, Kitchen kitchenInput) {
        Kitchen kitchenCurrent = kitchenRepository.findById(kitchenId)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("A cozinha com o ID %d não foi encontrada.", kitchenId)
                ));

        BeanUtils.copyProperties(kitchenInput, kitchenCurrent, "id");

        return save(kitchenCurrent);
    }

    public void delete(Long kitchenId) {
        try {
            Kitchen kitchenToRemove = findById(kitchenId);
            kitchenRepository.delete(kitchenToRemove);
        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException(
                    String.format("A cozinha com o ID %d não pode ser removida pois está em uso.%n", kitchenId)
            );
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }

}
