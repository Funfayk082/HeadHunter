package com.adventurer.webapp.controllers;

import com.adventurer.webapp.dto.users.CreateUserRequestDto;
import com.adventurer.webapp.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<?> getUserByEmail(@RequestParam(required = false) String email) {
//        if (email != null) {
//            return ResponseEntity.ok(userService.getUserByEmail(email));
//        }
        return ResponseEntity.ok(userService.getUsers());
    }

    @PostMapping("/users")
    public ResponseEntity<?> addUser(@RequestBody CreateUserRequestDto user) {
        return ResponseEntity.ok(userService.save(user));
    }
}
