package org.sherlockhomes.homes.user.domain.mapper

import org.sherlockhomes.homes.infra.rdb.entity.UserEntity
import org.sherlockhomes.homes.user.application.service.user.VO.UserVO
import org.sherlockhomes.homes.user.domain.User

fun UserEntity.toDomain(): User =
    User(
        id = id,
        nickname = nickname,
        method = method,
        ci = ci,
        image = image,
        role = role,
        registeredAt = registeredAt!!,
        modifiedAt = modifiedAt,
    )

fun User.toEntity(): UserEntity =
    UserEntity(
        nickname = nickname,
        method = method,
        ci = ci,
        image = image,
        role = role,
    )

fun User.toVO(): UserVO.User =
    UserVO.User(
        id = id,
        nickname = nickname,
        ci = ci,
        image = image,
        method = method,
        registeredAt = registeredAt,
        role = role,
    )

fun UserVO.Save.toDomain(
    ci: String,
    method: String,
): User =
    User(
        ci = ci,
        nickname = nickname,
        image = image,
        method = method,
        role = role,
    )