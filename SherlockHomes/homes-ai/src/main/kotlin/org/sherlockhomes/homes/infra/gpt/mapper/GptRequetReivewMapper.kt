package org.sherlockhomes.homes.infra.gpt.mapper

import org.sherlockhomes.homes.ai.application.service.vo.HouseReviewVO
import org.sherlockhomes.homes.infra.gpt.dto.GptReviewRequestDTO

fun HouseReviewVO.Request.toRequest() =
    GptReviewRequestDTO.GptReview(
        address = address,
        buildingName = buildingName,
    )