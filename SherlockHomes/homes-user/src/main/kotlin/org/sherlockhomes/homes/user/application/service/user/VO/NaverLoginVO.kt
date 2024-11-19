package org.sherlockhomes.homes.user.application.service.user.VO

class NaverLoginVO {

    data class NaverOauthCredential(
        val code: String,
        val state: String,
    )

    data class Sinup(
        val naverCredential: NaverOauthCredential,
        val user: UserVO.Save,
    )
}