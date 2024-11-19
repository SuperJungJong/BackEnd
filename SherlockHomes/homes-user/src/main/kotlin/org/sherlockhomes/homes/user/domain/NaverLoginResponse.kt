package org.sherlockhomes.homes.user.domain

class NaverLoginResponse {
    data class tokens(
        val access_token: String,
        val refresh_token: String,
        val token_type: String,
        val expires_in: String,
    )

    data class UserInfo(
        val resultcode: String,
        val message: String,
        val response: InfoResponse
    )

    data class InfoResponse(
        val id: String,
        val profile_image: String,
        val name: String,
    )
}