package com.example.employee_management.controller;

import com.example.employee_management.model.Salary;
import com.example.employee_management.service.SalaryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salaries")
public class SalaryController {

    private final SalaryService salaryService;

    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @PostMapping("/employee/{employeeId}")
    public Salary addSalary(
            @PathVariable Long employeeId,
            @RequestBody Salary salary) {

        return salaryService.addSalary(employeeId, salary);
    }

    @GetMapping
    public List<Salary> getAllSalaries() {
        return salaryService.getAllSalaries();
    }

    @GetMapping("/{id}")
    public Salary getSalaryById(@PathVariable Long id) {
        return salaryService.getSalaryById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteSalary(@PathVariable Long id) {
        salaryService.deleteSalary(id);
    }
}