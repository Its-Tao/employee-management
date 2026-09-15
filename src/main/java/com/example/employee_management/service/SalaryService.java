package com.example.employee_management.service;

import com.example.employee_management.model.Employee;
import com.example.employee_management.model.Salary;
import com.example.employee_management.repository.EmployeeRepository;
import com.example.employee_management.repository.SalaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryService {

    private final SalaryRepository salaryRepository;
    private final EmployeeRepository employeeRepository;

    public SalaryService(
            SalaryRepository salaryRepository,
            EmployeeRepository employeeRepository) {

        this.salaryRepository = salaryRepository;
        this.employeeRepository = employeeRepository;
    }

    public Salary addSalary(Long employeeId, Salary salary) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new RuntimeException("Employee not found with ID: " + employeeId));

        salary.setEmployee(employee);

        return salaryRepository.save(salary);
    }

    public List<Salary> getAllSalaries() {
        return salaryRepository.findAll();
    }

    public Salary getSalaryById(Long id) {
        return salaryRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Salary not found with ID: " + id));
    }

    public void deleteSalary(Long id) {
        salaryRepository.deleteById(id);
    }
}