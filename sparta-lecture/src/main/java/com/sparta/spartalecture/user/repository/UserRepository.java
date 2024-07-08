package com.sparta.spartalecture.user.repository;

import com.sparta.spartalecture.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
