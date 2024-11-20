package org.sherlockhomes.homes.apartment.domain.mapper

import org.sherlockhomes.homes.apartment.application.service.vo.GuCountVO
import org.sherlockhomes.homes.apartment.domain.GuCount
import org.sherlockhomes.homes.infra.rdb.entity.GuCountEntity

fun GuCountEntity.toDomain() = GuCount(
    siName = siName,
    guName = guName,
    count = count,
)

fun GuCount.toVO() = GuCountVO.GuCount(
    siName = siName,
    guName = guName,
    count = count,
)

