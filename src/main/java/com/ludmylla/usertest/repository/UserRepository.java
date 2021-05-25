package com.ludmylla.usertest.repository;

import com.ludmylla.usertest.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
