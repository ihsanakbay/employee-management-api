package com.ihsanakbay.employeemanagementapi.service;


import com.ihsanakbay.employeemanagementapi.dto.CompanyDto;
import com.ihsanakbay.employeemanagementapi.dto.CreateCompanyRequest;
import com.ihsanakbay.employeemanagementapi.dto.converter.CompanyDtoConverter;
import com.ihsanakbay.employeemanagementapi.exception.CompanyNotFoundException;
import com.ihsanakbay.employeemanagementapi.model.Company;
import com.ihsanakbay.employeemanagementapi.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    private final CompanyRepository repository;
    private final CompanyDtoConverter converter;

    public CompanyService(CompanyRepository repository, CompanyDtoConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }


    protected Company getCompanyById(String id) {
        return  repository.findById(id)
                .orElseThrow(()-> new CompanyNotFoundException("Company couldn't find by id: " + id));
    }

    public CompanyDto getById(String id) {
        Company company =  repository.findById(id)
                .orElseThrow(()-> new CompanyNotFoundException("Company couldn't find by id: " + id));
        return converter.convert(company);
    }
    public CompanyDto createCompany(CreateCompanyRequest request) {
        Company company = new Company(
                request.getName(),
                request.getCity(),
                request.getCountry()
        );

        return converter.convert(repository.save(company));
    }

    public List<CompanyDto> getAllCompanies() {
        return repository.findAll()
                .stream().map(converter::convert)
                .collect(Collectors.toList());
    }

}

