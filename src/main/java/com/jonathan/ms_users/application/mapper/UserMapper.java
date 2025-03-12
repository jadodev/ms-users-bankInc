package com.jonathan.ms_users.application.mapper;

import com.jonathan.ms_users.application.dto.UserDto;
import com.jonathan.ms_users.domain.entity.User;

public class UserMapper {
    public static UserDto toDto (User user){
        return new UserDto(
                user.getUsername(),
                user.getPassword()
        );
    }

    public  static User toDomain (UserDto userDto){
        return new User(
                userDto.getUsername(),
                userDto.getPassword()
        );
    }
}
