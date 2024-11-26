package org.sherlockhomes.homes.ai.adaptor.inbound.api

import org.sherlockhomes.homes.ai.adaptor.inbound.api.dto.RecommendRequestDTO
import org.sherlockhomes.homes.ai.adaptor.inbound.api.dto.ReviewRequestDTO
import org.sherlockhomes.homes.ai.adaptor.inbound.api.dto.ReviewResponseDTO
import org.sherlockhomes.homes.ai.adaptor.inbound.api.mapper.toResponse
import org.sherlockhomes.homes.ai.adaptor.inbound.api.mapper.toVO
import org.sherlockhomes.homes.ai.application.port.inbound.AiCommentUseCase
import org.sherlockhomes.homes.ai.application.service.vo.BuildingImgVO
import org.sherlockhomes.homes.common.responsemodel.ResponseModel
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/ai/gpt")
class GptHomeApi(
    private val gptServiceUseCase: AiCommentUseCase,
    private val kafkaTemplate: KafkaTemplate<String, String>,
) {

    @PostMapping("/review")
    fun getReview(
        @RequestBody gptReviewRequestDTO: ReviewRequestDTO.GptReview
    ): ReviewResponseDTO.Response {
        kafkaTemplate.send("ai-log", "[ai][controller] /review, request")
        kafkaTemplate.send("all-log", "[ai][controller] /review, request")

        return gptServiceUseCase.getHouseReview(
            reviewRequest = gptReviewRequestDTO.toVO(),
        ).toResponse()
    }

    @PostMapping("/recommend")
    fun getRecommend(
        @RequestBody gptRecommendRequestDTO: RecommendRequestDTO.GptRecommend
    ) {
//        kafkaTemplate.send("ekek", "ekek")
    }

    @GetMapping("/img/{si}/{gu}/{dong}/{name}")
    fun getReviewPromptEngineer(
        @PathVariable si: String,
        @PathVariable gu: String,
        @PathVariable dong: String,
        @PathVariable name: String,
    ): ResponseModel<BuildingImgVO.BuildingImg> {
        kafkaTemplate.send(
            "ai-log",
            "[ai][controller] getReviewPromptEngineer, request (si=${si}, gu=${gu}, dong=${dong}, name=${name})"
        )
        kafkaTemplate.send(
            "all-log",
            "[ai][controller] getReviewPromptEngineer, request (si=${si}, gu=${gu}, dong=${dong}, name=${name})"
        )

        return ResponseModel.of(
            payload = gptServiceUseCase.getBuildingImg(si, gu, dong, name)
        )
    }


}