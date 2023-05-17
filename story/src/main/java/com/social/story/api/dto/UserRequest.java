package com.social.story.api.dto;

import lombok.Data;

@Data
public class UserRequest {
    private String userName;
    private String firstName;
    private String email;
    private String password;

}
