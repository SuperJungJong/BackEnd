package org.sherlockhomes.homes.user.adaptor.inbound.api.dto

class NaverSocialLoginRequestDTO : SocialLoginRequestDTO() {

    data class NaverOauthCredential(
        val code: String,
        val state: String,
    )

    data class Signup(
        val naverCredential: NaverOauthCredential,
        val user: User,
    )
}