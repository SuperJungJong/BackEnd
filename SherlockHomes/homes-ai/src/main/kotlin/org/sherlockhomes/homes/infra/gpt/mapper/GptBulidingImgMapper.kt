package org.sherlockhomes.homes.infra.gpt.mapper

import org.sherlockhomes.homes.ai.application.service.vo.BuildingImgVO
import org.sherlockhomes.homes.ai.domain.BuildingImg
import org.sherlockhomes.homes.infra.gpt.dto.GptBuildingImgResponseDTO

fun GptBuildingImgResponseDTO.Response.toVO() =
    BuildingImgVO.BuildingImg(
        imgUrl = imgUrl
    )

fun GptBuildingImgResponseDTO.Response.toDomain() =
    BuildingImg(
        imgUrl = imgUrl
    )