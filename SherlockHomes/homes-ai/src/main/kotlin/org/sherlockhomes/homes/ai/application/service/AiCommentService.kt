package org.sherlockhomes.homes.ai.application.service

import org.sherlockhomes.homes.ai.application.port.inbound.AiCommentUseCase
import org.sherlockhomes.homes.ai.application.port.outbound.GptPort
import org.sherlockhomes.homes.ai.application.service.vo.HouseRecommendVO
import org.sherlockhomes.homes.ai.application.service.vo.HouseReviewVO
import org.sherlockhomes.homes.ai.domain.mapper.toVO
import org.springframework.stereotype.Service

@Service
class AiCommentService(
    private val gptPort: GptPort,
) : AiCommentUseCase {

    //TODO 1. 캐시에서 확인
    //TODO 2. 캐시에 있으면 꺼내서 응답 -> (비동기적으로 캐시에 저장 -> 프론트에서 캐시 풀링)
    //TODO 3. 캐시에 없으면 요청후 응답
    override fun getHouseReview(reviewRequest: HouseReviewVO.Request): HouseReviewVO.Response =
        gptPort.getHouseReview(reviewRequest).toVO()

    override fun getRecommendHouse(recommendRequest: HouseRecommendVO.GptRecommend) {
//        gptPort.getRecommendHouse()
    }
}