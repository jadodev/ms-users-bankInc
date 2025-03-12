package com.jonathan.ms_users.domain.port.out;

import com.jonathan.ms_users.domain.entity.User;

import java.util.Optional;

public interface UserInterfacePortOut {
    User save(User user);
    Optional<User> getUserById(long id);
    Optional<User>getUserByUsername(String username);

}
