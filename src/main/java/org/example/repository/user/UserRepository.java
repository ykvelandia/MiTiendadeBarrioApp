package org.example.repository.user;

import org.example.model.user.User;

import java.util.List;

public interface UserRepository {
    List<User> getAllUsers();

    User findUserById(String id);

    User saveUser(User user);

    Boolean updateUser(String id, User user);

    Boolean deleteUserById(String id);
}
