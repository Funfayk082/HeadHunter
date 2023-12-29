package com.adventurer.webapp.config.security;

import com.adventurer.webapp.dto.AccessTokenDto;
import com.adventurer.webapp.dto.RefreshTokenDto;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.function.Function;

public interface JwtService {
    String extractLogin(String jwtToken);
    AccessTokenDto generateAccessToken(String login, String role);

    RefreshTokenDto generateRefreshToken(String login);

    String extractId(String jwtToken);

    <T> T extractClaim(String jwtToken, Function<Claims, T> claimsResolver);

    String extractRole(String jwtToken);

    boolean isValidToken(String jwtToken, UserDetails userDetails);
}
