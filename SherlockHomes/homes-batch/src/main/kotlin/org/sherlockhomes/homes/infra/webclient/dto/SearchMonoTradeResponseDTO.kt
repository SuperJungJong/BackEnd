package org.sherlockhomes.homes.infra.webclient.dto

class SearchMonoTradeResponseDTO {
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
    )
}