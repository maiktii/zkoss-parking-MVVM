package com.fif.entity;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "auth")
public class AuthEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;
    private String password;
    private String role;

//    public AuthEntity(Long id, String username, String password, String role){
//        this.id = id;
//        this.username = username;
//        this.password = password;
//        this.role = role;
//    }

    public Long getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
