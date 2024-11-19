package org.sherlockhomes.homes.user.adaptor.inbound.api.mapper

import org.sherlockhomes.homes.user.adaptor.inbound.api.dto.NaverSocialLoginRequestDTO
import org.sherlockhomes.homes.user.adaptor.inbound.api.dto.SocialLoginResponseDTO
import org.sherlockhomes.homes.user.application.service.user.VO.NaverLoginVO
import org.sherlockhomes.homes.user.application.service.user.VO.SocialLoginVO

fun NaverSocialLoginRequestDTO.NaverOauthCredential.toVO(): NaverLoginVO.NaverOauthCredential =
    NaverLoginVO.NaverOauthCredential(
        code = code,
        state = state,
    )

fun SocialLoginVO.Token.toResponse(): SocialLoginResponseDTO.Response =
    SocialLoginResponseDTO.Response(
        accessToken = accessToken,
        refreshToken = refreshToken,
    )