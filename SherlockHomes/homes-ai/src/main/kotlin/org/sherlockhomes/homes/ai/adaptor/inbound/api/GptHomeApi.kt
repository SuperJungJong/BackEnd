package org.sherlockhomes.homes.ai.adaptor.inbound.api

import org.sherlockhomes.homes.ai.adaptor.inbound.api.dto.RecommendRequestDTO
import org.sherlockhomes.homes.ai.adaptor.inbound.api.dto.ReviewRequestDTO
import org.sherlockhomes.homes.ai.adaptor.inbound.api.mapper.toResponse
import org.sherlockhomes.homes.ai.adaptor.inbound.api.mapper.toVO
import org.sherlockhomes.homes.ai.application.port.inbound.AiCommentUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/ai/gpt")
class GptHomeApi(
    private val gptServiceUseCase: AiCommentUseCase,
) {

    @PostMapping("/review")
    fun getReview(
        @RequestBody gptReviewRequestDTO: ReviewRequestDTO.GptReview
    ) = gptServiceUseCase.getHouseReview(
        reviewRequest = gptReviewRequestDTO.toVO(),
    ).toResponse()

    @PostMapping("/recommend")
    fun getRecommend(
        @RequestBody gptRecommendRequestDTO: RecommendRequestDTO.GptRecommend
    ) {
//        gptServiceUseCase.getRecommendHouse()
    }

    @GetMapping("/review/promptEngineer")
    fun getReviewPromptEngineer() {
    }

    @PostMapping("/recommend/promptEngineer")
    fun getRecommendPromptEngineer() {

    }
}