package com.ihsanakbay.employeemanagementapi.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.ihsanakbay.employeemanagementapi.model.Gender
import org.springframework.hateoas.RepresentationModel
import java.time.LocalDate
import java.time.LocalDateTime

data class EmployeeDto @JvmOverloads constructor (
    val id: String,
    val firstName: String,
    val lastName: String,
    val title: String,
    val department: String,
    val gender: Gender,
    val employmentDate: LocalDate,
    val currentlyEmployed: Boolean,
    @JsonInclude(JsonInclude.Include.NON_EMPTY) // Only add to json if it's not empty
    val company: CompanyDto? = null
): RepresentationModel<EmployeeDto>()
