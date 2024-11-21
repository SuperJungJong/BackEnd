package org.sherlockhomes.homes.infra.gpt.dto

class GptReviewRequestDTO {
    data class GptReview(
        val address: String,
        val buildingName: String,
    )
}