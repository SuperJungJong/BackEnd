package org.sherlockhomes.homes.ai.domain.mapper

import org.sherlockhomes.homes.ai.application.service.vo.HouseReviewVO
import org.sherlockhomes.homes.ai.domain.GptReview

fun HouseReviewVO.Response.toDomain() =
    GptReview(
        standard = standard.toDomain(),
        totalScore = totalScore,
        totalComment = totalComment,
    )

fun HouseReviewVO.Standard.toDomain() =
    GptReview.Standard(
        reviewList = reviewList.map { it.toDomain() }
    )

fun HouseReviewVO.Review.toDomain() =
    GptReview.Review(
        category = category,
        score = score,
        good = good,
        bad = bad,
        total = total,
    )

fun GptReview.toVO() =
    HouseReviewVO.Response(
        standard = standard.toVO(),
        totalScore = totalScore,
        totalComment = totalComment,
    )

fun GptReview.Standard.toVO() =
    HouseReviewVO.Standard(
        reviewList = reviewList.map { it.toVO() }
    )

fun GptReview.Review.toVO() =
    HouseReviewVO.Review(
        category = category,
        score = score,
        good = good,
        bad = bad,
        total = total,
    )