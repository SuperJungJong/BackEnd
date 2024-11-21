package org.sherlockhomes.homes.ai.application.service

import org.sherlockhomes.homes.ai.application.port.inbound.GptServiceUseCase
import org.sherlockhomes.homes.ai.application.port.outbound.GptPort
import org.sherlockhomes.homes.ai.application.service.vo.GptRecommendVO
import org.sherlockhomes.homes.ai.application.service.vo.GptReviewVO
import org.springframework.stereotype.Service

@Service
class GptReviewService(
    private val gptPort: GptPort,
) : GptServiceUseCase {
    override fun getHouseReview(reviewRequest: GptReviewVO.Request) {
        //TODO 1. 캐시에서 확인
        //TODO 2. 캐시에 있으면 꺼내서 응답 -> (비동기적으로 캐시에 저장 -> 프론트에서 캐시 풀링)
        //TODO 3. 캐시에 없으면 요청후 응답
        gptPort.getHouseReview(reviewRequest)
    }

    override fun getRecommendHouse(recommendRequest: GptRecommendVO.GptRecommend) {
//        gptPort.getRecommendHouse()
    }


}