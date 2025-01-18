package com.eduubraga.bigfood.infrastructure.repository;

import com.eduubraga.bigfood.domain.model.Permissions;
import com.eduubraga.bigfood.domain.repository.PermissionsRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PermissionsRepositoryImpl implements PermissionsRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Permissions> all() {
        return manager.createQuery("from Permissions", Permissions.class).getResultList();
    }

    @Override
    public Permissions byId(Long id) {
        return manager.find(Permissions.class, id);
    }

    @Transactional
    @Override
    public Permissions save(Permissions permissions) {
        return manager.merge(permissions);
    }

    @Transactional
    @Override
    public void remove(Permissions permissions) {
        permissions = byId(permissions.getId());
        manager.remove(permissions);
    }

}
