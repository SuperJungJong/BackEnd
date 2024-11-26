package org.sherlockhomes.homes.ai.domain.mapper

import org.sherlockhomes.homes.ai.application.service.vo.BuildingImgVO
import org.sherlockhomes.homes.ai.domain.BuildingImg

fun BuildingImg.toVO() =
    BuildingImgVO.BuildingImg(
        imgUrl = imgUrl
    )