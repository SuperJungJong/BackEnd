package org.sherlockhomes.homes.infra.rdb.repository

import org.sherlockhomes.homes.infra.rdb.entity.GuCountEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GuCountRepository : JpaRepository<GuCountEntity, Long> {
    fun findAllBySiName(si: String): List<GuCountEntity>
}