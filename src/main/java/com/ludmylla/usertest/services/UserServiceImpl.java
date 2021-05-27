package com.ludmylla.usertest.services;

import com.ludmylla.usertest.model.entities.User;
import com.ludmylla.usertest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);

    }
}
