package com.example.employee_management.service;

import com.example.employee_management.model.Role;
import com.example.employee_management.repository.RoleRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    // CREATE
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    // READ ALL
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    // READ ONE
    public Role getRoleById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Role not found with ID: " + id));
    }

    // UPDATE
    public Role updateRole(Long id, Role updatedRole) {

        Optional<Role> optionalRole = roleRepository.findById(id);

        if (optionalRole.isPresent()) {

            Role role = optionalRole.get();

            role.setName(updatedRole.getName());
            role.setDescription(updatedRole.getDescription());

            return roleRepository.save(role);
        }

        throw new RuntimeException(
                "Role not found with ID: " + id
        );
    }

    // DELETE
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}