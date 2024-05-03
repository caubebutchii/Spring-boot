package com.namvu.projectfinal.repository;

import com.namvu.projectfinal.entity.User;
import com.sun.jdi.StringReference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}
