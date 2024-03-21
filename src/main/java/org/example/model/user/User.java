package org.example.model.user;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Document(collection = "users")
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private LocalDateTime createdUser;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private List<RolesEnum> roles;

    public User(String name, String lastName, String email, String password) {
        this.createdUser = LocalDateTime.now();
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.roles = new ArrayList<>(Collections.singleton(RolesEnum.USER));
    }
    public User(String id, String name, String lastName, String email, String password) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.roles = new ArrayList<>(Collections.singleton(RolesEnum.ADMIN));

    }
    public User() {
    }
    public void addRole(RolesEnum role){
        if(!roles.contains(role)){
            roles.add(role);
        }
    }
}
