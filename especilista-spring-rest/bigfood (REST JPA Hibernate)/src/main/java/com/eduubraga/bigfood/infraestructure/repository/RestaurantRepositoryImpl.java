package com.eduubraga.bigfood.infraestructure.repository;

import com.ctc.wstx.util.StringUtil;
import com.eduubraga.bigfood.domain.model.Restaurant;
import com.eduubraga.bigfood.domain.repository.RestaurantRepositoryQueries;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepositoryQueries {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Restaurant> find(String name, BigDecimal shippingFeeStart, BigDecimal shippingFeeEnd) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();

        CriteriaQuery<Restaurant> criteria = builder.createQuery(Restaurant.class);
        Root<Restaurant> root =  criteria.from(Restaurant.class);

        // Vamos tratar os predicates para só serem utilizados caso existam parametros passados.

        ArrayList<Predicate> predicates = new ArrayList<Predicate>();

        if (StringUtils.hasText(name)) {
            predicates.add(builder.like(root.get("name"), "%" + name + "%"));
        }

        if (shippingFeeStart != null) {
            predicates.add(builder.greaterThanOrEqualTo(root.get("shippingFee"), shippingFeeStart));
        }

        if (shippingFeeEnd != null) {
            predicates.add(builder.lessThanOrEqualTo(root.get("shippingFee"), shippingFeeEnd));
        }

        criteria.where(predicates.toArray(new Predicate[0]));

        TypedQuery<Restaurant> query = manager.createQuery(criteria);
        return query.getResultList();
    }

}
