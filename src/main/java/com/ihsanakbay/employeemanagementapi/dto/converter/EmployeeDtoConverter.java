package com.ihsanakbay.employeemanagementapi.dto.converter;

import com.ihsanakbay.employeemanagementapi.dto.CompanyDto;
import com.ihsanakbay.employeemanagementapi.dto.EmployeeDto;
import com.ihsanakbay.employeemanagementapi.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDtoConverter {
    public EmployeeDto convert(Employee from) {
        return  new EmployeeDto(
                from.getId(),
                from.getFirstName(),
                from.getLastName(),
                from.getTitle(),
                from.getDepartment(),
                from.getGender(),
                from.getEmploymentDate(),
                from.getCurrentlyEmployed(),
                new CompanyDto(
                        from.getCompany().getId(),
                        from.getCompany().getName(),
                        from.getCompany().getCity(),
                        from.getCompany().getCountry()
                )
        );
    }
}