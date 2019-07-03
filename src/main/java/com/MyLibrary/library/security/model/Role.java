package com.MyLibrary.library.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private String name;

    @Column
    private String description;

    @OneToMany(mappedBy = "roles", cascade = CascadeType.ALL)
    private List<User> users = new ArrayList<>();

    public Role() {
    }

    public Role(UUID id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

}
