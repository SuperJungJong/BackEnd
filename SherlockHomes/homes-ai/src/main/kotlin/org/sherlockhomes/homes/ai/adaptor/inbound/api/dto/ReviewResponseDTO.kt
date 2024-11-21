package org.sherlockhomes.homes.ai.adaptor.inbound.api.dto

class ReviewResponseDTO {
    data class Response(
        val trafficScore: ScoreWithComment, //교통 점수
        val cumuniteeScore: ScoreWithComment,  // 커뮤니티 시설 점수
        val envScore: ScoreWithComment, //환경 점수 - 공원 같은거
        val safetyScore: ScoreWithComment, // 치안 안전 점수
        val convenienceScore: ScoreWithComment,  // 생활 편의 점수
        val trendScore: ScoreWithComment, // 주변 핫플 점수
    )

    data class ScoreWithComment(
        val score: Int,
        val plusComment: String,
        val minusComment: String,
        val totalComment: String,
    )
}