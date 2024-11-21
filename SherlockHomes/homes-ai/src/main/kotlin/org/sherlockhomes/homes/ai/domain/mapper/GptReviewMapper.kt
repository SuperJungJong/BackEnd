package org.sherlockhomes.homes.ai.domain.mapper

import org.sherlockhomes.homes.ai.application.service.vo.HouseReviewVO
import org.sherlockhomes.homes.ai.domain.GptReview

fun HouseReviewVO.GptReview.toDomain() =
    GptReview(
        trafficScore = trafficScore.toDomain(),
        cumuniteeScore = cumuniteeScore.toDomain(),
        envScore = envScore.toDomain(),
        safetyScore = safetyScore.toDomain(),
        convenienceScore = convenienceScore.toDomain(),
        trendScore = trendScore.toDomain(),
    )

fun HouseReviewVO.ScoreWithCommentVO.toDomain() =
    GptReview.ScoreWithComment(
        score = score,
        plusComment = plusComment,
        minusComment = minusComment,
        totalComment = totalComment,
    )

fun HouseReviewVO.Request.toDomain() =
    GptReview.Request(
        address = address,
        buildingName = buildingName,
    )
