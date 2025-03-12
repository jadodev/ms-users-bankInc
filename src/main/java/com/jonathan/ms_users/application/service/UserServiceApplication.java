package com.jonathan.ms_users.application.service;

import com.jonathan.ms_users.application.dto.UserDto;
import com.jonathan.ms_users.application.mapper.UserMapper;
import com.jonathan.ms_users.domain.entity.User;
import com.jonathan.ms_users.domain.service.UserServiceDomain;

import java.util.Optional;

public class UserServiceApplication {
    private final UserServiceDomain userServiceDomain;

    public UserServiceApplication(UserServiceDomain userServiceDomain) {
        this.userServiceDomain = userServiceDomain;
    }

    public UserDto create(UserDto userDto){
        User user = UserMapper.toDomain(userDto);
        User create = userServiceDomain.create(user);
        return UserMapper.toDto(create);
    }

    public Optional<UserDto> getById(long id){
        Optional<User> user = userServiceDomain.getUserById(id);
        if (user.isPresent()){
            return Optional.of(UserMapper.toDto(user.get()));
        }else {
            throw new RuntimeException("Usuario no encontrado");
        }
    }
}
