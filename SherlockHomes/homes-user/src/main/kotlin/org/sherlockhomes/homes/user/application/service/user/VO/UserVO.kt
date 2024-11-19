package org.sherlockhomes.homes.user.application.service.user.VO

import java.time.LocalDateTime

class UserVO {
    data class User(
        val id: Long? = null,
        val nickname: String,
        val method: String,
        val ci: String,
        val image: ByteArray? = null,
        val role: Int? = 0,
        val registeredAt: LocalDateTime?,
        val modifiedAt: LocalDateTime? = null,
    )

    data class Save(
        val nickname: String,
        val image: ByteArray? = null,
        val role: Int? = 0,
    )
}

