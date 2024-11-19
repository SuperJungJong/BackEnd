package org.sherlockhomes.homes.infra.rdb.repository

import org.sherlockhomes.homes.infra.rdb.entity.RefreshTokenEntity
import org.springframework.data.jpa.repository.JpaRepository

interface RefreshTokenRepository : JpaRepository<RefreshTokenEntity, Long> {

    fun findByCi(ci: String): RefreshTokenEntity

    fun findByUserId(userId: Long): RefreshTokenEntity
}