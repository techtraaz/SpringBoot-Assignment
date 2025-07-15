package com.assignement.repo;

import com.assignement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Integer> {

    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
}


