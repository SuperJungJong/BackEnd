package org.sherlockhomes.homes.ai.adaptor.outbound

import org.sherlockhomes.homes.ai.adaptor.inbound.api.dto.RecommendResponseDTO
import org.sherlockhomes.homes.ai.adaptor.inbound.api.dto.ReviewResponseDTO
import org.sherlockhomes.homes.ai.application.port.outbound.GptPort
import org.sherlockhomes.homes.ai.application.service.vo.HouseRecommendVO
import org.sherlockhomes.homes.ai.application.service.vo.HouseReviewVO
import org.sherlockhomes.homes.infra.gpt.Prompt.GptReviewPort
import org.springframework.ai.chat.model.ChatModel
import org.springframework.ai.converter.BeanOutputConverter
import org.springframework.stereotype.Component

@Component
class GptAdaptor(
    private val chatModel: ChatModel,
    private val reviewPromptFactory: GptReviewPort<ReviewResponseDTO.Response>,
    private val recommendPromptFactory: GptReviewPort<RecommendResponseDTO.Response>,
) : GptPort {

    override fun getHouseReview(reviewRequest: HouseReviewVO.Request) {
        promptFactory.createPrompt()

        val convert = BeanOutputConverter(ReviewResponseDTO::class.java).convert("asdf")
        val call = chatModel.call(
            "무조건 {" +
                    "trafficScore: {점수, 한줄평}\n" +
                    "cumuniteeScore: {점수, 한줄평}\n" +
                    "envScore: {점수, 한줄평}\n" +
                    "safetyScore: {점수, 한줄평}\n" +
                    "convenienceScore: {점수, 한줄평}\n" +
                    "trendScore: {점수, 한줄평}\n" +
                    "} 과 같은 json 형식으로 한국어로 대답해.\n" +
                    "주소: " + reviewRequest.address + "\n" +
                    "건물명: " + reviewRequest.buildingName + "\n" +
                    "이제 처음에 알려준 형식에 맞춰서 해당 건물을 평가해봐"
        )

        println(call)
    }

    override fun getRecommendHouse(recommendRequest: HouseRecommendVO.Request) {
        TODO("Not yet implemented")
    }

}