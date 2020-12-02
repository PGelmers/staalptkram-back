package com.martkplaats.backend.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.martkplaats.backend.model.User;
import com.martkplaats.backend.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

//@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
//@WebMvcTest(UserController.class)
class UserControllerIntTest {

    @Autowired
    private MockMvc mvc;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserController userController;

    // This JacksonTester will make a json out of a new constructed user
    private JacksonTester<User> jsonUser;


    @BeforeEach
    public void setup() {
        // We would need this line if we would not use the MockitoExtension
        //MockitoAnnotations.initMocks(this);
        // Here we can't use @AutoConfigureJsonTesters because there isn't a Spring context
        JacksonTester.initFields(this, new ObjectMapper());
        // MockMvc standalone approach
        mvc = MockMvcBuilders.standaloneSetup(userController)
                .build();
    }


    @Test
    void hello() throws Exception {
        RequestBuilder request = get("/hello");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Hello, World", result.getResponse().getContentAsString());
    }

    @Test
    public void testHelloWithName() throws Exception {
//        mvc.perform(get("/hello?name=Jaap")).andExpect(content().string("Hello, Jaap"));    // Korte versie!
        MvcResult result = mvc.perform(get("/hello?name=Jaap")).andReturn();
        assertEquals("Hello, Jaap", result.getResponse().getContentAsString());
    }

    @Test
    public void testRetrievingUserWithId() throws Exception {
        // given
        given(userRepository.findById(2))
                .willReturn(Optional.of(new User(2, "Jaap", "Gerards")));

        // when
        MvcResult result = mvc.perform(post("/user/2").accept(MediaType.APPLICATION_JSON)).andReturn();

        // then
        assertEquals(result.getResponse().getStatus(), HttpStatus.OK.value());
        assertEquals(result.getResponse().getContentAsString().substring(0, 10),
                jsonUser.write(new User(2, "Jaap", "Gerards")).getJson().substring(0, 10));
    }

}