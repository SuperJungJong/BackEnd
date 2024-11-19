package org.sherlockhomes.homes.user.domain.mapper

import org.sherlockhomes.homes.user.application.service.user.VO.NaverLoginVO
import org.sherlockhomes.homes.user.domain.NaverOauthCredential

fun NaverLoginVO.NaverOauthCredential.toDomain(): NaverOauthCredential =
    NaverOauthCredential(
        code = code,
        state = state,
    )