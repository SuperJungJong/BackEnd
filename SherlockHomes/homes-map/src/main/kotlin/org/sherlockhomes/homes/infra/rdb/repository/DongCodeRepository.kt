package org.sherlockhomes.homes.infra.rdb.repository

import org.sherlockhomes.homes.infra.rdb.entity.DongCodeEntity
import org.springframework.data.jpa.repository.JpaRepository

interface DongCodeRepository : JpaRepository<DongCodeEntity, String> {
    fun findAllByGugunNameAndDongNameNotNull(gugun: String): List<DongCodeEntity>
}