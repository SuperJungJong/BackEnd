package org.sherlockhomes.homes.apartment.application.service.vo.rent

class AptRentVO {

    data class ApartmentRent(
        val aptNm: String? = "-",
        val buildYear: Int? = 0,
        val contractTerm: String? = null,
        val contractType: String? = null,
        val dealDay: Int? = 0,
        val dealMonth: Int? = 0,
        val dealYear: Int? = 0,
        val deposit: String? = "-",
        val excluUseAr: Double? = 0.0,
        val floor: Int? = 0,
        val jibun: String? = "-",
        val monthlyRent: Int? = 0,
        val preDeposit: String? = null,
        val preMonthlyRent: Int? = 0,
        val sggCd: Int? = 0,
        val umdNm: String? = "-",
        val useRRRight: String? = null,
        val sgg: String? = null,
        val si: String? = null,
        val gu: String? = null,
        val dong: String? = null,
    )

    data class Save(
        val id: Long,
    )
}