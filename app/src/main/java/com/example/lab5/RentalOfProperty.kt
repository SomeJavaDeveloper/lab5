package com.example.lab5

data class RentalOfProperty(
    val address: String,
    val monthlyCost: Int,
    val typeOfHousing: TypeOfHousing? = null,
    val area: String? = null,
    val rooms: Int? = null
)

enum class TypeOfHousing {
    FLAT,
    HOUSE,
    BARN
}