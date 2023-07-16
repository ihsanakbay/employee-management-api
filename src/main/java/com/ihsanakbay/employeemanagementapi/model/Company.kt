package com.ihsanakbay.employeemanagementapi.model

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator


@Entity
data class Company @JvmOverloads constructor(
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String? = "",
    val name: String,
    val city: String,
    val country: String,

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    val employees: Set<Employee>? = HashSet()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Company

        if (id != other.id) return false
        if (name != other.name) return false
        if (city != other.city) return false
        if (country != other.country) return false
        return employees == other.employees
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + name.hashCode()
        result = 31 * result + city.hashCode()
        result = 31 * result + country.hashCode()
        return result
    }
}

