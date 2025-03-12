package com.jonathan.ms_users.infrastructure.mapper;

import com.jonathan.ms_users.domain.entity.User;
import com.jonathan.ms_users.infrastructure.entity.UserEntity;

public class UserMapperInfra {
    public  static UserEntity toEntity(User user){
        return new UserEntity(
                user.getUsername(),
                user.getPassword()
        );
    }

    public static User toDomain(UserEntity userEntity){
        return new User(
                userEntity.getUsername(),
                userEntity.getPassword()
        );
    }
}
