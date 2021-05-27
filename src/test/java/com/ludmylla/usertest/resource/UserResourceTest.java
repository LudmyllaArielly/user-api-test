package com.ludmylla.usertest.resource;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ludmylla.usertest.entities.User;
import com.ludmylla.usertest.entities.dto.UserCreateDTO;
import com.ludmylla.usertest.services.UserService;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@WebMvcTest
public class UserResourceTest {
    
    static String USER_API = "/users";

    LocalDate date = LocalDate.of(2021, 5, 26);
    
    @Autowired
    MockMvc mvc;
    
    @MockBean
    UserService userService;
    
    @Test
    @DisplayName("Create a user successfully")
    public void createUserTest() throws Exception{
        UserCreateDTO dto = createNewUser();

        User userSaved = User.builder()
                .firstName("Maria")
                .lastName("Silva")
                .cpf("123")
                .dateOfBirth(date)
                .build();

        BDDMockito.given(userService.createUser(Mockito.any(User.class))).willReturn(userSaved);
        String json = new ObjectMapper().writeValueAsString(dto);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(USER_API)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);

        mvc.perform(request)
                .andExpect(status().isCreated())
                //.andExpect(jsonPath("id").isNotEmpty())
                .andExpect(jsonPath("firstName").value(dto.getFirstName()))
                .andExpect(jsonPath("lastName").value(dto.getLastName()))
                .andExpect(jsonPath("cpf").value(dto.getCpf()))
                .andExpect(jsonPath("dateOfBirth", is(LocalDate.of(2021, 5, 26).toString())));
             

    }

    private UserCreateDTO createNewUser() {
       return UserCreateDTO.builder()
                .id(1L)
                .firstName("Maria")
                .lastName("Silva")
                .cpf("123")
                .dateOfBirth(date)
                .build();
    }
}
