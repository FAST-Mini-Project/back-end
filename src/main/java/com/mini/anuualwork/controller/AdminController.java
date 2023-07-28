package com.mini.anuualwork.controller;

import com.mini.anuualwork.core.ApiDataResponse;
import com.mini.anuualwork.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/admin")
@RestController
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/user")
    public ApiDataResponse<?> allMemberList() {
        return this.adminService.getAllMembers();
    }

    @DeleteMapping("/user/{id}")
    public ApiDataResponse<?> deleteMember(@PathVariable Long id) {
        return this.adminService.deleteMember(id);
    }
}
