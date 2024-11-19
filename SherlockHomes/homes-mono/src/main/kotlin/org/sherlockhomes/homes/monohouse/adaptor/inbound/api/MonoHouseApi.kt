package org.sherlockhomes.homes.monohouse.adaptor.inbound.api

import io.swagger.v3.oas.annotations.Operation
import org.sherlockhomes.homes.monohouse.adaptor.inbound.api.mapper.toResponse
import org.sherlockhomes.homes.monohouse.application.port.inbound.MonoHouseSearchUseCase
import org.sherlockhomes.homes.monohouse.application.service.rent.vo.MonoHouseRentVO
import org.sherlockhomes.homes.monohouse.application.service.trade.vo.MonoHouseTradeVO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/mono")
class MonoHouseApi(
    private val monoHouseTradeQuery: MonoHouseSearchUseCase<MonoHouseTradeVO.MonoHouseTrade>,
    private val monoHouseRentQuery: MonoHouseSearchUseCase<MonoHouseRentVO.MonoHouseRent>,
) {

    @Operation(summary = "단독/다가구 매매 조회")
    @GetMapping("/trade")
    fun getTradeList(
        @RequestParam lawdCd: Int,
        @RequestParam dealYmd: Int,
    ) = monoHouseTradeQuery.getList(
        lawdCd = lawdCd,
        dealYmd = dealYmd
    ).map { it.toResponse() }

    @Operation(summary = "단독/다가구 전월세 조회")
    @GetMapping("/rent")
    fun getRentList(
        @RequestParam lawdCd: Int,
        @RequestParam dealYmd: Int,
    ) = monoHouseRentQuery.getList(
        lawdCd = lawdCd,
        dealYmd = dealYmd
    ).map { it.toResponse() }
}