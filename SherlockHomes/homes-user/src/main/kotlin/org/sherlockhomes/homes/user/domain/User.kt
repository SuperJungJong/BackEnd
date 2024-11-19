package org.sherlockhomes.homes.user.domain

import java.time.LocalDateTime

class User(
    val id: Long? = null,
    val nickname: String,
    var method: String,
    var ci: String,
    val image: ByteArray? = null,
    val role: Int? = 0,
    val registeredAt: LocalDateTime? = null,
    val modifiedAt: LocalDateTime? = null,
)