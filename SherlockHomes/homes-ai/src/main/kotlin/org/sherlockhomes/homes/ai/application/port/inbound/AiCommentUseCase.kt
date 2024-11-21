package org.sherlockhomes.homes.ai.application.port.inbound

import org.sherlockhomes.homes.ai.application.service.vo.HouseRecommendVO
import org.sherlockhomes.homes.ai.application.service.vo.HouseReviewVO

interface AiCommentUseCase {

    fun getHouseReview(reviewRequest: HouseReviewVO.Request)
//    fun getHouseReview(reviewRequest: GptReviewVO.Request): GptReviewVO.GptReview

    fun getRecommendHouse(recommendRequest: HouseRecommendVO.GptRecommend)
//    fun getRecommendHouse(recommendRequest: GptRecommendVO.GptRecommend): GptRecommendVO.GptRecommend
}
