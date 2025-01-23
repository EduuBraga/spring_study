package com.eduubraga.bigfood.domain.service;

import com.eduubraga.bigfood.domain.exception.EntityNotFoundException;
import com.eduubraga.bigfood.domain.exception.ForeignKeyNotFoundException;
import com.eduubraga.bigfood.domain.model.City;
import com.eduubraga.bigfood.domain.model.State;
import com.eduubraga.bigfood.domain.repository.CityRepository;
import com.eduubraga.bigfood.domain.repository.StateRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityRegistrationService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private StateRepository stateRepository;

    public City findById(Long cityId) {
        return findCityByIdOrThrow(cityId);
    }

    public City save(City cityInput) {
        State state = findStateByIdOrThrow(cityInput.getState().getId());
        cityInput.setState(state);

        return cityRepository.save(cityInput);
    }

    public City update(Long cityId, City cityInput) {
        City cityCurrent = findCityByIdOrThrow(cityId);
        State state = findStateByIdOrThrow(cityInput.getState().getId());

        BeanUtils.copyProperties(cityInput, cityCurrent, "id", "state");
        cityCurrent.setState(state);

        return cityRepository.save(cityCurrent);
    }

    public void delete(Long cityId) {
        City city = findCityByIdOrThrow(cityId);

        try {
            cityRepository.remove(cityId);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }

    // Métodos auxiliares privados

    private City findCityByIdOrThrow(Long cityId) {
        return cityRepository.findById(cityId)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("A cidade com o ID %d não foi encontrada.", cityId)
                ));
    }

    private State findStateByIdOrThrow(Long stateId) {
        return stateRepository.findById(stateId)
                .orElseThrow(() -> new ForeignKeyNotFoundException(
                        String.format("O estado relacionado com o ID %d não foi encontrado.", stateId)
                ));
    }

}
