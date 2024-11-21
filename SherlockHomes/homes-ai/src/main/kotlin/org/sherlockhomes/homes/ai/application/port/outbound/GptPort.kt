package org.sherlockhomes.homes.ai.application.port.outbound

import org.sherlockhomes.homes.ai.application.service.vo.HouseRecommendVO
import org.sherlockhomes.homes.ai.application.service.vo.HouseReviewVO
import org.sherlockhomes.homes.ai.domain.GptReview

interface GptPort {
    fun getHouseReview(reviewRequest: HouseReviewVO.Request): GptReview

    fun getRecommendHouse(recommendRequest: HouseRecommendVO.Request)
}