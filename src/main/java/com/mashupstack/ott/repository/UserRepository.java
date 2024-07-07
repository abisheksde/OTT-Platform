package com.mashupstack.ott.repository;

import com.mashupstack.ott.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByRole(String role);

    User findByEmail(String name);
}
