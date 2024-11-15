package org.sherlockhomes.homes.infra.webclient.VO

class MonoHouseTradeSearchVO {
    data class ResponseResults (
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
}