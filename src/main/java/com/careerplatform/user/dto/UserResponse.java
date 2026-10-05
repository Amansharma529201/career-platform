package com.careerplatform.user.dto;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UserResponse(){}

    public UserResponse(
            Long id,
            String name,
            String email,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ){
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
