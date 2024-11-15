package org.sherlockhomes.homes.monohouse.application.service.trade.vo

class MonoHouseTradeVO {

    data class MonoHouseTrade(
        val buildYear: String,
        val buyerGbn: String? = null,
        val cdealDay: String? = null,
        val cdealType: String? = null,
        val dealAmount: String,
        val dealDay: Int,
        val dealMonth: Int,
        val dealYear: Int,
        val dealingGbn: String? = null,
        val estateAgentSggNm: String? = null,
        val houseType: String? = null,
        val jibun: String? = null,
        val plottageAr: Double,
        val sggCd: Int,
        val slerGbn: String? = null,
        val totalFloorAr: Double? = 0.0,
        val umdNm: String,
    )

    data class Save(
        val id: Long,
    )
}