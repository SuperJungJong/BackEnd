package org.sherlockhomes.homes.common.adaptor.inbound.api

import io.swagger.v3.oas.annotations.Operation
import org.sherlockhomes.homes.common.adaptor.inbound.api.dto.GuResponseDTO
import org.sherlockhomes.homes.common.adaptor.inbound.api.dto.SiResponseDTO
import org.sherlockhomes.homes.common.adaptor.inbound.api.mapper.toResponse
import org.sherlockhomes.homes.common.application.port.inbound.LegalDongQuery
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/map")
class LegalDongApi(
    private val legalDongQuery: LegalDongQuery,
) {

    @Operation(summary = "시 조회 API")
    @GetMapping("/si")
    fun getSiList(): List<SiResponseDTO.Response> =
        legalDongQuery
            .getSiList()
            .map { it.toResponse() }

    @Operation(summary = "구 조회 API")
    @GetMapping("/gu")
    fun getGuList(
        @RequestParam si: String,
    ): List<GuResponseDTO.Response> =
        legalDongQuery.getGuList(
            code = si
        ).map { it.toResponse() }


}