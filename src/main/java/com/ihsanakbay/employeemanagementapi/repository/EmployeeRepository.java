package com.ihsanakbay.employeemanagementapi.repository;

import com.ihsanakbay.employeemanagementapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    Employee findByFirstNameAndLastNameIsLike(String firstName, String lastName);
    List<Employee> findByCurrentlyEmployedIs(Boolean currentlyEmployed);
}
