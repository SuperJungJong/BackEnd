package org.sherlockhomes.homes.user.adaptor.inbound.api.dto

class SocialLoginResponseDTO {

    data class Response(
        val accessToken: String,
        val refreshToken: String,
    )
}