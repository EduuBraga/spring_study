package com.eduubraga.bigfood.infrastructure.repository;

import com.eduubraga.bigfood.domain.exception.EntityNotFoundException;
import com.eduubraga.bigfood.domain.model.PaymentMethod;
import com.eduubraga.bigfood.domain.repository.PaymentMethodRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PaymentMethodRepositoryImpl implements PaymentMethodRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<PaymentMethod> all() {
        return manager.createQuery("from PaymentMethod", PaymentMethod.class).getResultList();
    }

    @Override
    public Optional<PaymentMethod> findById(Long id) {
        return Optional.ofNullable(manager.find(PaymentMethod.class, id));
    }

    @Transactional
    @Override
    public PaymentMethod save(PaymentMethod paymentMethod) {
        return manager.merge(paymentMethod);
    }

    @Transactional
    @Override
    public void remove(Long paymentMethodId) {
        PaymentMethod paymentMethodToRemove = findById(paymentMethodId)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("O método de pagamento com o ID %d não foi encontrado.", paymentMethodId)
                ));

        manager.remove(paymentMethodToRemove);
    }

}