package org.example.service.user;

import org.example.model.dto.user.UserDto;
import org.example.model.dto.user.UserResponseDto;
import org.example.model.user.User;

import java.util.List;

public interface UserService {
    List<UserResponseDto> getAllUsers();

    UserResponseDto findUserById(String id);
    User findByEmail(String email);

    UserResponseDto saveUser(UserDto userDto);

    Boolean updateUser(String id, UserDto userDto);

    Boolean deleteUserById(String id);
}
