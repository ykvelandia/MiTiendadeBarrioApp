package org.example.service.user;

import org.example.dto.user.UserDto;
import org.example.dto.user.UserResponseDto;
import org.example.model.user.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserResponseDto> getAllUsers();

    Optional<UserResponseDto> findUserById(String id);
    User findByEmail(String email);
    UserResponseDto createUser(UserDto userDto);
    UserResponseDto createUserAdmin(UserDto userDto);

    UserResponseDto saveUser(UserDto userDto);

    Boolean updateUser(String id, UserDto userDto);

    Boolean deleteUserById(String id);
}
