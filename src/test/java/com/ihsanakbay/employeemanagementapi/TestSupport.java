package com.ihsanakbay.employeemanagementapi;

import com.ihsanakbay.employeemanagementapi.dto.CreateEmployeeRequest;
import com.ihsanakbay.employeemanagementapi.model.Company;
import com.ihsanakbay.employeemanagementapi.model.Employee;
import com.ihsanakbay.employeemanagementapi.model.Gender;
import jakarta.annotation.Nullable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;

public class TestSupport {
    public CreateEmployeeRequest generateEmployeeRequest() {
        return new CreateEmployeeRequest(
                "firstName",
                "lastName",
                "title",
                "description",
                Gender.MALE,
                LocalDate.of(2023, 3, 10),
                true,
                "company_id"
        );
    }

    public Employee generateEmployee(@Nullable String id,
                                     CreateEmployeeRequest employeeRequest,
                                     Company company) {
        return new Employee(
                id,
                employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getTitle(),
                employeeRequest.getDepartment(),
                employeeRequest.getGender(),
                employeeRequest.getEmploymentDate(),
                employeeRequest.getCurrentlyEmployed(),
                generateCompany()
        );
    }

    public Company generateCompany() {
        return new Company(
                "company_id",
                "company_name",
                "company_city",
                "company_country",
                Collections.emptySet()
        );
    }
}
