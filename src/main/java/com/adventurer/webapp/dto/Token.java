package com.adventurer.webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Token {
    private AccessTokenDto accessToken;
    private RefreshTokenDto refreshToken;
}
