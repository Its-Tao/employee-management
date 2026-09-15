package com.example.employee_management.controller;

import com.example.employee_management.dto.UserResponseDTO;
import com.example.employee_management.model.User;
import com.example.employee_management.service.UserService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.employee_management.dto.UserRequestDTO;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Add a new user
    @PostMapping
    public UserResponseDTO addUser(@RequestBody UserRequestDTO userRequestDTO) {
        return userService.addUser(userRequestDTO);
    }

    // Get all users
    @GetMapping
    public List<UserResponseDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get one user by ID
    @GetMapping("/{id}")
    public UserResponseDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Update a user
    @PutMapping("/{id}")
    public UserResponseDTO updateUser(
            @PathVariable Long id,
            @RequestBody UserRequestDTO userRequestDTO) {

        return userService.updateUser(id, userRequestDTO);
    }

    // Delete a user
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    // Check whether a user exists
    @RequestMapping(value = "/{id}", method = RequestMethod.HEAD)
    public void checkUser(@PathVariable Long id) {
        userService.getUserById(id);
    }
}