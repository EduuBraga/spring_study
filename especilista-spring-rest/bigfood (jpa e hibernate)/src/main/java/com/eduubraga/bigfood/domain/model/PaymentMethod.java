package com.eduubraga.bigfood.domain.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaymentMethod kitchen = (PaymentMethod) o;
        return Objects.equals(id, kitchen.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
