package com.feirasoft.userservice.repository;

import com.feirasoft.userservice.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
