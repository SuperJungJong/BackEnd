package org.sherlockhomes.homes.infra.gpt.Prompt

import org.sherlockhomes.homes.infra.gpt.dto.GptBuildingImgResponseDTO
import org.sherlockhomes.homes.infra.gpt.dto.GptReviewRequestDTO
import org.springframework.ai.chat.model.ChatModel
import org.springframework.ai.chat.prompt.Prompt
import org.springframework.ai.converter.BeanOutputConverter
import org.springframework.ai.openai.OpenAiChatOptions
import org.springframework.ai.openai.api.OpenAiApi
import org.springframework.ai.openai.api.ResponseFormat
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build
import org.springframework.stereotype.Component

@Component
class BuildingImgPromptModel(
    private val chatModel: ChatModel,
) : BuildingImgPort {

    @Value("\${BUILDING_IMG_PROMPT_ENGEERING}")
    lateinit var BUILDING_IMG_PROMPT_ENGEERING: String

    private val outputConverter = BeanOutputConverter(
        GptBuildingImgResponseDTO.Response::class.java
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

    override fun call(si: String, gu: String, dong: String, name: String): GptBuildingImgResponseDTO.Response {
        val response = chatModel.call(createPrompt(si, gu, dong, name))
        val content = response.result.output.content

        return outputConverter.convert(content)!!
    }

    fun createPrompt(si: String, gu: String, dong: String, name: String): Prompt {
        val houseInfo = "\n주소-시: " + si + "\n" +
                "주소-구: " + gu + "\n" +
                "주소-동: " + dong + "\n" +
                "건물명 : " + name + "\n"
        val contents = BUILDING_IMG_PROMPT_ENGEERING + houseInfo

        return Prompt(
            contents,
            openAiChatoption,
        )
    }
}