package org.sherlockhomes.homes.batch.application.VO

class MonoRentVO {

    data class ApartmentRent(
        val buildYear: Int,
        val contractTerm: String?,
        val contractType: String?,
        val dealDay: Int,
        val dealMonth: Int,
        val dealYear: Int,
        val deposit: String,
        val houseType: String?,
        val monthlyRent: Int,
        val preDeposit: String?,
        val preMonthlyRent: String?,
        val sggCd: String,
        val totalFloorAr: Double,
        val umdNm: String,
        val useRRRight: String?
    )
}