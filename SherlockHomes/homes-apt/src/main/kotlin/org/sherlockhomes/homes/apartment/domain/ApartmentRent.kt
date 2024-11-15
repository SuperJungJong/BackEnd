package org.sherlockhomes.homes.apartment.domain

class ApartmentRent(
    val aptNm: String,
    val buildYear: Int,
    val contractTerm: String? = null,
    val contractType: String? = null,
    val dealDay: Int,
    val dealMonth: Int,
    val dealYear: Int,
    val deposit: String,
    val excluUseAr: Double,
    val floor: Int? = 0,
    val jibun: String,
    val monthlyRent: Int,
    val preDeposit: String? = null,
    val preMonthlyRent: Int? = 0,
    val sggCd: Int,
    val umdNm: String,
    val useRRRight: String? = null,
)