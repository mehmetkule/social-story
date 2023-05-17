package com.social.story.service;

import com.social.story.api.dto.UserRequest;
import com.social.story.api.dto.UserResponse;
import com.social.story.db.User;
import com.social.story.db.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    public static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserResponse createUser(UserRequest request){
        logger.info("Creating a new user:" + request.getEmail() + " first name:" + request.getFirstName());
        Optional<User> userOptional = userRepository.findUserByEmail(request.getEmail());
        if(userOptional.isPresent()){
            logger.info("User already exists:" + request.getEmail());
            throw new RuntimeException("User already exists:" + request.getEmail());
        }
        User user = new User(request.getUserName(),request.getFirstName(),request.getEmail(),request.getPassword());
        if (user.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        user = userRepository.save(user);

        return new UserResponse(user.getId(),user.getUserName(),user.getFirstName(),user.getEmail());
    }
}
