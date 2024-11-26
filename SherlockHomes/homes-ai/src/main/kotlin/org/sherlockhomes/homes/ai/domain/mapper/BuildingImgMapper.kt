package org.sherlockhomes.homes.ai.domain.mapper

import org.sherlockhomes.homes.ai.domain.BuildingImg
import org.sherlockhomes.homes.infra.webclient.dto.BuildingImgResponseDTO

fun BuildingImgResponseDTO.Response.toDomain() =
    BuildingImg(
        imgUrl = documents[0].image_url
    )