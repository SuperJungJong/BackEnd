package org.sherlockhomes.homes.ai.application.port.inbound

import org.sherlockhomes.homes.ai.application.service.vo.GptRecommendVO
import org.sherlockhomes.homes.ai.application.service.vo.GptReviewVO

interface GptServiceUseCase {

    fun getHouseReview(reviewRequest: GptReviewVO.Request)
//    fun getHouseReview(reviewRequest: GptReviewVO.Request): GptReviewVO.GptReview

    fun getRecommendHouse(recommendRequest: GptRecommendVO.GptRecommend)
//    fun getRecommendHouse(recommendRequest: GptRecommendVO.GptRecommend): GptRecommendVO.GptRecommend
}
