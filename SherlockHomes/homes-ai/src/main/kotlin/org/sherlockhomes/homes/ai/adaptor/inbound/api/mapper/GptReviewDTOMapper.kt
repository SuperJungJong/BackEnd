package org.sherlockhomes.homes.ai.adaptor.inbound.api.mapper

import org.sherlockhomes.homes.ai.adaptor.inbound.api.dto.ReviewRequestDTO
import org.sherlockhomes.homes.ai.adaptor.inbound.api.dto.ReviewResponseDTO
import org.sherlockhomes.homes.ai.application.service.vo.HouseReviewVO

fun ReviewRequestDTO.GptReview.toVO() =
    HouseReviewVO.Request(
        address = address,
        buildingName = buildingName,
    )

fun HouseReviewVO.Response.toResponse() =
    ReviewResponseDTO.Response(
        standard = standard.toResponse(),
        totalScore = totalScore,
        totalComment = totalComment,
    )

fun HouseReviewVO.Standard.toResponse() =
    ReviewResponseDTO.Standard(
        reviewList = reviewList.map { it.toResponse() }
    )

fun HouseReviewVO.Review.toResponse() =
    ReviewResponseDTO.Review(
        category = category,
        score = score,
        good = good,
        bad = bad,
        total = total,
    )