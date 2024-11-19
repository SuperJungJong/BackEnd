package org.sherlockhomes.homes.user.adaptor.inbound.api.mapper

import org.sherlockhomes.homes.user.adaptor.inbound.api.dto.UserResponseDTO
import org.sherlockhomes.homes.user.application.service.user.VO.UserVO

fun UserVO.User.toResponse(): UserResponseDTO.Response =
    UserResponseDTO.Response(
        userId = id!!,
        nickname = nickname,
        image = image,
        role = role,
        registeredAt = registeredAt!!,
    )

