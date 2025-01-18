package com.eduubraga.bigfood.domain.service;

import com.eduubraga.bigfood.domain.exception.EntityInUseException;
import com.eduubraga.bigfood.domain.exception.EntityNotFoundException;
import com.eduubraga.bigfood.domain.model.Kitchen;
import com.eduubraga.bigfood.domain.repository.KitchenRepository;
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

    public void delete(Long kitchenId) {
        try {
            kitchenRepository.remove(kitchenId);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(
                    String.format("Nenhuma entidade encontrada para o ID: %d.%n", kitchenId)
            );
        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException(
              String.format("A cozinha com o ID %d não pode ser removida pois está em uso.%n", kitchenId)
            );
        }
    }

}
