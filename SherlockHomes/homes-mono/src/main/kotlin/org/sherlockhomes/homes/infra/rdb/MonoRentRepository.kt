package org.sherlockhomes.homes.infra.rdb

import org.sherlockhomes.homes.infra.rdb.entity.MonoRentEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MonoRentRepository : JpaRepository<MonoRentEntity, Long> {
    fun findAllBySiAndGuAndDong(
        si: String,
        gu: String,
        dong: String,
    ): List<MonoRentEntity>
}