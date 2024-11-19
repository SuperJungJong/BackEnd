package org.sherlockhomes.homes.user.adaptor.outbound

import org.sherlockhomes.homes.infra.rdb.repository.RefreshTokenRepository
import org.sherlockhomes.homes.user.application.port.outbound.RefreshTokenCommandPort
import org.sherlockhomes.homes.user.domain.RefreshToken
import org.sherlockhomes.homes.user.domain.mapper.toEntity
import org.springframework.stereotype.Component

@Component
class RefreshTokenCommandAdaptor(
    private val refreshTokenRepository: RefreshTokenRepository
) : RefreshTokenCommandPort {

    override fun saveRefreshToken(refreshToken: RefreshToken): Long =
        refreshTokenRepository.save(refreshToken.toEntity()).id!!

    override fun updateRefreshToken(userId: Long, refreshToken: String): Long {
        val refreshTokenEntity = refreshTokenRepository.findByUserId(userId)

        refreshTokenEntity.update(userId, refreshToken)

        return refreshTokenEntity.id!!
    }

}