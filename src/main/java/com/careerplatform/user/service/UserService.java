package com.careerplatform.user.service;


import com.careerplatform.user.entity.User;
import com.careerplatform.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import  java.util.Optional;

@Service
public class UserService {
   private final UserRepository userRepository;
   private final PasswordEncoder passwordEncoder;

   public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
       this.userRepository = userRepository;
       this.passwordEncoder = passwordEncoder;
   }

   public User createUser(User user){
       user.setPassword(passwordEncoder.encode(user.getPassword()));

       user.setCreatedAt(LocalDateTime.now());
       user.setUpdatedAt(LocalDateTime.now());

       return userRepository.save(user);
   }

   public Optional<User> findByEmail(String email){
       return userRepository.findByEmail(email);
   }

   public boolean existsByEmail(String email){
       return userRepository.existsByEmail(email);
   }
}
