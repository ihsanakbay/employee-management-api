package com.ihsanakbay.employeemanagementapi.controller;


import com.ihsanakbay.employeemanagementapi.dto.CreateEmployeeRequest;
import com.ihsanakbay.employeemanagementapi.dto.EmployeeDto;
import com.ihsanakbay.employeemanagementapi.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return ResponseEntity.ok(service.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable String id) {
        return ResponseEntity.ok(service.getEmployeeById(id));
    }

    @GetMapping("/employed")
    public ResponseEntity<List<EmployeeDto>> getAllCurrentlyEmployedEmployees() {
        return ResponseEntity.ok(service.getAllCurrentlyEmployedEmployees());
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody CreateEmployeeRequest request){
        return ResponseEntity.ok(service.createEmployee(request));
    }
}
