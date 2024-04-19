package com.adventurer.webapp.repositories;

import com.adventurer.webapp.models.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {
    Optional<AuthUser> findAuthUserByLogin(String login);

}
