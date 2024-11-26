package org.sherlockhomes.homes.infra.rdb.repository

import org.sherlockhomes.homes.infra.rdb.entity.AptRentEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AptRentRepository : JpaRepository<AptRentEntity, Long> {
    fun findAllBySiAndGuAndDong(si: String, gu: String, dong: String): List<AptRentEntity>

    fun findAllBySiAndGuAndDongAndAptNm(si: String, gu: String, dong: String, name: String): List<AptRentEntity>
}