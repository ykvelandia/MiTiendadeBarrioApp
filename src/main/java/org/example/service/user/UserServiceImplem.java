package org.example.service.user;


import org.example.dto.user.UserDto;
import org.example.dto.user.UserMapper;
import org.example.dto.user.UserResponseDto;
import org.example.model.user.RoleEnum;
import org.example.model.user.User;
import org.example.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImplem implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        userRepository.getAllUsers().forEach(user -> userResponseDtos.add(UserMapper.userToUserResponseDto(user)));
        //userRepository.getAllUsers().forEach(user -> userResponseDtos.add(new UserResponseDto(user)));
        return userResponseDtos;
    }

    @Override
    public UserResponseDto findUserById(String id) {
        return UserMapper.userToUserResponseDto(userRepository.findUserById(id));
    }

    @Override
    public User findByEmail(String email) {
        User userFound = userRepository.findByEmail(email).get();
        if (userFound != null){
            return userFound;
        }
        return null;
    }

    @Override
    public UserResponseDto createUser(UserDto userDto) {
        return UserMapper.userToUserResponseDto(userRepository.createUser(UserMapper.userDtoToUser(userDto)));
    }

    @Override
    public UserResponseDto createUserAdmin(UserDto userDto) {
        User userAdmin = UserMapper.userDtoToUser(userDto);
        userAdmin.addRole(RoleEnum.ADMIN);
        return UserMapper.userToUserResponseDto(userRepository.createUser(userAdmin));
    }

    @Override
    public UserResponseDto saveUser(UserDto userDto) {
        return null;
    }

    @Override
    public Boolean updateUser(String id, UserDto userDto) {
        return userRepository.updateUser(id, UserMapper.userDtoToUser(userDto));
        //return userRepository.updateUser(id, new User(userDto));
    }

    @Override
    public Boolean deleteUserById(String id) {
        return userRepository.deleteUserById(id);
    }
}
