package com.careerplatform.user.controller;

import com.careerplatform.user.dto.RegisterRequest;
import com.careerplatform.user.dto.UserResponse;
import com.careerplatform.user.entity.User;
import com.careerplatform.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest request){
        if (userService.existsByEmail(request.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        User savedUser = userService.createUser(user);

        UserResponse response = new UserResponse(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getCreatedAt(),
                savedUser.getUpdatedAt()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
