package org.sherlockhomes.homes.ai.adaptor.inbound.api.mapper

import org.sherlockhomes.homes.ai.adaptor.inbound.api.dto.ReviewRequestDTO
import org.sherlockhomes.homes.ai.adaptor.inbound.api.dto.ReviewResponseDTO
import org.sherlockhomes.homes.ai.application.service.vo.HouseReviewVO

fun ReviewRequestDTO.GptReview.toVO() =
    HouseReviewVO.Request(
        address = address,
        buildingName = buildingName,
    )

fun HouseReviewVO.GptReview.toResponse() =
    ReviewResponseDTO.Response(
        trafficScore = trafficScore.toResponse(),
        cumuniteeScore = cumuniteeScore.toResponse(),
        envScore = envScore.toResponse(),
        safetyScore = safetyScore.toResponse(),
        convenienceScore = convenienceScore.toResponse(),
        trendScore = trendScore.toResponse(),
    )

fun HouseReviewVO.ScoreWithCommentVO.toResponse() =
    ReviewResponseDTO.ScoreWithComment(
        score = score,
        plusComment = plusComment,
        minusComment = minusComment,
        totalComment = totalComment,
    )