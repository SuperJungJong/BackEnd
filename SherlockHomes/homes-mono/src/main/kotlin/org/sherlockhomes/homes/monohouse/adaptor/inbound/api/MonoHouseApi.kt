package org.sherlockhomes.homes.monohouse.adaptor.inbound.api

import io.swagger.v3.oas.annotations.Operation
import org.sherlockhomes.homes.common.responsemodel.ResponseModel
import org.sherlockhomes.homes.monohouse.adaptor.inbound.api.dto.MonoHouseResponseDTO
import org.sherlockhomes.homes.monohouse.adaptor.inbound.api.mapper.toResponse
import org.sherlockhomes.homes.monohouse.application.port.inbound.MonoHouseRentQuery
import org.sherlockhomes.homes.monohouse.application.port.inbound.MonoHouseSearchUseCase
import org.sherlockhomes.homes.monohouse.application.port.inbound.MonoHouseTradeQuery
import org.sherlockhomes.homes.monohouse.application.service.rent.vo.MonoHouseRentVO
import org.sherlockhomes.homes.monohouse.application.service.trade.vo.MonoHouseTradeVO
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/mono")
class MonoHouseApi(
    private val monoHouseTradeSearchQuery: MonoHouseSearchUseCase<MonoHouseTradeVO.MonoHouseTrade>,
    private val monoHouseRentSearchQuery: MonoHouseSearchUseCase<MonoHouseRentVO.MonoHouseRent>,
    private val monoHouseTradeQuery: MonoHouseTradeQuery,
    private val monoHouseRentQuery: MonoHouseRentQuery,
    private val kafkaTemplate: KafkaTemplate<String, String>
) {

    @Operation(summary = "단독/다가구 매매 조회")
    @GetMapping("/trade")
    fun getTradeList(
        @RequestParam lawdCd: Int,
        @RequestParam dealYmd: Int,
    ): ResponseModel<List<MonoHouseResponseDTO.TradeResponse>> {
        kafkaTemplate.send("mono-log", "[mono][controller] /trade, request (lawdCd=${lawdCd})")
        kafkaTemplate.send("all-log", "[mono][controller] /trade, request (dealYmd=${dealYmd})")

        return ResponseModel.of(
            payload = monoHouseTradeSearchQuery.getList(
                lawdCd = lawdCd,
                dealYmd = dealYmd
            ).map { it.toResponse() }
        )
    }

    @Operation(summary = "단독/다가구 전월세 조회")
    @GetMapping("/rent")
    fun getRentList(
        @RequestParam lawdCd: Int,
        @RequestParam dealYmd: Int,
    ): ResponseModel<List<MonoHouseResponseDTO.RentResponse>> {
        kafkaTemplate.send("mono-log", "[mono][controller] /rent, request (lawdCd=${lawdCd})")
        kafkaTemplate.send("all-log", "[mono][controller] /rent, request (dealYmd=${dealYmd})")

        return ResponseModel.of(
            monoHouseRentSearchQuery.getList(
                lawdCd = lawdCd,
                dealYmd = dealYmd
            ).map { it.toResponse() }
        )
    }

    @Operation(summary = "단독/다가구 매매 조회 for DB")
    @GetMapping("/trade/{si}/{gu}/{dong}")
    fun getTradeListBySgg(
        @PathVariable si: String,
        @PathVariable gu: String,
        @PathVariable dong: String,
    ): ResponseModel<List<MonoHouseResponseDTO.TradeResponse>> {
        kafkaTemplate.send(
            "mono-log",
            "[mono][controller] /trade/{si}/{gu}/{dong}, request (si=${si}, gu=${gu}, dong=${dong})"
        )
        kafkaTemplate.send(
            "all-log",
            "[mono][controller] /trade/{si}/{gu}/{dong}, request (si=${si}, gu=${gu}, dong=${dong})"
        )

        return ResponseModel.of(
            payload = monoHouseTradeQuery.getMonoTradeListBySgg(
                si = si,
                gu = gu,
                dong = dong,
            ).map { it.toResponse() }
        )
    }

    @Operation(summary = "단독/다가구 전월세 조회 for DB")
    @GetMapping("/rent/{si}/{gu}/{dong}")
    fun getRentDetailList(
        @PathVariable si: String,
        @PathVariable gu: String,
        @PathVariable dong: String,
    ): ResponseModel<List<MonoHouseResponseDTO.RentResponse>> {
        kafkaTemplate.send(
            "mono-log",
            "[mono][controller] /rent/{si}/{gu}/{dong}, request (si=${si}, gu=${gu}, dong=${dong})"
        )
        kafkaTemplate.send(
            "all-log",
            "[mono][controller] /rent/{si}/{gu}/{dong}, request (si=${si}, gu=${gu}, dong=${dong})"
        )

        return ResponseModel.of(
            payload = monoHouseRentQuery.getMonoRentListBySgg(
                si = si,
                gu = gu,
                dong = dong,
            ).map { it.toResponse() }
        )
    }
}