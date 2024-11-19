package org.sherlockhomes.homes.user.application.service.user.VO

class SocialLoginVO {
    data class Token(
        val accessToken: String,
        val refreshToken: String,
    )
}