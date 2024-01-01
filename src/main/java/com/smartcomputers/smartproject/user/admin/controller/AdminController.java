package com.smartcomputers.smartproject.user.admin.controller;

import com.smartcomputers.smartproject.user.admin.service.AdminService;
import com.smartcomputers.smartproject.user.entity.User;
import com.smartcomputers.smartproject.user.payload.RegisterUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/admins")
@RestController
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<User> createAdministrator(@RequestBody RegisterUserDTO registerUserDto) {
        User createdAdmin = adminService.createAdministrator(registerUserDto);
        return ResponseEntity.ok(createdAdmin);
    }
}
