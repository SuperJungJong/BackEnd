package org.sherlockhomes.homes.ai.adaptor.inbound.api.dto

class GptRecommendRequestDTO {
    data class GptRecommend(
        val Address: String,
        val buildingName: String,
    )
}