package org.sherlockhomes.homes.apartment.adaptor.inbound.api.mapper

import org.sherlockhomes.homes.apartment.adaptor.inbound.api.dto.GuCountResponseDTO
import org.sherlockhomes.homes.apartment.application.service.vo.GuCountVO

fun GuCountVO.GuCount.toResponse() = GuCountResponseDTO.Response(
    siName = siName,
    guName = guName,
    count = count,
)
