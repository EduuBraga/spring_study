package com.eduubraga.bigfood.domain.repository;

import com.eduubraga.bigfood.domain.model.Permissions;

import java.util.List;

public interface PermissionsRepository {

    List<Permissions> all();
    Permissions byId(Long id);
    Permissions add(Permissions permissions);
    void remove(Permissions permissions);

}
