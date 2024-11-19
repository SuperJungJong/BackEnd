package org.sherlockhomes.homes.user.adaptor.inbound.api.mapper

import org.sherlockhomes.homes.user.adaptor.inbound.api.dto.SocialLoginRequestDTO
import org.sherlockhomes.homes.user.application.service.user.VO.UserVO

fun SocialLoginRequestDTO.User.toVO(
): UserVO.Save =
    UserVO.Save(
        nickname = nickname,
        image = image,
        role = role,
    )
