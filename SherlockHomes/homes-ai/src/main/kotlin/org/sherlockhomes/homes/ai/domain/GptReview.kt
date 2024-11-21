package org.sherlockhomes.homes.ai.domain


data class GptReview(
    val standard: Standard,
    val totalScore: String,
    val totalComment: String
) {

    data class Standard(
        val reviewList: List<Review>
    )

    data class Review(
        val category: String,
        val score: Int,
        val good: String,
        val bad: String,
        val total: String,
    )

}