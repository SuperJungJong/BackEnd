package org.sherlockhomes.homes.user.application.port.inbound

import org.sherlockhomes.homes.user.application.service.user.VO.SocialLoginVO

interface SocialLoginUseCase<C, U> {

    fun signup(credential: C, userInfo: U): SocialLoginVO.Token

    fun login(credential: C): SocialLoginVO.Token
}