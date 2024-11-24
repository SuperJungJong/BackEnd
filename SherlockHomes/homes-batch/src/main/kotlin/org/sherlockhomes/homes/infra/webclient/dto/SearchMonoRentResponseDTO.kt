package org.sherlockhomes.homes.infra.webclient.dto

class SearchMonoRentResponseDTO {
    data class ResponseResults(
        val response: Response
    )

    data class Response(
        val header: Header,
        val body: Body
    )

    data class Header(
        val resultCode: String,
        val resultMsg: String
    )

    data class Body(
        val items: Items,
        val numOfRows: Int,
        val pageNo: Int,
        val totalCount: Int
    )

    data class Items(
        val item: List<Item>
    )

    data class Item(
        val buildYear: Int? = null,
        val contractTerm: String? = null,
        val contractType: String? = null,
        val dealDay: Int? = null,
        val dealMonth: Int? = null,
        val dealYear: Int? = null,
        val deposit: String? = null,
        val houseType: String? = null,
        val monthlyRent: Int? = null,
        val preDeposit: String? = null,
        val preMonthlyRent: String? = null,
        val sggCd: String? = null,
        val totalFloorAr: Double? = null,
        val umdNm: String? = null,
        val useRRRight: String? = null
    )
}