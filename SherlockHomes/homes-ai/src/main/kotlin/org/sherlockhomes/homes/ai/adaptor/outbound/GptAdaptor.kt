package org.sherlockhomes.homes.ai.adaptor.outbound

import org.sherlockhomes.homes.ai.application.port.outbound.GptPort
import org.sherlockhomes.homes.ai.application.service.vo.HouseRecommendVO
import org.sherlockhomes.homes.ai.application.service.vo.HouseReviewVO
import org.sherlockhomes.homes.ai.domain.BuildingImg
import org.sherlockhomes.homes.ai.domain.GptReview
import org.sherlockhomes.homes.infra.gpt.Prompt.BuildingImgPort
import org.sherlockhomes.homes.infra.gpt.Prompt.GptReviewPort
import org.sherlockhomes.homes.infra.gpt.mapper.toDomain
import org.sherlockhomes.homes.infra.gpt.mapper.toRequest
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class GptAdaptor(
    private val reviewPromptModel: GptReviewPort,
    private val buildImgPromptModel: BuildingImgPort,
//    private val recommendPromptFactory: GptReviewPort<RecommendResponseDTO.Response>,
    private val kafkaTemplate: KafkaTemplate<String, String>
) : GptPort {
    override fun getHouseReview(reviewRequest: HouseReviewVO.Request): GptReview {
        kafkaTemplate.send(
            "ek-log",
            "[ai][adaptor][start] GptAdaptor.getHouseReview "
        )
        kafkaTemplate.send(
            "all-log",
            "[ai][adaptor][start] GptAdaptor.getHouseReview "
        )
        val toDomain = reviewPromptModel.call(
            reviewRequest.toRequest()
        ).toDomain()
        println("toDomain = ${toDomain}")
        kafkaTemplate.send(
            "ai-log",
            "[ai][adaptor][end] GptAdaptor.getHouseReview"
        )
        kafkaTemplate.send(
            "all-log",
            "[ai][adaptor][end] GptAdaptor.getHouseReview"
        )
        return toDomain
    }

    override fun getRecommendHouse(recommendRequest: HouseRecommendVO.Request) {
        TODO("Not yet implemented")
    }

    override fun getBuildingImgUrl(si: String, gu: String, dong: String, name: String): BuildingImg {
        val toDomain = buildImgPromptModel.call(si, gu, dong, name).toDomain()

        kafkaTemplate.send(
            "ai-log",
            "[ai][adaptor][end] GptAdaptor.getBuildingImgUrl"
        )
        kafkaTemplate.send(
            "all-log",
            "[ai][adaptor][end] GptAdaptor.getBuildingImgUrl"
        )
        return toDomain
    }

}