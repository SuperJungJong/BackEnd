package org.sherlockhomes.homes.apartment.adaptor.inbound.api

import io.swagger.v3.oas.annotations.Operation
import org.sherlockhomes.homes.apartment.adaptor.inbound.api.mapper.toResponse
import org.sherlockhomes.homes.apartment.application.port.inbound.ApartmentSearchUseCase
import org.sherlockhomes.homes.apartment.application.service.rent.vo.ApartmentTradeVO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient

@RestController
@RequestMapping("/api/apt")
class ApartmentApi (
    private val webClient: WebClient,
    private val apartmentQuery: ApartmentSearchUseCase<ApartmentTradeVO.ApartmentTrade>,
//    private val apartmentCommand: ApartmentCommand,
){

    @Operation(summary = "아파트 매매 조회")
    @GetMapping
    fun getList(
        @RequestParam lawdCd: Int,
        @RequestParam dealYmd: Int,
    ) = apartmentQuery.getList(
            lawdCd=lawdCd,
            dealYmd=dealYmd
        ).map { it.toResponse() }

}