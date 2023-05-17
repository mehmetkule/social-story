package com.social.story.api.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserResponse {
    private UUID id;
    private String userName;
    private String firstName;
    private String email;
    private String password;

    public UserResponse(UUID id, String userName, String firstName, String email) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.email = email;
    }
}
