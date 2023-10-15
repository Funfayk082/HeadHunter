package com.adventurer.webapp.repos;

import com.adventurer.webapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
