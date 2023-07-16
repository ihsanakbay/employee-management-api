package com.ihsanakbay.employeemanagementapi.dto

import jakarta.validation.constraints.NotBlank

data class CreateCompanyRequest(
    val name: String,
    val city: String,
    val country: String
) {

}
