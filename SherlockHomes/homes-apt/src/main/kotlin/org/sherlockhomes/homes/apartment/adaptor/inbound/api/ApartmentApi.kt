package org.sherlockhomes.homes.apartment.adaptor.inbound.api

import io.swagger.v3.oas.annotations.Operation
import org.sherlockhomes.homes.apartment.adaptor.inbound.api.dto.ApartmentResponseDTO
import org.sherlockhomes.homes.apartment.adaptor.inbound.api.dto.AptTradeResponse
import org.sherlockhomes.homes.apartment.adaptor.inbound.api.dto.GuCountResponseDTO
import org.sherlockhomes.homes.apartment.adaptor.inbound.api.mapper.toResponse
import org.sherlockhomes.homes.apartment.application.port.inbound.ApartmentSearchUseCase
import org.sherlockhomes.homes.apartment.application.port.inbound.AptRentQuery
import org.sherlockhomes.homes.apartment.application.port.inbound.AptTradeQuery
import org.sherlockhomes.homes.apartment.application.port.inbound.GuCountQuery
import org.sherlockhomes.homes.apartment.application.service.vo.rent.AptRentVO
import org.sherlockhomes.homes.apartment.application.service.vo.trade.ApartmentTradeVO
import org.sherlockhomes.homes.common.responsemodel.ResponseModel
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/apt")
class ApartmentApi(
    private val apartmentTradeQuery: ApartmentSearchUseCase<ApartmentTradeVO.ApartmentTrade>,
    private val apartmentRentQuery: ApartmentSearchUseCase<AptRentVO.ApartmentRent>,
    private val aptTradeQuery: AptTradeQuery,
    private val aptRentQuery: AptRentQuery,
    private val guCountQuery: GuCountQuery,
    private val kafkaTemplate: KafkaTemplate<String, String>,
) {

    @Operation(summary = "아파트 매매 조회")
    @GetMapping("/trade")
    fun getTradeList(
        @RequestParam lawdCd: Int,
        @RequestParam dealYmd: Int,
    ): ResponseModel<List<ApartmentResponseDTO.TradeResponse>> {
        kafkaTemplate.send("apt-log", "[apt][controller] /trade, request (lawdCd=${lawdCd}, dealYmd=${dealYmd})")
        kafkaTemplate.send("all-log", "[apt][controller] /trade, request (lawdCd=${lawdCd}, dealYmd=${dealYmd})")

        return ResponseModel.of(
            payload = apartmentTradeQuery.getList(
                lawdCd = lawdCd,
                dealYmd = dealYmd,
            ).map { it.toResponse() }
        )
    }

    @Operation(summary = "아파트 전월세 조회")
    @GetMapping("/rent")
    fun getRentList(
        @RequestParam lawdCd: Int,
        @RequestParam dealYmd: Int,
    ): ResponseModel<List<ApartmentResponseDTO.RentResponse>> {
        kafkaTemplate.send("apt-log", "[apt][controller] /rent, request (lawdCd=${lawdCd}, dealYmd=${dealYmd})")
        kafkaTemplate.send("all-log", "[apt][controller] /rent, request (lawdCd=${lawdCd}, dealYmd=${dealYmd})")

        return ResponseModel(
            payload = apartmentRentQuery.getList(
                lawdCd = lawdCd,
                dealYmd = dealYmd
            ).map { it.toResponse() }
        )
    }

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
        @RequestParam sgg: String,
    ): ResponseModel<List<AptTradeResponse.Response>> {
        kafkaTemplate.send(
            "apt-log",
            "[apt][controller] getTradeListPage, request (offset=${offset}, limit=${limit}, aptName=${aptName}, sgg=${sgg})"
        )
        kafkaTemplate.send(
            "all-log",
            "[apt][controller] getTradeListPage, request (offset=${offset}, limit=${limit}, aptName=${aptName}, sgg=${sgg})"
        )

        val aptTrade = aptTradeQuery.getAptTrade(
            sgg = sgg,
            aptName = aptName,
            offset = offset.toInt(),
            limit = limit.toInt(),
        )

        return ResponseModel.of(
            offset = offset.toInt(),
            limit = limit.toInt(),
            total = aptTrade.totalPage,
            payload = aptTrade.items.map { it.toResponse() }
        )
    }

    @Operation(summary = "구별 매매량 조회")
    @GetMapping("/trade/gu/{si}")
    fun getGuCount(
        @PathVariable si: String,
    ): ResponseModel<List<GuCountResponseDTO.Response>> {
        kafkaTemplate.send(
            "ek-log",
            "[apt][controller] getGuCount, request (si=${si})"
        )


        return ResponseModel.of(
            payload = guCountQuery.getGuCount(si).map { it.toResponse() },
        )
    }

    @Operation(summary = "동 별 조회할 수 있는 아파트 조회")
    @GetMapping("/trade/dong/{si}/{gu}/{dong}")
    fun getAptInDong(
        @PathVariable si: String,
        @PathVariable gu: String,
        @PathVariable dong: String,
    ): ResponseModel<List<AptTradeResponse.Response>> {
        kafkaTemplate.send(
            "apt-log",
            "[apt][controller] getAptInDong, request (si=${si}, gu=${gu}, dong=${dong})"
        )
        kafkaTemplate.send(
            "all-log",
            "[apt][controller] getAptInDong, request (si=${si}, gu=${gu}, dong=${dong})"
        )

        return ResponseModel.of(
            payload = aptTradeQuery.getAptInDong(
                si = si,
                gu = gu,
                dong = dong,
            ).map { it.toResponse() },
        )
    }

    @Operation(summary = "아파트 전월세 조회")
    @GetMapping("/rent/dong/{si}/{gu}/{dong}")
    fun getRentListInDong(
        @PathVariable si: String,
        @PathVariable gu: String,
        @PathVariable dong: String,
    ): ResponseModel<List<ApartmentResponseDTO.RentResponse>> {
        kafkaTemplate.send(
            "apt-log",
            "[apt][controller] getRentListInDong, request (si=${si}, gu=${gu}, dong=${dong})"
        )
        kafkaTemplate.send(
            "all-log",
            "[apt][controller] getRentListInDong, request (si=${si}, gu=${gu}, dong=${dong})"
        )

        return ResponseModel(
            payload = aptRentQuery.getListBySiGuDong(
                si = si,
                gu = gu,
                dong = dong,
            ).map { it.toResponse() }
        )
    }

    @Operation(summary = "아파트 전월세 거래 내역")
    @GetMapping("/rent/detail/{si}/{gu}/{dong}/{name}")
    fun getRentDetail(
        @PathVariable si: String,
        @PathVariable gu: String,
        @PathVariable dong: String,
        @PathVariable name: String,
    ): ResponseModel<List<ApartmentResponseDTO.RentResponse>> {
        kafkaTemplate.send(
            "apt-log",
            "[apt][controller] getRentDetail, request (si=${si}, gu=${gu}, dong=${dong}, name=${name})"
        )
        kafkaTemplate.send(
            "all-log",
            "[apt][controller] getRentDetail, request (si=${si}, gu=${gu}, dong=${dong}, name=${name})"
        )

        return ResponseModel(
            payload = aptRentQuery.getAptRentDetail(
                si = si,
                gu = gu,
                dong = dong,
                name = name,
            ).map { it.toResponse() }
        )
    }
}