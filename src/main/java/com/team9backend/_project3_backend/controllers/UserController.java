package com.team9backend._project3_backend.controllers;

import com.team9backend._project3_backend.dto.UserResponseDto;
import com.team9backend._project3_backend.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<UserResponseDto> getMe() {
        String email = "test@example.com"; //hardcoded but once OAuth is set up we can replace it here.
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }
}