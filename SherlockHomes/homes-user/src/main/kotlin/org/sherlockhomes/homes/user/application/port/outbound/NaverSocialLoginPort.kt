package org.sherlockhomes.homes.user.application.port.outbound

import org.sherlockhomes.homes.user.domain.NaverOauthCredential

interface NaverSocialLoginPort {

    fun getCi(
        credential: NaverOauthCredential,
    ): String
}