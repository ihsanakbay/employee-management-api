package com.ihsanakbay.employeemanagementapi.model

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDate
import java.time.LocalDateTime


@Entity
data class Employee @JvmOverloads constructor (
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String? = "",
    val firstName: String,
    val lastName: String,
    val title: String,
    val department: String,
    val gender: Gender,
    val employmentDate: LocalDate,
    val currentlyEmployed: Boolean,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    val company: Company
) {

}

enum class Gender {
    MALE, FEMALE, UNKNOWN
}

