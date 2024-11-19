package org.sherlockhomes.homes.user.application.port.outbound

import org.sherlockhomes.homes.user.domain.RefreshToken

interface RefreshTokenCommandPort {
    fun saveRefreshToken(refreshToken: RefreshToken): Long
    fun updateRefreshToken(userId: Long, refreshToken: String): Long
}