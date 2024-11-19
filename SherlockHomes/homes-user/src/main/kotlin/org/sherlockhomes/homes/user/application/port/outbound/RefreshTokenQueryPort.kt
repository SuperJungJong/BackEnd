package org.sherlockhomes.homes.user.application.port.outbound

import org.sherlockhomes.homes.user.domain.RefreshToken

interface RefreshTokenQueryPort {

    fun findByUserId(userId: Long): RefreshToken
}