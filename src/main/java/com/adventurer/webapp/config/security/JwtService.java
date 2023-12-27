package com.adventurer.webapp.config.security;

import com.adventurer.webapp.dto.AccessTokenDto;
import com.adventurer.webapp.dto.RefreshTokenDto;
import io.jsonwebtoken.Claims;

import java.util.function.Function;

public interface JwtService {
    AccessTokenDto generateAccessToken(Long userId, String role);

    RefreshTokenDto generateRefreshToken(Long userId);

    String extractId(String jwtToken);

    <T> T extractClaim(String jwtToken, Function<Claims, T> claimsResolver);

    String extractRole(String jwtToken);

    boolean isValidToken(String jwtToken);
}
