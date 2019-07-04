package com.MyLibrary.library.security.service;


import com.MyLibrary.library.security.model.Role;
import com.MyLibrary.library.security.model.RoleName;
import com.MyLibrary.library.security.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role getUserRole() {
        return roleRepository.findByName(RoleName.ROLE_USER.name());
    }

    public Role getAdminRole() {
        return roleRepository.findByName(RoleName.ROLE_ADMIN.name());
    }


}
