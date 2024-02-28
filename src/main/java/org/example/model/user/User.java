package org.example.model.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Document(collection = "users")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private LocalDateTime createdUser;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private List<RoleEnum> roles;


    public User(String name, String lastName, String email, String password) {
        this.createdUser = LocalDateTime.now();
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = new ArrayList<>(Collections.singleton(RoleEnum.USER));
    }


    public String getId() {
        return id;
    }

    public LocalDateTime getCreatedUser() {
        return createdUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RoleEnum> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEnum> roles) {
        this.roles = roles;
    }

    public void addRole(RoleEnum role) {
        if (!roles.contains(role)) {
            roles.add(role);
        }
    }
    public void updateUser(User user){
        setName(user.getName());
        setLastName(user.getLastName());
            }
}
