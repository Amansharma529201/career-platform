package com.careerplatform.user.service;

import com.careerplatform.user.dto.LoginRequest;
import com.careerplatform.user.dto.LoginResponse;
import com.careerplatform.user.entity.User;
import com.careerplatform.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final  UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public LoginResponse login(LoginRequest request){
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!passwordEncoder.matches(request.getPassword(),user.getPassword())){
            throw new RuntimeException("Invalid email or password");
        }
        LoginResponse response = new LoginResponse();

        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());

        return response;
    }
}
