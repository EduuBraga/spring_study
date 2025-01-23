package com.eduubraga.bigfood.domain.repository;

import com.eduubraga.bigfood.domain.model.PaymentMethod;

import java.util.List;
import java.util.Optional;

public interface PaymentMethodRepository {

    List<PaymentMethod> all();
    Optional<PaymentMethod> findById(Long id);
    PaymentMethod save(PaymentMethod paymentMethod);
    void remove(Long paymentMethodId);

}
