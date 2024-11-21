package org.sherlockhomes.homes.ai.adaptor.inbound.api.mapper

import org.sherlockhomes.homes.ai.adaptor.inbound.api.dto.GptReviewRequestDTO
import org.sherlockhomes.homes.ai.adaptor.inbound.api.dto.GptReviewResponseDTO
import org.sherlockhomes.homes.ai.application.service.vo.GptReviewVO

fun GptReviewRequestDTO.GptReview.toVO() =
    GptReviewVO.Request(
        address = address,
        buildingName = buildingName,
    )

fun GptReviewVO.GptReview.toResponse() =
    GptReviewResponseDTO.Response(
        trafficScore = trafficScore.toResponse(),
        cumuniteeScore = cumuniteeScore.toResponse(),
        envScore = envScore.toResponse(),
        safetyScore = safetyScore.toResponse(),
        convenienceScore = convenienceScore.toResponse(),
        trendScore = trendScore.toResponse(),
    )

fun GptReviewVO.ScoreWithCommentVO.toResponse() =
    GptReviewResponseDTO.ScoreWithComment(
        score = score,
        plusComment = plusComment,
        minusComment = minusComment,
        totalComment = totalComment,
    )