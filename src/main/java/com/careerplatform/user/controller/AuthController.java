package com.careerplatform.user.controller;

import com.careerplatform.user.dto.LoginRequest;
import com.careerplatform.user.dto.LoginResponse;
import com.careerplatform.user.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest request) {

        LoginResponse response = authService.login(request);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}
