package org.sherlockhomes.homes.monohouse.application.service.trade.vo

class MonoHouseTradeVO {

    data class MonoHouseTrade(
        val buildYear: String? = "-",
        val buyerGbn: String? = null,
        val cdealDay: String? = null,
        val cdealType: String? = null,
        val dealAmount: String? = "-",
        val dealDay: Int? = 0,
        val dealMonth: Int? = 0,
        val dealYear: Int? = 0,
        val dealingGbn: String? = null,
        val estateAgentSggNm: String? = null,
        val houseType: String? = null,
        val jibun: String? = null,
        val plottageAr: Double? = 0.0,
        val sggCd: Int? = 0,
        val slerGbn: String? = null,
        val totalFloorAr: Double? = 0.0,
        val umdNm: String? = "-",
        val sgg: String? = "-",
        val si: String? = "-",
        val gu: String? = "-",
        val dong: String? = "-",
    )

    data class Save(
        val id: Long,
    )
}