package com.adventurer.webapp.dto.auth;

import com.adventurer.webapp.models.Role;
import lombok.Data;

@Data
public class AuthUserDto {
    private String login;
    private String password;
    private Role role;
}
