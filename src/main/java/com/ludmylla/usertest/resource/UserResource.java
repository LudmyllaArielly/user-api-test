package com.ludmylla.usertest.resource;

import static org.springframework.http.HttpStatus.CREATED;
import org.springframework.web.bind.annotation.*;

import com.ludmylla.usertest.mapper.UserMapper;
import com.ludmylla.usertest.model.entities.User;
import com.ludmylla.usertest.model.entities.dto.UserCreateDTO;
import com.ludmylla.usertest.services.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public User createUser (@Valid @RequestBody UserCreateDTO userCreateDTO){
        User user = UserMapper.INSTANCE.toUser(userCreateDTO);
        return userService.createUser(user);

    }


}
