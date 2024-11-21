package org.sherlockhomes.homes.ai.adaptor.outbound

import org.sherlockhomes.homes.ai.application.port.outbound.GptPort
import org.sherlockhomes.homes.ai.application.service.vo.HouseRecommendVO
import org.sherlockhomes.homes.ai.application.service.vo.HouseReviewVO
import org.sherlockhomes.homes.ai.domain.GptReview
import org.sherlockhomes.homes.infra.gpt.Prompt.GptReviewPort
import org.sherlockhomes.homes.infra.gpt.mapper.toDomain
import org.sherlockhomes.homes.infra.gpt.mapper.toRequest
import org.springframework.stereotype.Component

@Component
class GptAdaptor(
    private val reviewPromptModel: GptReviewPort,
//    private val recommendPromptFactory: GptReviewPort<RecommendResponseDTO.Response>,
) : GptPort {

    override fun getHouseReview(reviewRequest: HouseReviewVO.Request): GptReview =
        reviewPromptModel.call(
            reviewRequest.toRequest()
        ).toDomain()

    override fun getRecommendHouse(recommendRequest: HouseRecommendVO.Request) {
        TODO("Not yet implemented")
    }


}