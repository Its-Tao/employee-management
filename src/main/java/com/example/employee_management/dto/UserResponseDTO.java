package com.example.employee_management.dto;

import com.example.employee_management.model.User;

public class UserResponseDTO {

    private Long id;
    private String username;
    private String email;
    private Long employeeId;
    private Long roleId;

    public UserResponseDTO() {
    }

    public UserResponseDTO(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public UserResponseDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();

        if(user.getEmployee() != null) {
            this.employeeId = user.getEmployee().getId();
        }
        if(user.getRole() != null) {
            this.roleId = user.getRole().getId();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getEmployeeId() {
    return employeeId;
}

public Long getRoleId() {
    return roleId;
}
}