package org.sherlockhomes.homes.ai.application.port.outbound

import org.sherlockhomes.homes.ai.application.service.vo.HouseRecommendVO
import org.sherlockhomes.homes.ai.application.service.vo.HouseReviewVO

interface GptPort {
    fun getHouseReview(reviewRequest: HouseReviewVO.Request)

    fun getRecommendHouse(recommendRequest: HouseRecommendVO.Request)
}