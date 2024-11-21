package org.sherlockhomes.homes.infra.gpt.Prompt

import org.sherlockhomes.homes.infra.gpt.dto.GptReviewRequestDTO
import org.sherlockhomes.homes.infra.gpt.dto.GptReviewResponseDTO
import org.springframework.ai.chat.model.ChatModel
import org.springframework.ai.chat.prompt.Prompt
import org.springframework.ai.converter.BeanOutputConverter
import org.springframework.ai.openai.OpenAiChatOptions
import org.springframework.ai.openai.api.OpenAiApi
import org.springframework.ai.openai.api.ResponseFormat
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class ReviewPromptModel(
    private val chatModel: ChatModel,
) : GptReviewPort {

    @Value("\${REVIEW_PROMPT_ENGEERING}")
    lateinit var REVIEW_PROMPT_ENGEERING: String

    private val outputConverter = BeanOutputConverter(
        GptReviewResponseDTO.Response::class.java
    )

    private val openAiChatoption = OpenAiChatOptions.builder()
        .withModel(OpenAiApi.ChatModel.GPT_4_O)
        .withResponseFormat(
            ResponseFormat(
                ResponseFormat.Type.JSON_SCHEMA,
                outputConverter.jsonSchema,
            )
        )
        .build()

    override fun call(request: GptReviewRequestDTO.GptReview): GptReviewResponseDTO.Response {
        val response = chatModel.call(createPrompt(request))
        val content = response.result.output.content

        return outputConverter.convert(content)!!
    }

    fun createPrompt(gptReviewRequestDTO: GptReviewRequestDTO.GptReview): Prompt {
        val houseInfo = "\n주소 : " + gptReviewRequestDTO.buildingName + "\n" +
                "건물명 : " + gptReviewRequestDTO.address + "\n"
        val contents = REVIEW_PROMPT_ENGEERING + houseInfo

        return Prompt(
            contents,
            openAiChatoption,
        )
    }
}