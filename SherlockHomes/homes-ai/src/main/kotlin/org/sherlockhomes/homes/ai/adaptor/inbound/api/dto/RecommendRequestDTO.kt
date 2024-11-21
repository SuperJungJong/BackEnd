package org.sherlockhomes.homes.ai.adaptor.inbound.api.dto

class RecommendRequestDTO {
    data class GptRecommend(
        val Address: String,
        val buildingName: String,
    )
}