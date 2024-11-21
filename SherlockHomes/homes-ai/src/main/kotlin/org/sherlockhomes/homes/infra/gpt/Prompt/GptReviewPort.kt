package org.sherlockhomes.homes.infra.gpt.Prompt

import org.sherlockhomes.homes.infra.gpt.dto.GptReviewRequestDTO
import org.sherlockhomes.homes.infra.gpt.dto.GptReviewResponseDTO

interface GptReviewPort {
    fun call(gptReviewRequestDTO: GptReviewRequestDTO.GptReview): GptReviewResponseDTO.Response
}