package org.sherlockhomes.homes.map.adaptor.inbound.api.mapper

import org.sherlockhomes.homes.map.adaptor.inbound.api.dto.GugunDongResponseDTO
import org.sherlockhomes.homes.map.application.service.legaldong.vo.GugunDongVO

fun GugunDongVO.Gugun.toResponse() = GugunDongResponseDTO.Response(
    gugunName = gugunName,
    name = dongName,
)