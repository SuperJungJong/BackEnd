package org.sherlockhomes.homes.ai.application.port.inbound

import org.sherlockhomes.homes.ai.application.service.vo.BuildingImgVO
import org.sherlockhomes.homes.ai.application.service.vo.HouseRecommendVO
import org.sherlockhomes.homes.ai.application.service.vo.HouseReviewVO

interface AiCommentUseCase {

    fun getHouseReview(reviewRequest: HouseReviewVO.Request): HouseReviewVO.Response

    fun getRecommendHouse(recommendRequest: HouseRecommendVO.GptRecommend)

    fun getBuildingImg(
        si: String,
        gu: String,
        dong: String,
        name: String,
    ): BuildingImgVO.BuildingImg
}
