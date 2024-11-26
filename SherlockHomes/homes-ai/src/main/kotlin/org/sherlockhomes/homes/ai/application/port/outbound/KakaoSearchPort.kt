package org.sherlockhomes.homes.ai.application.port.outbound

import org.sherlockhomes.homes.ai.domain.BuildingImg

interface KakaoSearchPort {
    fun kakaoImgSearch(
        si: String,
        gu: String,
        dong: String,
        name: String,
    ): BuildingImg
}
