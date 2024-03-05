package org.example.dto.user;


import org.example.model.user.User;

public class UserMapper {

    public static UserResponseDto userToUserResponseDto(User user){
        return new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getLastName(),
                user.getEmail()
        );
    }

    public static User userDtoToUser(UserDto userDto){
        return new User(
                userDto.getName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getPassword()
        );
    }
}
