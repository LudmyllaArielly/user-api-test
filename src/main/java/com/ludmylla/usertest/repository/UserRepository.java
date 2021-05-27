package com.ludmylla.usertest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ludmylla.usertest.model.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
