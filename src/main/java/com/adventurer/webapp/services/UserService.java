package com.adventurer.webapp.services;

import com.adventurer.webapp.dto.users.CreateUserRequestDto;
import com.adventurer.webapp.dto.users.GetUserDto;
import com.adventurer.webapp.exceptions.UserNotFoundException;
import com.adventurer.webapp.models.User;
import com.adventurer.webapp.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final ModelMapper mapper;
    private final UserRepository userRepository;

    public UserService(ModelMapper mapper, UserRepository userRepository) {
        this.mapper = mapper;
        this.userRepository = userRepository;
    }

    public GetUserDto getUserByEmail(String email) {
        return mapper.map(
                userRepository.findUserByEmail(email)
                        .orElseThrow( () -> new UserNotFoundException(email)),
                GetUserDto.class
        );
    }

    public Long save(CreateUserRequestDto userRequestDto) {
        User user = mapper.map(userRequestDto, User.class);
        return userRepository.save(user).getId();
    }
}
