package com.ihsanakbay.employeemanagementapi.dto.converter;

import com.ihsanakbay.employeemanagementapi.dto.CompanyDto;
import com.ihsanakbay.employeemanagementapi.dto.EmployeeDto;
import com.ihsanakbay.employeemanagementapi.model.Company;
import com.ihsanakbay.employeemanagementapi.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompanyDtoConverter {
    public CompanyDto convert(Company from) {
        return  new CompanyDto(
                from.getId(),
                from.getName(),
                from.getCity(),
                from.getCountry()
        );
    }

    private List<EmployeeDto> getEmployeeList(List<Employee> employeeList) {
        return employeeList.stream()
                .map(employee -> new EmployeeDto(
                        employee.getId(),
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getTitle(),
                        employee.getDepartment(),
                        employee.getGender(),
                        employee.getEmploymentDate(),
                        employee.getCurrentlyEmployed()
                )).collect(Collectors.toList());
    }
}
