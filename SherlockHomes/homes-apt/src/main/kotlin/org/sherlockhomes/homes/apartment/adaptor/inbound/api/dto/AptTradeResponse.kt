package org.sherlockhomes.homes.apartment.adaptor.inbound.api.dto

class AptTradeResponse {
    data class Response(
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
        val floor: String,
        val buildYear: String,
        val roadNm: String,
    )
}