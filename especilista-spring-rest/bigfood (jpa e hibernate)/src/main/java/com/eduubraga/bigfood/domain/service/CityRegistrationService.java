package com.eduubraga.bigfood.domain.service;

import com.eduubraga.bigfood.domain.exception.EntityNotFoundException;
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
        City city = cityIsNull(cityId);

        return city;
    }

    public City save(City cityInput) {
        Long stateId = cityInput.getState().getId();
        State state = stateIsNull(stateId);

        cityInput.setState(state);

        return cityRepository.save(cityInput);
    }

    public City update(Long cityId, City cityInput) {
        City cityCurrent = cityIsNull(cityId);

        Long stateId = cityInput.getState().getId();
        State state = stateIsNull(stateId);

        cityCurrent.setState(state);

        BeanUtils.copyProperties(cityInput, cityCurrent, "id", "state");

        return cityRepository.save(cityCurrent);
    }

    public void delete(Long cityId) {
        City city = cityIsNull(cityId);

        cityRepository.remove(city);
    }


    // Métodos privados

    private City cityIsNull(Long cityId) {
        City city = cityRepository.byId(cityId);

        if (city == null) {
            throw new EntityNotFoundException(
                    String.format("Não existe valor na entidade \"City\" para o código: %d.%n", cityId)
            );
        }

        return city;
    }

    private State stateIsNull(Long stateId) {
        State state = stateRepository.byId(stateId);

        if (state == null) {
            throw new EntityNotFoundException(
                    String.format("Não existe valor na entidade \"State\" para o código: %d.%n", stateId)
            );
        }

        return state;
    }

}
