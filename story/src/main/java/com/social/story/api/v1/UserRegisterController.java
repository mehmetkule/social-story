package com.social.story.api.v1;
import com.social.story.api.dto.UserRequest;
import com.social.story.api.dto.UserResponse;
import com.social.story.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/1")
public class UserRegisterController {
    private static  final  Logger log = LoggerFactory.getLogger(UserRegisterController.class);
    public final UserService userService;

    public UserRegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserResponse CreateUser(@RequestBody UserRequest user) {
        return  userService.createUser(user);
    }
}
