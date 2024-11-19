package org.sherlockhomes.homes.user.adaptor.inbound.api.dto

import java.time.LocalDateTime

class UserResponseDTO {
    data class Response(
        val userId: Long,
        val nickname: String,
        val image: ByteArray?,
        val role: Int? = 0,
        val registeredAt: LocalDateTime,
    )
}