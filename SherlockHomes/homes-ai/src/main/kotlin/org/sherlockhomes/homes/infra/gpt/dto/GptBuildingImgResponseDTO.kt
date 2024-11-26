package org.sherlockhomes.homes.infra.gpt.dto

import com.fasterxml.jackson.annotation.JsonProperty

class GptBuildingImgResponseDTO {

    data class Response(
        @get:JsonProperty(required = true, value = "category")
        val imgUrl: String,
    )
}