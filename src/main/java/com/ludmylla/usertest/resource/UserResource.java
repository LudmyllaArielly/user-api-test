package com.ludmylla.usertest.resource;

import com.ludmylla.usertest.entities.User;
import com.ludmylla.usertest.entities.dto.UserCreateDTO;
import com.ludmylla.usertest.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/users")
public class UserResource {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserResource(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<UserCreateDTO> createUser (@RequestBody UserCreateDTO userCreateDTO){
        User user = modelMapper.map(userCreateDTO, User.class);
        user = userService.createUser(user);
        modelMapper.map(user, UserCreateDTO.class);
        return ResponseEntity.badRequest().build();
    }


}
