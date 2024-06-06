package com.example.Library.Repository;

import com.example.Library.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositroy extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByUserId(Long userId);

    Optional<User> findByUsername(String username);

}
