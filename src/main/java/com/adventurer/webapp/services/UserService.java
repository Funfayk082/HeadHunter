package com.adventurer.webapp.services;

import com.adventurer.webapp.dto.users.CreateUserRequestDto;
import com.adventurer.webapp.dto.users.GetUserDto;
import com.adventurer.webapp.dto.vacancies.GetVacancyDto;
import com.adventurer.webapp.exceptions.UserNotFoundException;
import com.adventurer.webapp.models.User;
import com.adventurer.webapp.repositories.UserRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final ModelMapper mapper;
    private final UserRepository userRepository;

    public UserService(ModelMapper mapper, UserRepository userRepository) {
        this.mapper = mapper;
        this.userRepository = userRepository;
    }

//    public GetUserDto getUserByEmail(String email) {
//        return mapper.map(
//                userRepository.findUserByAuthUser_Email(email)
//                        .orElseThrow( () -> new UserNotFoundException(email)),
//                GetUserDto.class
//        );
//    }

    public GetUserDto getUserById(Long userId) {
        return mapper.map(
                userRepository.findUserByUserId(userId)
                        .orElseThrow( () -> new UserNotFoundException(userId.toString())),
                GetUserDto.class
        );
    }

    public Long save(CreateUserRequestDto userRequestDto) {
        User user = mapper.map(userRequestDto, User.class);
        return userRepository.save(user).getUserId();
    }

    public List<GetUserDto> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(
                        vacancy -> mapper.map(
                                vacancy,
                                GetUserDto.class
                        )
                ).collect(Collectors.toList());
    }
}
