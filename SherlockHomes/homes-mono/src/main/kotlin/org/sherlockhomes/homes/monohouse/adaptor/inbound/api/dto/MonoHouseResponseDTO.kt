package org.sherlockhomes.homes.monohouse.adaptor.inbound.api.dto

class MonoHouseResponseDTO {

    data class TradeResponse(
        val buildYear: String? = null,
        val buyerGbn: String? = null,
        val cdealDay: String? = null,
        val cdealType: String? = null,
        val dealAmount: String? = null,
        val dealDay: Int? = null,
        val dealMonth: Int? = null,
        val dealYear: Int? = null,
        val dealingGbn: String? = null,
        val estateAgentSggNm: String? = null,
        val houseType: String? = null,
        val jibun: String? = null,
        val plottageAr: Double? = null,
        val sggCd: Int? = null,
        val slerGbn: String? = null,
        val totalFloorAr: Double? = 0.0,
        val umdNm: String? = null,
        val sgg: String? = null,
        val si: String? = null,
        val gu: String? = null,
        val dong: String? = null,
    )

    data class RentResponse(
        val buildYear: Int? = null,            // 건축 연도
        val contractTerm: String? = null,     // 계약 기간 (nullable)
        val contractType: String? = null,     // 계약 유형 (nullable)
        val dealDay: Int? = null,              // 거래 일
        val dealMonth: Int? = null,            // 거래 월
        val dealYear: Int? = null,             // 거래 연도
        val deposit: String? = null,           // 보증금
        val houseType: String? = null,         // 주택 유형
        val monthlyRent: Int? = null,          // 월세
        val preDeposit: String? = null,      // 이전 보증금 (nullable)
        val preMonthlyRent: String? = null,   // 이전 월세 (nullable)
        val sggCd: String? = null,             // 시군구 코드
        val totalFloorAr: Double? = null,      // 총 바닥 면적
        val umdNm: String? = null,             // 읍면동 이름
        val useRRRight: String? = null,        // 사용 권리 (nullable)
        val sgg: String? = null,
        val si: String? = null,
        val gu: String? = null,
        val dong: String? = null,
    )
}