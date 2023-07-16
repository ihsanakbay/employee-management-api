package com.ihsanakbay.employeemanagementapi.dto

import com.ihsanakbay.employeemanagementapi.model.Gender
import jakarta.validation.constraints.NotBlank
import java.time.LocalDate
import java.time.LocalDateTime

data class CreateEmployeeRequest(
    val firstName: String,
    val lastName: String,
    val title: String,
    val department: String,
    val gender: Gender,
    val employmentDate: LocalDate,
    val currentlyEmployed: Boolean,
    val companyId: String
){

}
