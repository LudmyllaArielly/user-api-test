package com.ludmylla.usertest.resource;

import static org.springframework.http.HttpStatus.CREATED;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ludmylla.usertest.mapper.UserMapper;
import com.ludmylla.usertest.model.entities.User;
import com.ludmylla.usertest.model.entities.dto.UserCreateDTO;
import com.ludmylla.usertest.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;

    }

    @PostMapping
    //@ResponseStatus(CREATED)
    public ResponseEntity<UserCreateDTO> createUser (@RequestBody UserCreateDTO userCreateDTO){
    	User user = UserMapper.INSTANCE.toUser(userCreateDTO);
    	userService.createUser(user);
    	//return userCreateDTO;
        return ResponseEntity.status(CREATED).body(userCreateDTO);



    }


}
