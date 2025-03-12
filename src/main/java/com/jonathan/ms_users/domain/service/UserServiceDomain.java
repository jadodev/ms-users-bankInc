package com.jonathan.ms_users.domain.service;

import com.jonathan.ms_users.domain.entity.User;
import com.jonathan.ms_users.domain.port.in.UserInterfacePortIn;
import com.jonathan.ms_users.domain.port.out.UserInterfacePortOut;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceDomain implements UserInterfacePortIn {
    private final UserInterfacePortOut userInterfacePortOut;

    public UserServiceDomain(UserInterfacePortOut userInterfacePortOut) {
        this.userInterfacePortOut = userInterfacePortOut;
    }

    @Override
    public User create(User user) {
        return userInterfacePortOut.save(user);
    }

    @Override
    public Optional<User> getUserById(long id) {
        return userInterfacePortOut.getUserById(id);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userInterfacePortOut.getUserByUsername(username);
    }
}
