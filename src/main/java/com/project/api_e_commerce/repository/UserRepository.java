package com.project.api_e_commerce.repository;

import com.project.api_e_commerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    boolean existsByMobile(Long mobile);

    Optional<User> findByEmail(String email);
}
