package com.MyLibrary.library.config;


import com.MyLibrary.library.model.dto.NewAuthorDTO;
import com.MyLibrary.library.repository.AuthorRepository;
import com.MyLibrary.library.security.model.Role;
import com.MyLibrary.library.security.model.UserCredentials;
import com.MyLibrary.library.security.repository.RoleRepository;
import com.MyLibrary.library.security.repository.UserRepository;
import com.MyLibrary.library.security.service.UserService;
import com.MyLibrary.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Profile("dev")
public class ApplicationRunnerBean implements ApplicationRunner {


    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        createRoles();
        createUsers();
        createAuthors();
    }

    private void createRoles() {
        Role roleAdmin = new Role(UUID.randomUUID(), "ROLE_ADMIN", "Admin Role");
        Role roleUser = new Role(UUID.randomUUID(), "ROLE_USER", "User Role");

        if (!roleRepository.existsRoleByName(roleAdmin.getName())) {
            roleRepository.save(roleAdmin);
        }

        if (!roleRepository.existsRoleByName(roleUser.getName())) {
            roleRepository.save(roleUser);
        }
    }

    private void createUsers() {
        UserCredentials admin = new UserCredentials("Admin", "Admin");
        UserCredentials user = new UserCredentials("User", "User");

        if (!userRepository.existsUserByUsername(admin.getUsername())) {
            userService.createAdmin(admin);
        }

        if (!userRepository.existsUserByUsername(user.getUsername())) {
            userService.createUser(user);
        }
    }

    private void createAuthors() {
        NewAuthorDTO newAuthorDTO = new NewAuthorDTO("George R.R", "Martin");
        NewAuthorDTO newAuthorDTO2 = new NewAuthorDTO("John R.R", "Tolkien");

        if (!authorRepository.existsAuthorByLastName(newAuthorDTO.getLastName())) {
            authorService.addAuthor(newAuthorDTO);
        }
        if (!authorRepository.existsAuthorByLastName(newAuthorDTO2.getLastName())) {
            authorService.addAuthor(newAuthorDTO2);
        }
    }


}
