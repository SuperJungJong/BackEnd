package org.sherlockhomes.homes.ai.adaptor.inbound.api.dto

class GptReviewRequestDTO {
    data class GptReview(
        val address: String,
        val buildingName: String,
    )
}