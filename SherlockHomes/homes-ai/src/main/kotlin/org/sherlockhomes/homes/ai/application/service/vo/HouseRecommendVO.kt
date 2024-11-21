package org.sherlockhomes.homes.ai.application.service.vo

class HouseRecommendVO {
    data class GptRecommend(
        val trafficScore: ScoreWithCommentVO, //교통 점수
        val cumuniteeScore: ScoreWithCommentVO,  // 커뮤니티 시설 점수
        val envScore: ScoreWithCommentVO, //환경 점수 - 공원 같은거
        val safetyScore: ScoreWithCommentVO, // 치안 안전 점수
        val convenienceScore: ScoreWithCommentVO,  // 생활 편의 점수
        val trendScore: ScoreWithCommentVO, // 주변 핫플 점수
    )

    data class ScoreWithCommentVO(
        val score: Int,
        val plusComment: String,
        val minusComment: String,
        val totalComment: String,
    )

    data class Request(
        val Address: String,
        val buildingName: String,
    )
}