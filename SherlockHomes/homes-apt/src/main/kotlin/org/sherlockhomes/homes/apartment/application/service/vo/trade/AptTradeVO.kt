package org.sherlockhomes.homes.apartment.application.service.vo.trade

class AptTradeVO {
    data class AptTrade(
        val no: Long?,
        val sgg: String,
        val si: String,
        val gu: String,
        val dong: String,
        val jibun: String,
        val aptNm: String?,
        val exduUseAr: Double,
        val dealY: String?,
        val dealM: String?,
        val dealD: String?,
        val dealAmount: String,
        val aptDong: String,
        val floor: String,
        val buy: String,
        val seller: String,
        val buildYear: String,
        val roadNm: String,
        val specialDay: String,
        val type: String,
        val middleAddr: String,
    )
}