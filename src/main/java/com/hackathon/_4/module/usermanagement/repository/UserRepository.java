package com.hackathon._4.module.usermanagement.repository;

import com.hackathon._4.module.usermanagement.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
