package org.sherlockhomes.homes.ai.adaptor.outbound

import org.sherlockhomes.homes.ai.application.port.outbound.GptPort
import org.sherlockhomes.homes.ai.application.service.vo.GptRecommendVO
import org.sherlockhomes.homes.ai.application.service.vo.GptReviewVO
import org.springframework.ai.chat.model.ChatModel
import org.springframework.ai.chat.prompt.Prompt
import org.springframework.ai.openai.OpenAiChatModel
import org.springframework.stereotype.Component

@Component
class GptAdaptor(
    private val chatModel: ChatModel
) : GptPort {

    override fun getHouseReview(reviewRequest: GptReviewVO.Request) {
        Prompt


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

    override fun getRecommendHouse(recommendRequest: GptRecommendVO.Request) {
        TODO("Not yet implemented")
    }

}