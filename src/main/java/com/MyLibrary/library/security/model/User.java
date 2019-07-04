package com.MyLibrary.library.security.model;

import com.MyLibrary.library.model.Hire;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@Where(clause = "active = true")
@Table(name = "user_entity")
public class User {

    @Id
    @GeneratedValue
    @NonNull
    private UUID id;

    @NonNull
    private String username;

    @JsonIgnore
    @NonNull
    private String password;

    private boolean banned = false;
    private boolean active = true;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private LocalDateTime registered;

    @JoinColumn(name = "last_login")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private LocalDateTime lastLogin;

    @JsonIgnore
    @ManyToOne
    @NonNull
    @JoinColumn(name = "id_role")
    private Role roles;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Hire> hireList = new ArrayList<>();


    public User() {
    }

    public User(UUID id, String username, String password, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = role;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isBanned() {
        return this.banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDateTime registered) {
        this.registered = registered;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    public List<Hire> getHireList() {
        return hireList;
    }

    public void setHireList(List<Hire> hireList) {
        this.hireList = hireList;
    }
}
