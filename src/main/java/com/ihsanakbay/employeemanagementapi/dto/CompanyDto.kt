package com.ihsanakbay.employeemanagementapi.dto

import com.fasterxml.jackson.annotation.JsonInclude

data class CompanyDto @JvmOverloads constructor (
    val id: String,
    val name: String,
    val city: String,
    val country: String
) {

}