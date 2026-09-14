package com.example.employee_management.service;

import com.example.employee_management.model.User;
import com.example.employee_management.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found with ID: " + id));
    }

    public User updateUser(Long id, User updatedUser) {

        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {

            User user = optionalUser.get();

            user.setUsername(updatedUser.getUsername());
            user.setPassword(updatedUser.getPassword());
            user.setEmail(updatedUser.getEmail());

            return userRepository.save(user);
        }

        throw new RuntimeException(
                "User not found with ID: " + id
        );
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}