package org.sherlockhomes.homes.map.domain.mapper

import org.sherlockhomes.homes.infra.rdb.entity.DongCodeEntity
import org.sherlockhomes.homes.map.application.service.legaldong.vo.GugunDongVO
import org.sherlockhomes.homes.map.domain.GugunDong

fun DongCodeEntity.toGugunDong() = GugunDong(
    gugunName = gugunName,
    dongName = dongName,
)

fun GugunDong.toVO() = GugunDongVO.Gugun(
    gugunName = gugunName,
    dongName = dongName,
)