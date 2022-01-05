package com.feirasoft.authservice.repository;

import com.feirasoft.authservice.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserProfile, Long> {
}
