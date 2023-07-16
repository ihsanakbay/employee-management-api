package com.ihsanakbay.employeemanagementapi.repository;

import com.ihsanakbay.employeemanagementapi.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {
}
