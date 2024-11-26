package org.sherlockhomes.homes.infra.gpt.Prompt

import org.sherlockhomes.homes.infra.gpt.dto.GptBuildingImgResponseDTO

interface BuildingImgPort {

    fun call(
        si: String,
        gu: String,
        dong: String,
        name: String,
    ): GptBuildingImgResponseDTO.Response // 빌딩 이미지 레스폰트 dto

}