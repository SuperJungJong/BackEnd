package org.sherlockhomes.homes.infra.gpt.mapper

import org.sherlockhomes.homes.ai.domain.GptReview
import org.sherlockhomes.homes.infra.gpt.dto.GptReviewResponseDTO


fun GptReviewResponseDTO.Response.toDomain() =
    GptReview(
        standard = standard.toDomain(),
        totalScore = totalScore,
        totalComment = totalComment,
    )

fun GptReviewResponseDTO.Standard.toDomain() =
    GptReview.Standard(
        reviewList = reviewList.map { it.toDomain() }
    )

fun GptReviewResponseDTO.Review.toDomain() =
    GptReview.Review(
        category = category,
        score = score,
        good = good,
        bad = bad,
        total = total,
    )