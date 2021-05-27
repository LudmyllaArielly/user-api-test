package com.ludmylla.usertest.resource;

import com.ludmylla.usertest.entities.dto.UserCreateDTO;
import com.ludmylla.usertest.model.entities.User;
import com.ludmylla.usertest.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/users")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;

    }

    @PostMapping
    @ResponseStatus(CREATED)
    public UserCreateDTO createUser (@RequestBody UserCreateDTO userCreateDTO){
    	ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userCreateDTO, User.class);
        user = userService.createUser(user);
        return modelMapper.map(user, UserCreateDTO.class);

    }


}
