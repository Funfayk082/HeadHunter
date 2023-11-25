package com.adventurer.webapp.repos;

import com.adventurer.webapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
//    @Query()
//    public Optional<User> findByEmail(String email);
}
