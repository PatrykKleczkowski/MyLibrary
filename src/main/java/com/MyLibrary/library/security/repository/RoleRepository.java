package com.MyLibrary.library.security.repository;


import com.MyLibrary.library.security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByName(String name);
    boolean existsRoleByName(String name);

}
