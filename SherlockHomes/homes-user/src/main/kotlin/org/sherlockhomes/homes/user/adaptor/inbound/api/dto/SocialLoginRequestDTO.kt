package org.sherlockhomes.homes.user.adaptor.inbound.api.dto

abstract class SocialLoginRequestDTO {

    data class User(
        val nickname: String,
        val image: ByteArray,
        val role: Int? = 0,
    )
}