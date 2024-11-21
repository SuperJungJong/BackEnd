package org.sherlockhomes.homes.ai.domain.mapper

import org.sherlockhomes.homes.ai.application.service.vo.GptReviewVO
import org.sherlockhomes.homes.ai.domain.GptReview

fun GptReviewVO.GptReview.toDomain() =
    GptReview(
        trafficScore = trafficScore.toDomain(),
        cumuniteeScore = cumuniteeScore.toDomain(),
        envScore = envScore.toDomain(),
        safetyScore = safetyScore.toDomain(),
        convenienceScore = convenienceScore.toDomain(),
        trendScore = trendScore.toDomain(),
    )

fun GptReviewVO.ScoreWithCommentVO.toDomain() =
    GptReview.ScoreWithComment(
        score = score,
        plusComment = plusComment,
        minusComment = minusComment,
        totalComment = totalComment,
    )

fun GptReviewVO.Request.toDomain() =
    GptReview.Request(
        address = address,
        buildingName = buildingName,
    )
