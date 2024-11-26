package org.sherlockhomes.homes.map.adaptor.inbound.api

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import io.swagger.v3.oas.annotations.Operation
import org.sherlockhomes.homes.common.responsemodel.ResponseModel
import org.sherlockhomes.homes.map.adaptor.inbound.api.dto.GuResponseDTO
import org.sherlockhomes.homes.map.adaptor.inbound.api.dto.GugunDongResponseDTO
import org.sherlockhomes.homes.map.adaptor.inbound.api.dto.SiResponseDTO
import org.sherlockhomes.homes.map.adaptor.inbound.api.mapper.toResponse
import org.sherlockhomes.homes.map.application.port.inbound.GugunDongQuery
import org.sherlockhomes.homes.map.application.port.inbound.LegalDongQuery
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/map")
class LegalDongApi(
    private val legalDongQuery: LegalDongQuery,
    private val gugunDongQuery: GugunDongQuery,
    private val kafkaTemplate: KafkaTemplate<String, String>,
) {

    @Operation(summary = "시 조회 API")
    @GetMapping("/si")
    fun getSiList(): ResponseModel<List<SiResponseDTO.Response>> {
        kafkaTemplate.send("map-log", "[map][controller] /si")
        kafkaTemplate.send("all-log", "[map][controller] /si")

        return ResponseModel.of(
            payload = legalDongQuery
                .getSiList()
                .map { it.toResponse() },
        )
    }

    @Operation(summary = "구 조회 API")
    @GetMapping("/gu")
    fun getGuList(
        @RequestParam si: String,
    ): ResponseModel<List<GuResponseDTO.Response>> {
        kafkaTemplate.send("map-log", "[map][controller] /gu, request (si=${si})")
        kafkaTemplate.send("all-log", "[map][controller] /gu, request (si=${si})")

        return ResponseModel.of(
            payload = legalDongQuery.getGuList(
                code = si
            ).map { it.toResponse() }
        )
    }

    @Operation(summary = "동 조회 API")
    @GetMapping("/dong")
    fun getDongs(
        @RequestParam gu: String,
    ): ResponseModel<List<GugunDongResponseDTO.Response>> {
        kafkaTemplate.send("map-log", "[map][controller] /dong, request (gu=${gu})")
        kafkaTemplate.send("all-log", "[map][controller] /dong, request (gu=${gu})")

        return ResponseModel.of(
            payload = gugunDongQuery.getGugunDong(gu).map { it.toResponse() },
        )
    }
}