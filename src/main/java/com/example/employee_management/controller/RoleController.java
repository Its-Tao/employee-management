package com.example.employee_management.controller;

import com.example.employee_management.model.Role;
import com.example.employee_management.service.RoleService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    // CREATE
    @PostMapping
    public Role addRole(@RequestBody Role role) {
        return roleService.addRole(role);
    }

    // READ ALL
    @GetMapping
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable Long id) {
        return roleService.getRoleById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Role updateRole(
            @PathVariable Long id,
            @RequestBody Role role) {

        return roleService.updateRole(id, role);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
    }

    // HEAD
    @RequestMapping(value = "/{id}", method = RequestMethod.HEAD)
    public void checkRole(@PathVariable Long id) {
        roleService.getRoleById(id);
    }
}