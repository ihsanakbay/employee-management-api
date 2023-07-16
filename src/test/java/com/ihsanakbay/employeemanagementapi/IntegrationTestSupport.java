package com.ihsanakbay.employeemanagementapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ihsanakbay.employeemanagementapi.dto.EmployeeDto;
import com.ihsanakbay.employeemanagementapi.dto.converter.EmployeeDtoConverter;
import com.ihsanakbay.employeemanagementapi.model.Company;
import com.ihsanakbay.employeemanagementapi.model.Employee;
import com.ihsanakbay.employeemanagementapi.model.Gender;
import com.ihsanakbay.employeemanagementapi.repository.CompanyRepository;
import com.ihsanakbay.employeemanagementapi.repository.EmployeeRepository;
import com.ihsanakbay.employeemanagementapi.service.CompanyService;
import com.ihsanakbay.employeemanagementapi.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application.properties")
@DirtiesContext
@AutoConfigureMockMvc
public class IntegrationTestSupport {

    @Autowired
    public CompanyService companyService;

    @Autowired
    public CompanyRepository companyRepository;

    @Autowired
    public EmployeeService employeeService;

    @Autowired
    public EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeDtoConverter employeeDtoConverter;

    public final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
    }

    public List<Employee> generateEmployees(int size) {
        return IntStream.range(0, size)
                .mapToObj(this::generateEmployee)
                .collect(Collectors.toList());
    }

    public Employee generateEmployee(int i) {
        return new Employee(
                "employee-name-"+i,
                "employee-surname",
                "title",
                "department",
                Gender.MALE,
                LocalDate.of(2023, 3,1),
                true,
                new Company()
        );
    }
}
