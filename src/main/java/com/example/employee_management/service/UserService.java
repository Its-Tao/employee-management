package com.example.employee_management.service;

import com.example.employee_management.dto.UserResponseDTO;
import com.example.employee_management.model.User;
import com.example.employee_management.repository.UserRepository;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import com.example.employee_management.dto.UserRequestDTO;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO addUser(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setUsername(userRequestDTO.getUsername());
        user.setPassword(userRequestDTO.getPassword());
        user.setEmail(userRequestDTO.getEmail());

        User savedUser = userRepository.save(user);
        return new UserResponseDTO(savedUser);
    }

    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserResponseDTO::new)
                .toList();
    }

    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found with ID: " + id));

        return new UserResponseDTO(user);
    }

    public UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO) {

        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            user.setUsername(userRequestDTO.getUsername());
            user.setPassword(userRequestDTO.getPassword());
            user.setEmail(userRequestDTO.getEmail());

            User savedUser = userRepository.save(user);
            return new UserResponseDTO(savedUser);
        }

        throw new RuntimeException("User not found with ID: " + id);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}