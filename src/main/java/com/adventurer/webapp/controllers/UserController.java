package com.adventurer.webapp.controllers;

import com.adventurer.webapp.dto.users.CreateUserRequestDto;
import com.adventurer.webapp.services.UserService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.beans.ConstructorProperties;


@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    @Secured("ROLE_ADMIN")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Получить пользователя по E-Mail (или всех пользователей)",
                    content = {
                            @Content(mediaType = "application/json")
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "НЕТ ТУТ НИКОГО ТЫ ПОНИМАЕШЬ????",
                    content = {
                            @Content(mediaType = "application/json")
                    }
            )
    })
    public ResponseEntity<?> getUserByEmail(@RequestParam(required = false) String email) {
//        if (email != null) {
//            return ResponseEntity.ok(userService.getUserByEmail(email));
//        }
        return ResponseEntity.ok(userService.getUsers());
    }

    @PostMapping("/users")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Пользователь успешно создан",
                    content = {
                            @Content(mediaType = "application/json")
                    }
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Плохой пользователь",
                    content = {
                            @Content(mediaType = "application/json")
                    }
            )
    })
    public ResponseEntity<?> addUser(@RequestBody CreateUserRequestDto user) {
        return ResponseEntity.ok(userService.save(user));
    }
}
