package org.sherlockhomes.homes.infra.rdb.repository

import org.sherlockhomes.homes.infra.rdb.entity.GuEntity
import org.springframework.data.jpa.repository.JpaRepository

interface GuRepository : JpaRepository<GuEntity, Int> {
    fun findAllByCodeStartsWith(code: String): List<GuEntity>
}