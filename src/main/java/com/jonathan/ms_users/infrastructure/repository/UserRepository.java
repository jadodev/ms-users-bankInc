package com.jonathan.ms_users.infrastructure.repository;

import com.jonathan.ms_users.domain.entity.User;
import com.jonathan.ms_users.domain.port.out.UserInterfacePortOut;
import com.jonathan.ms_users.infrastructure.entity.UserEntity;
import com.jonathan.ms_users.infrastructure.mapper.UserMapperInfra;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository implements UserInterfacePortOut {
    private final UserRepositoryJpa userRepository;

    public UserRepository(UserRepositoryJpa userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = UserMapperInfra.toEntity(user);
        return UserMapperInfra.toDomain(userRepository.save(userEntity));
    }

    @Override
    public Optional<User> getUserById(long id) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);
        return userEntityOptional.map(UserMapperInfra::toDomain);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        Optional<UserEntity> userEntityOptional = userRepository.findByUsername(username);
        return userEntityOptional.map(UserMapperInfra::toDomain);
    }
}
