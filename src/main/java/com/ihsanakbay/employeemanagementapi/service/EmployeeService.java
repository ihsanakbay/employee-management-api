package com.ihsanakbay.employeemanagementapi.service;

import com.ihsanakbay.employeemanagementapi.dto.CreateEmployeeRequest;
import com.ihsanakbay.employeemanagementapi.dto.EmployeeDto;
import com.ihsanakbay.employeemanagementapi.dto.converter.EmployeeDtoConverter;
import com.ihsanakbay.employeemanagementapi.exception.EmployeeNotFoundException;
import com.ihsanakbay.employeemanagementapi.model.Company;
import com.ihsanakbay.employeemanagementapi.model.Employee;
import com.ihsanakbay.employeemanagementapi.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    private final EmployeeRepository employeeRepository;
    private final CompanyService companyService;
    private final EmployeeDtoConverter converter;

    public EmployeeService(EmployeeRepository repository, CompanyService companyService, EmployeeDtoConverter converter) {
        this.employeeRepository = repository;
        this.companyService = companyService;
        this.converter = converter;
    }

    public EmployeeDto createEmployee(CreateEmployeeRequest request) {
        Company company = companyService.getCompanyById(request.getCompanyId());

        logger.info("Company received");
        Employee employee = new Employee(
                request.getFirstName(),
                request.getLastName(),
                request.getTitle(),
                request.getDepartment(),
                request.getGender(),
                request.getEmploymentDate(),
                request.getCurrentlyEmployed(),
                company
        );
        return converter.convert(employeeRepository.save(employee));
    }

    public List<EmployeeDto> getAllEmployees() {
        return  employeeRepository.findAll()
                .stream().map(converter::convert)
                .collect(Collectors.toList());
    }

    public List<EmployeeDto> getAllCurrentlyEmployedEmployees() {
        return  employeeRepository.findByCurrentlyEmployedIs(true)
                .stream().map(converter::convert)
                .collect(Collectors.toList());
    }

    public EmployeeDto getEmployeeById(String id) {
        return converter.convert(findEmployeeById(id));
    }

    protected Employee findEmployeeById(String id) {
        return employeeRepository.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException("Employee couldn't find by id: " + id));
    }
}