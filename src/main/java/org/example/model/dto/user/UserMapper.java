package org.example.model.dto.user;

import org.example.model.user.User;

public class UserMapper {
    public static UserResponseDto user_To_UserResponseDto(User user){
        return new UserResponseDto(
                user.getName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword()
        );
    }

    public static User userDto_To_User (UserDto userDto){
        return new User(
                userDto.getName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getPassword()
        );
    }
}
