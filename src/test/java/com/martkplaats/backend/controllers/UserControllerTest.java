package com.martkplaats.backend.controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    @Test
    void hello() {
        UserController userController = new UserController(); // Arrange
        String response = userController.hello("World");// Act
        assertEquals("Hello, World", response); // Assert
            }
}