package org.sherlockhomes.homes.ai.adaptor.inbound.api

import org.sherlockhomes.homes.ai.adaptor.inbound.api.dto.GptRecommendRequestDTO
import org.sherlockhomes.homes.ai.adaptor.inbound.api.dto.GptReviewRequestDTO
import org.sherlockhomes.homes.ai.adaptor.inbound.api.mapper.toVO
import org.sherlockhomes.homes.ai.application.port.inbound.GptServiceUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/ai/gpt")
class GptApi(
    private val gptServiceUseCase: GptServiceUseCase,
) {

    @PostMapping("/review")
    fun getReview(
        @RequestBody gptReviewRequestDTO: GptReviewRequestDTO.GptReview
    ) {
        gptServiceUseCase.getHouseReview(
            reviewRequest = gptReviewRequestDTO.toVO(),
        )
    }

    @PostMapping("/recommend")
    fun getRecommend(
        @RequestBody gptRecommendRequestDTO: GptRecommendRequestDTO.GptRecommend
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