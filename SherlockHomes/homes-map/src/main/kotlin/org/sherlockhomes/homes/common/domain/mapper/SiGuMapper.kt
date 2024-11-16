package org.sherlockhomes.homes.common.domain.mapper

import org.sherlockhomes.homes.common.application.service.legaldong.vo.GuVO
import org.sherlockhomes.homes.common.application.service.legaldong.vo.SiVO
import org.sherlockhomes.homes.common.domain.Gu
import org.sherlockhomes.homes.common.domain.Si
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