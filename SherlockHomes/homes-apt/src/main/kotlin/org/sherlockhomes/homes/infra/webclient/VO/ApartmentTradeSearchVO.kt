package org.sherlockhomes.homes.infra.webclient.VO

class ApartmentTradeSearchVO {
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
        val aptDong: String?,
        val aptNm: String,
        val aptSeq: String,
        val bonbun: String,
        val bubun: String,
        val buildYear: Int,
        val buyerGbn: String?,
        val cdealDay: String?,
        val cdealType: String?,
        val dealAmount: String,
        val dealDay: String,
        val dealMonth: String,
        val dealYear: String,
        val dealingGbn: String?,
        val estateAgentSggNm: String?,
        val excluUseAr: String,
        val floor: String,
        val jibun: String,
        val landCd: String,
        val landLeaseholdGbn: String,
        val rgstDate: String?,
        val roadNm: String,
        val roadNmBonbun: String,
        val roadNmBubun: String,
        val roadNmCd: Int,
        val roadNmSeq: String,
        val roadNmSggCd: Int,
        val roadNmbCd: Int,
        val sggCd: Int,
        val slerGbn: String = "",
        val umdCd: Int,
        val umdNm: String
    )
}