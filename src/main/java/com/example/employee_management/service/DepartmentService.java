package com.example.employee_management.service;

import com.example.employee_management.model.Department;
import com.example.employee_management.repository.DepartmentRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    // Get all departments
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // Add a new department
    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(Long id) {
    return departmentRepository.findById(id)
            .orElseThrow(() ->
                    new RuntimeException("Department not found with ID: " + id));
}
}
