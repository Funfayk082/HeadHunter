package com.adventurer.webapp.repositories;

import com.adventurer.webapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
//    Optional<User> findUserByAuthUser_Email(String email);

    Optional<User> findUserByUserId(Long userId);

}
