package org.sherlockhomes.homes.ai.application.port.outbound

import org.sherlockhomes.homes.ai.application.service.vo.GptRecommendVO
import org.sherlockhomes.homes.ai.application.service.vo.GptReviewVO

interface GptPort {
    fun getHouseReview(reviewRequest: GptReviewVO.Request)

    fun getRecommendHouse(recommendRequest: GptRecommendVO.Request)
}