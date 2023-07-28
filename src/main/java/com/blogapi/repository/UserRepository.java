package com.blogapi.repository;

import com.blogapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public boolean existsByUsername(String username);

    public boolean existsByEmail(String email);

    public Optional<User> findByEmail(String email);

    public Optional<User> findByUsername(String username);

    public Optional<User> findByUsernameOrEmail(String username, String email);
}
