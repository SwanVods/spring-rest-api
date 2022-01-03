package com.feirasoft.userservice.repository;

import com.feirasoft.userservice.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User getDistinctTopByUsername(String username);
}
