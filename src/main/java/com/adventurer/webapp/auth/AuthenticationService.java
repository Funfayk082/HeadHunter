package com.adventurer.webapp.auth;

import com.adventurer.webapp.config.security.JwtService;
import com.adventurer.webapp.dto.AccessTokenDto;
import com.adventurer.webapp.dto.RefreshTokenDto;
import com.adventurer.webapp.dto.Token;
import com.adventurer.webapp.dto.auth.AuthUserDto;
import com.adventurer.webapp.dto.users.CreateUserRequestDto;
import com.adventurer.webapp.exceptions.UserNotFoundException;
import com.adventurer.webapp.models.AuthUser;
import com.adventurer.webapp.models.User;
import com.adventurer.webapp.repositories.AuthUserRepository;
import com.adventurer.webapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AuthUserRepository repository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final ModelMapper mapper;
    public Token register(CreateUserRequestDto request) {
        var authUser = AuthUser.builder()
                .email(request.getEmail())
                .login(request.getLogin())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole()).build();
        var user = User.builder()
                .surname(request.getSurname())
                .name(request.getName())
                .patronymic(request.getPatronymic())
                .dateOfBirth(request.getDateOfBirth())
                .gender(request.getGender())
                .auth(authUser)
                .build();
        userRepository.save(user);


        var accessToken = jwtService.generateAccessToken(request.getLogin(), String.valueOf(request.getRole()));
        var refreshToken = jwtService.generateRefreshToken(request.getLogin());
        return new Token(accessToken, refreshToken);
    }

    public Token login(AuthUserDto request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getPassword()
                )
        );
        var user = repository.findAuthUserByLogin(request.getLogin())
                .orElseThrow(
                        () -> new UserNotFoundException(request.getLogin())
                );
        var accessToken = jwtService.generateAccessToken(user.getLogin(), String.valueOf(user.getRole()));
        var refreshToken = jwtService.generateRefreshToken(user.getLogin());
        return new Token(accessToken, refreshToken);
    }

    public Token refresh(String refreshToken) {
        var login = jwtService.extractLogin(refreshToken);
        var role = jwtService.extractRole(refreshToken);
        var accessToken = jwtService.generateAccessToken(login, role);
        var newRefreshToken = jwtService.generateRefreshToken(login);
        return new Token(accessToken, newRefreshToken);
    }
}
