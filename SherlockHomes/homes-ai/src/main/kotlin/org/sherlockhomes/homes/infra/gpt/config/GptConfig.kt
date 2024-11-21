package org.sherlockhomes.homes.infra.gpt.config

import org.springframework.ai.openai.OpenAiChatModel
import org.springframework.ai.openai.OpenAiChatOptions
import org.springframework.ai.openai.api.OpenAiApi
import org.springframework.ai.vectorstore.filter.converter.PineconeFilterExpressionConverter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GptConfig {

    @Value("\${GPT_KEY}")
    lateinit var GPT_KEY: String

    @Value("\${MODEL}")
    lateinit var MODEL: String

    @Value("\${TEMPERATURE}")
    lateinit var TEMPERATURE: String

    @Bean
    fun chatModel() = OpenAiChatModel(
        openAiApi(),
        openAiChatOptions(),
    )

    fun openAiApi(): OpenAiApi = OpenAiApi(GPT_KEY)

    fun openAiChatOptions() = OpenAiChatOptions.builder()
        .withModel(MODEL)
        .withTemperature(TEMPERATURE.toDouble())
        .build()
}