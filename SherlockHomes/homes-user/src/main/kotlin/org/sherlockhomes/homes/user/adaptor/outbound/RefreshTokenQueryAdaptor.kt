package org.sherlockhomes.homes.user.adaptor.outbound

import org.sherlockhomes.homes.infra.rdb.repository.RefreshTokenRepository
import org.sherlockhomes.homes.user.application.port.outbound.RefreshTokenQueryPort
import org.sherlockhomes.homes.user.domain.RefreshToken
import org.sherlockhomes.homes.user.domain.mapper.toDomain
import org.springframework.stereotype.Component

@Component
class RefreshTokenQueryAdaptor(
    private val refreshTokenRepository: RefreshTokenRepository
) : RefreshTokenQueryPort {

    override fun findByUserId(userId: Long): RefreshToken =
        refreshTokenRepository.findByUserId(userId).toDomain()
}