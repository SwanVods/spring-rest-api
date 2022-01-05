package com.feirasoft.authservice.repository;

import com.feirasoft.authservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getDistinctTopByUsername(String username);
    User findUserByEmail(String email);
    User findUserByUsername(String username);
    User findUserById(Long id);
}
