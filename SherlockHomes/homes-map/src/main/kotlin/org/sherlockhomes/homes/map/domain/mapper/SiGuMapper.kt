package org.sherlockhomes.homes.map.domain.mapper

import org.sherlockhomes.homes.map.application.service.legaldong.vo.GuVO
import org.sherlockhomes.homes.map.application.service.legaldong.vo.SiVO
import org.sherlockhomes.homes.map.domain.Gu
import org.sherlockhomes.homes.map.domain.Si
import org.sherlockhomes.homes.infra.rdb.entity.GuEntity
import org.sherlockhomes.homes.infra.rdb.entity.SiEntity

fun Si.toVO(): SiVO.Si =
    SiVO.Si(
        code = code,
        name = name,
    )

fun Gu.toVO(): GuVO.Gu =
    GuVO.Gu(
        code = code,
        name = name
    )

fun GuEntity.toDomain() =
    Gu(
        code = code,
        name = name
    )


fun SiEntity.toDomain() =
    Si(
        code = code,
        name = name
    )