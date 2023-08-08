package com.mini.anuualwork.controller;

import com.mini.anuualwork.core.ApiDataResponse;
import com.mini.anuualwork.dto.AdminDto.*;
import com.mini.anuualwork.service.AdminService;
import com.mini.anuualwork.utils.ValidationUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/admin")
@RestController
public class AdminController {

    private final AdminService adminService;

    @GetMapping
    public ApiDataResponse<?> checkAdminAuth() {
        return this.adminService.checkAdminAuth();
    }

    @GetMapping("/user")
    public ApiDataResponse<List<ResponseMember>> allMemberList() {
        return this.adminService.getAllMembers();
    }

    @DeleteMapping("/user/{id}")
    public ApiDataResponse<ResponseSuccess> deleteMember(@PathVariable Long id) {
        return this.adminService.deleteMember(id);
    }

    @PostMapping("/work")
    public ApiDataResponse<ResponseSuccess> createWork(
            @Valid @RequestBody RequestCreateWork dto, BindingResult bindingResult) {
        ValidationUtils.checkValidation(bindingResult);

        return this.adminService.createWork(dto);
    }

    @DeleteMapping("/work/{workId}")
    public ApiDataResponse<ResponseSuccess> deleteWork(@PathVariable Long workId) {
        return this.adminService.deleteWork(workId);
    }

    @GetMapping("/annual")
    public ApiDataResponse<List<ResponseAnnual>> annualList() {
        return this.adminService.getAnnualList();
    }

    @PostMapping("/annual/{annualId}")
    public ApiDataResponse<ResponseSuccess> approveAnnual(@PathVariable Long annualId) {
        return this.adminService.approveAnnual(annualId);
    }

    @DeleteMapping("/annual/{annualId}")
    public ApiDataResponse<ResponseSuccess> rejectAnnual(@PathVariable Long annualId) {
        return this.adminService.rejectAnnual(annualId);
    }
}
