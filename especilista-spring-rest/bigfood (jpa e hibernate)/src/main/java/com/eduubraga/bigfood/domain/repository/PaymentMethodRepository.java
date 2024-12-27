package com.eduubraga.bigfood.domain.repository;

import com.eduubraga.bigfood.domain.model.PaymentMethod;

import java.util.List;

public interface PaymentMethodRepository {

    List<PaymentMethod> all();
    PaymentMethod byId(Long id);
    PaymentMethod add(PaymentMethod paymentMethod);
    void remove(PaymentMethod paymentMethod);

}
