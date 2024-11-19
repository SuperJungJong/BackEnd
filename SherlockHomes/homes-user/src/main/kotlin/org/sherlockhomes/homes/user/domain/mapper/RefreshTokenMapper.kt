package org.sherlockhomes.homes.user.domain.mapper

import org.sherlockhomes.homes.infra.rdb.entity.RefreshTokenEntity
import org.sherlockhomes.homes.user.domain.RefreshToken

fun RefreshToken.toEntity(): RefreshTokenEntity =
    RefreshTokenEntity(
        id = id,
        ci = ci,
        refreshToken = refreshToken,
        userId = userId,
    )

fun RefreshTokenEntity.toDomain(): RefreshToken =
    RefreshToken(
        id = id,
        ci = ci,
        refreshToken = refreshToken,
        userId = userId,
    )