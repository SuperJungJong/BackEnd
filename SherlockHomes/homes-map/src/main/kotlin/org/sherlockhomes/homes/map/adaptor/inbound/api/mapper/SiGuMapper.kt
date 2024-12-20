package org.sherlockhomes.homes.map.adaptor.inbound.api.mapper

import org.sherlockhomes.homes.map.adaptor.inbound.api.dto.GuResponseDTO
import org.sherlockhomes.homes.map.adaptor.inbound.api.dto.SiResponseDTO
import org.sherlockhomes.homes.map.application.service.legaldong.vo.GuVO
import org.sherlockhomes.homes.map.application.service.legaldong.vo.SiVO

// 시
fun SiVO.Si.toResponse(): SiResponseDTO.Response =
    SiResponseDTO.Response(
        code = code,
        name = name
    )

//ㄱ구
fun GuVO.Gu.toResponse(): GuResponseDTO.Response =
    GuResponseDTO.Response(
        code = code,
        name = name
    )