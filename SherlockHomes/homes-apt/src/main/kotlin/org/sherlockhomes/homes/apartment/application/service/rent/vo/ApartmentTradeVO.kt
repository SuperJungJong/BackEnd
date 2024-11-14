package org.sherlockhomes.homes.apartment.application.service.rent.vo

class ApartmentTradeVO {

    data class ApartmentTrade(
        val aptDong: String? = null,
        val aptNm: String,
        val aptSeq: String,
        val bonbun: String,
        val bubun: String,
        val buildYear: Int,
        val buyerGbn: String? = null,
        val cdealDay: String? = null,
        val cdealType: String? = null,
        val dealAmount: String,
        val dealDay: String,
        val dealMonth: String,
        val dealYear: String,
        val dealingGbn: String? = null,
        val estateAgentSggNm: String? = null,
        val excluUseAr: String,
        val floor: String,
        val jibun: String,
        val landCd: String,
        val landLeaseholdGbn: String,
        val rgstDate: String?,
        val roadNm: String,
        val roadNmBonbun: String,
        val roadNmBubun: String,
        val roadNmCd: Int,
        val roadNmSeq: String,
        val roadNmSggCd: Int,
        val roadNmbCd: Int,
        val sggCd: Int,
        val slerGbn: String,
        val umdCd: Int,
        val umdNm: String,
    )

    data class Save(
        val id: Long,
    )
}