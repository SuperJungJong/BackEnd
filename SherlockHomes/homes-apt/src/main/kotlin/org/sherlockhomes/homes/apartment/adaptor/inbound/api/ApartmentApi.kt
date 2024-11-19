package org.sherlockhomes.homes.apartment.adaptor.inbound.api

import ResponseModel
import io.swagger.v3.oas.annotations.Operation
import org.sherlockhomes.homes.apartment.adaptor.inbound.api.dto.AptTradeResponse
import org.sherlockhomes.homes.apartment.adaptor.inbound.api.mapper.toResponse
import org.sherlockhomes.homes.apartment.application.port.inbound.ApartmentSearchUseCase
import org.sherlockhomes.homes.apartment.application.port.inbound.AptTradeQuery
import org.sherlockhomes.homes.apartment.application.service.rent.vo.ApartmentRentVO
import org.sherlockhomes.homes.apartment.application.service.trade.vo.ApartmentTradeVO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/apt")
class ApartmentApi(
    private val apartmentTradeQuery: ApartmentSearchUseCase<ApartmentTradeVO.ApartmentTrade>,
    private val apartmentRentQuery: ApartmentSearchUseCase<ApartmentRentVO.ApartmentRent>,

    private val aptTradeQuery: AptTradeQuery,
//    private val apartmentCommand: ApartmentCommand,
) {

    @Operation(summary = "아파트 매매 조회")
    @GetMapping("/trade")
    fun getTradeList(
        @RequestParam lawdCd: Int,
        @RequestParam dealYmd: Int,
    ) = apartmentTradeQuery.getList(
        lawdCd = lawdCd,
        dealYmd = dealYmd
    ).map { it.toResponse() }

    @Operation(summary = "아파트 전월세 조회")
    @GetMapping("/rent")
    fun getRentList(
        @RequestParam lawdCd: Int,
        @RequestParam dealYmd: Int,
    ) = apartmentRentQuery.getList(
        lawdCd = lawdCd,
        dealYmd = dealYmd
    ).map { it.toResponse() }

    @Operation(summary = "아파트 매매 페이지 검색")
    @GetMapping("/trade/page")
    fun getTradeListPage(
        @RequestParam(
            required = false,
            defaultValue = "0",
        ) offset: String,
        @RequestParam(
            required = false,
            defaultValue = "100",
        ) limit: String,
        @RequestParam aptName: String,
    ): ResponseModel<List<AptTradeResponse.Response>> {

        val aptTrade = aptTradeQuery.getAptTrade(
            aptName = aptName,
            offset = offset.toInt(),
            limit = limit.toInt(),
        )

        return ResponseModel.of(
            offset = offset.toInt(),
            limit = limit.toInt(),
            total = aptTrade.totalPage,
            data = aptTrade.items.map { it.toResponse() }
        )
    }
}