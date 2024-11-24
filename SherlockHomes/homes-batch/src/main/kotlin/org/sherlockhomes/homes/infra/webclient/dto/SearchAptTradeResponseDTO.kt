package org.sherlockhomes.homes.infra.webclient.dto

class SearchAptTradeResponseDTO {
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
        val aptDong: String? = null,
        val aptNm: String? = null,
        val aptSeq: String? = null,
        val bonbun: String? = null,
        val bubun: String? = null,
        val buildYear: Int? = null,
        val buyerGbn: String? = null,
        val cdealDay: String? = null,
        val cdealType: String? = null,
        val dealAmount: String? = null,
        val dealDay: String? = null,
        val dealMonth: String? = null,
        val dealYear: String? = null,
        val dealingGbn: String? = null,
        val estateAgentSggNm: String? = null,
        val excluUseAr: String? = null,
        val floor: String? = null,
        val jibun: String? = null,
        val landCd: String? = null,
        val landLeaseholdGbn: String? = null,
        val rgstDate: String? = null,
        val roadNm: String? = null,
        val roadNmBonbun: String? = null,
        val roadNmBubun: String? = null,
        val roadNmCd: Int? = null,
        val roadNmSeq: String? = null,
        val roadNmSggCd: Int? = null,
        val roadNmbCd: Int? = null,
        val sggCd: Int? = null,
        val slerGbn: String = "",
        val umdCd: Int? = null,
        val umdNm: String? = null
    )
}