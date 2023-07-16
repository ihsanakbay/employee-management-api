package com.ihsanakbay.employeemanagementapi.service;

import com.ihsanakbay.employeemanagementapi.dto.EmployeeDto;
import com.ihsanakbay.employeemanagementapi.dto.converter.EmployeeDtoConverter;
import com.ihsanakbay.employeemanagementapi.exception.EmployeeNotFoundException;
import com.ihsanakbay.employeemanagementapi.model.Company;
import com.ihsanakbay.employeemanagementapi.model.Employee;
import com.ihsanakbay.employeemanagementapi.model.Gender;
import com.ihsanakbay.employeemanagementapi.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmployeeServiceTest {
    private EmployeeRepository employeeRepository;
    private EmployeeService employeeService;
    private CompanyService companyService;
    private EmployeeDtoConverter employeeDtoConverter;

    @BeforeEach
    public void setup() {
        employeeRepository = Mockito.mock(EmployeeRepository.class);
        companyService = Mockito.mock(CompanyService.class);
        employeeDtoConverter = Mockito.mock(EmployeeDtoConverter.class);
        employeeService = new EmployeeService(employeeRepository, companyService, employeeDtoConverter);
    }

    @Test
    public void testGetEmployeeById_whenIdExist_shouldReturnEmployee() {
        List<Employee> employeeList = List.of(
                new Employee("id1", "name1", "surname1", "title", "description", Gender.MALE, LocalDate.now(), true, new Company()),
                new Employee("id2", "name2", "surname2", "title", "description", Gender.FEMALE, LocalDate.now(), true, new Company())
        );
        String existingId = "id1";
        Employee expectedEmployee = new Employee("id1", "name1", "surname1", "title", "description", Gender.MALE, LocalDate.now(), true, new Company());
        Mockito.when(employeeRepository.findById(existingId)).thenReturn(Optional.of(expectedEmployee));

        Employee result = employeeService.findEmployeeById(existingId);

        Assertions.assertEquals(expectedEmployee, result);
        Mockito.verify(employeeRepository).findById(existingId);
    }


    @Test
    public void testGetEmployeeById_whenIdNotExist_shouldReturnError() {
        String existingId = "id1";
        assertThrows(RuntimeException.class,
                ()-> employeeService.findEmployeeById(existingId));
    }
}
