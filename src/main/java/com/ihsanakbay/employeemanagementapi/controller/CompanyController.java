package com.ihsanakbay.employeemanagementapi.controller;

import com.ihsanakbay.employeemanagementapi.dto.CompanyDto;
import com.ihsanakbay.employeemanagementapi.dto.CreateCompanyRequest;
import com.ihsanakbay.employeemanagementapi.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/company")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<CompanyDto>> getCompanies() {
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDto> getCompanyById(@PathVariable String id) {
        return ResponseEntity.ok(companyService.getById(id));
    }

    @PostMapping()
    public ResponseEntity<CompanyDto> createCompany(@Valid @RequestBody CreateCompanyRequest request) {
        return ResponseEntity.ok(companyService.createCompany(request));
    }
}
