package com.jonathan.ms_users.domain.port.in;

import com.jonathan.ms_users.domain.entity.User;

import java.util.Optional;

public interface UserInterfacePortIn {
    User create(User user);
    Optional<User>getUserById(long id);
}
