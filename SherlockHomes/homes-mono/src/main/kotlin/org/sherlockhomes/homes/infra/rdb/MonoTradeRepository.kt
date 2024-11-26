package org.sherlockhomes.homes.infra.rdb

import org.sherlockhomes.homes.infra.rdb.entity.MonoTradeEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MonoTradeRepository : JpaRepository<MonoTradeEntity, Long> {
    fun findAllBySiAndGuAndDong(
        si: String,
        gu: String,
        dong: String,
    ): List<MonoTradeEntity>
}