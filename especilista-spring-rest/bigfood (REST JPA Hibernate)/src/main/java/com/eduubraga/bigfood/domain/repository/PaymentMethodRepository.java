package com.eduubraga.bigfood.domain.repository;

import com.eduubraga.bigfood.domain.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {

}
