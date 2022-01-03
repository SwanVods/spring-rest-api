package com.feirasoft.authservice.repository;


import com.feirasoft.authservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User getDistinctTopByUsername(String username);
}
