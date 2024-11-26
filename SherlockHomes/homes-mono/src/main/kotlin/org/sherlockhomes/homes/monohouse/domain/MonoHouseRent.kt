package org.sherlockhomes.homes.monohouse.domain

class MonoHouseRent(
    val buildYear: Int? = 0,            // 건축 연도
    val contractTerm: String? = "-",     // 계약 기간 (nullable)
    val contractType: String? = "-",     // 계약 유형 (nullable)
    val dealDay: Int? = 0,              // 거래 일
    val dealMonth: Int? = 0,         // 거래 월
    val dealYear: Int? = 0,             // 거래 연도
    val deposit: String? = "-",           // 보증금
    val houseType: String? = "-",         // 주택 유형
    val monthlyRent: Int? = 0,          // 월세
    val preDeposit: String? = "-",       // 이전 보증금 (nullable)
    val preMonthlyRent: String? = "-",   // 이전 월세 (nullable)
    val sggCd: String? = "-",             // 시군구 코드
    val totalFloorAr: Double? = 0.0,      // 총 바닥 면적
    val umdNm: String? = "-",             // 읍면동 이름
    val useRRRight: String? = "-",        // 사용 권리 (nullable)
    val sgg: String? = "-",
    val si: String? = "-",
    val gu: String? = "-",
    val dong: String? = "-",
)