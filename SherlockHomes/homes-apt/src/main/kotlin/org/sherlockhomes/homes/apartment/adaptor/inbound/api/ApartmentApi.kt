package org.sherlockhomes.homes.apartment.adaptor.inbound.api

import io.swagger.v3.oas.annotations.Operation
import org.sherlockhomes.homes.apartment.adaptor.inbound.api.dto.AptTradeResponse
import org.sherlockhomes.homes.apartment.adaptor.inbound.api.dto.GuCountResponseDTO
import org.sherlockhomes.homes.apartment.adaptor.inbound.api.mapper.toResponse
import org.sherlockhomes.homes.apartment.application.port.inbound.ApartmentSearchUseCase
import org.sherlockhomes.homes.apartment.application.port.inbound.AptTradeQuery
import org.sherlockhomes.homes.apartment.application.port.inbound.GuCountQuery
import org.sherlockhomes.homes.apartment.application.service.vo.rent.ApartmentRentVO
import org.sherlockhomes.homes.apartment.application.service.vo.trade.ApartmentTradeVO
import org.sherlockhomes.homes.common.responsemodel.ResponseModel
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
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
    private val guCountQuery: GuCountQuery,
) {

    @Operation(summary = "아파트 매매 조회")
    @GetMapping("/trade")
    fun getTradeList(
        @RequestParam lawdCd: Int,
        @RequestParam dealYmd: Int,
    ) = ResponseModel.of(
        payload = apartmentTradeQuery.getList(
            lawdCd = lawdCd,
            dealYmd = dealYmd,
        ).map { it.toResponse() }
    )


    @Operation(summary = "아파트 전월세 조회")
    @GetMapping("/rent")
    fun getRentList(
        @RequestParam lawdCd: Int,
        @RequestParam dealYmd: Int,
    ) = ResponseModel(
        payload = apartmentRentQuery.getList(
            lawdCd = lawdCd,
            dealYmd = dealYmd
        ).map { it.toResponse() }
    )

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
            payload = aptTrade.items.map { it.toResponse() }
        )
    }

    @Operation(summary = "구별 매매량 조회")
    @GetMapping("/trade/gu/{si}")
    fun getGuCount(
        @PathVariable si: String,
    ): ResponseModel<List<GuCountResponseDTO.Response>> = ResponseModel.of(
        payload = guCountQuery.getGuCount(si).map { it.toResponse() },
    )

    @Operation(summary = "동 별 조회할 수 있는 아파트 조회")
    @GetMapping("/trade/dong/{dong}")
    fun getAptInDong(
        @PathVariable dong: String,
    ): ResponseModel<List<AptTradeResponse.Response>> = ResponseModel.of(
        payload = aptTradeQuery.getAptInDong(dong).map { it.toResponse() },
    )

}