package org.sherlockhomes.homes.infra.webclient.VO

class ApartmentRentSearchVO {
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
        val aptNm: String,
        val buildYear: Int,
        val contractTerm: String? = null,
        val contractType: String? = null,
        val dealDay: Int,
        val dealMonth: Int,
        val dealYear: Int,
        val deposit: String,
        val excluUseAr: Double,
        val floor: Int? = 0,
        val jibun: String,
        val monthlyRent: Int,
        val preDeposit: String? = null,
        val preMonthlyRent: Int? = 0,
        val sggCd: Int,
        val umdNm: String,
        val useRRRight: String? = null,
    )
}