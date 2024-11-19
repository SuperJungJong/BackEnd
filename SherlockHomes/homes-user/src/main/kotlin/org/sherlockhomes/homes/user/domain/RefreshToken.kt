package org.sherlockhomes.homes.user.domain

import java.time.LocalDateTime

class RefreshToken(
    val id: Long? = null,
    val userId: Long,
    val ci: String,
    val refreshToken: String,
    val createAt: LocalDateTime? = null,
    val modifiedAt: LocalDateTime? = null,
)