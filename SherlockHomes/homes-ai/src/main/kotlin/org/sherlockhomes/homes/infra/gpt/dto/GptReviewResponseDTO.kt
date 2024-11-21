package org.sherlockhomes.homes.infra.gpt.dto

import com.fasterxml.jackson.annotation.JsonProperty

class GptReviewResponseDTO {
    data class Response(

        @get:JsonProperty(required = true, value = "standard")
        val standard: Standard,

        @get:JsonProperty(required = true, value = "total_score")
        val totalScore: String,

        @get:JsonProperty(required = true, value = "total_comment")
        val totalComment: String
    )

    data class Standard(

        @get:JsonProperty(required = true, value = "review_list")
        val reviewList: List<Review>
    )

    data class Review(
        @get:JsonProperty(required = true, value = "category")
        val category: String,

        @get:JsonProperty(required = true, value = "score")
        val score: Int,

        @get:JsonProperty(required = true, value = "good")
        val good: String,

        @get:JsonProperty(required = true, value = "bad")
        val bad: String,

        @get:JsonProperty(required = true, value = "total")
        val total: String,
    )
}