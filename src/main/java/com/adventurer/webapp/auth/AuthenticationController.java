package com.adventurer.webapp.auth;

import com.adventurer.webapp.dto.AccessTokenDto;
import com.adventurer.webapp.dto.auth.AuthUserDto;
import com.adventurer.webapp.dto.users.CreateUserRequestDto;
import lombok.RequiredArgsConstructor;
import org.postgresql.replication.fluent.ChainedCreateReplicationSlotBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<AccessTokenDto> register(@RequestBody CreateUserRequestDto request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AccessTokenDto> login(@RequestBody AuthUserDto request) {
        return ResponseEntity.ok(authenticationService.login(request));
    }
}
