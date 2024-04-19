package com.adventurer.webapp.services;

import com.adventurer.webapp.dto.auth.AuthUserDto;
import com.adventurer.webapp.exceptions.UserNotFoundException;
import com.adventurer.webapp.repositories.AuthUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthUserService {
    private final ModelMapper mapper;
    private final AuthUserRepository authUserRepository;

    public AuthUserService(ModelMapper mapper, AuthUserRepository authUserRepository) {
        this.mapper = mapper;
        this.authUserRepository = authUserRepository;
    }

    public UserDetails getUserByLogin(String login) {
        return mapper.map(
                authUserRepository.findAuthUserByLogin(login)
                        .orElseThrow(() -> new UserNotFoundException(login)),
                UserDetails.class
        );
    }
}
