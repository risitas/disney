package com.alkemy.disney.repository;

import com.alkemy.disney.model.Rol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends CrudRepository<Rol,Long> {
    Optional<Rol> findByRolName(String rolName);
    void deleteByRolName(String rolName);

}
