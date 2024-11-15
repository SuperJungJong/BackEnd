package org.sherlockhomes.homes.monohouse.adaptor.inbound.api.dto

class MonoHouseResponseDTO {

    data class TradeResponse(
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

    data class RentResponse(
        val buildYear: Int,            // 건축 연도
        val contractTerm: String?,     // 계약 기간 (nullable)
        val contractType: String?,     // 계약 유형 (nullable)
        val dealDay: Int,              // 거래 일
        val dealMonth: Int,            // 거래 월
        val dealYear: Int,             // 거래 연도
        val deposit: String,           // 보증금
        val houseType: String?,         // 주택 유형
        val monthlyRent: Int,          // 월세
        val preDeposit: String?,       // 이전 보증금 (nullable)
        val preMonthlyRent: String?,   // 이전 월세 (nullable)
        val sggCd: String,             // 시군구 코드
        val totalFloorAr: Double,      // 총 바닥 면적
        val umdNm: String,             // 읍면동 이름
        val useRRRight: String?        // 사용 권리 (nullable)
    )
}