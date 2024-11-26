package org.sherlockhomes.homes.infra.rdb.repository

import org.sherlockhomes.homes.infra.rdb.entity.AptTradeEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.jpa.repository.JpaRepository

interface AptTradeRepository : JpaRepository<AptTradeEntity, Long> {

    fun findAllBySiAndGuAndDong(
        si: String,
        gu: String,
        dong: String,
    ): List<AptTradeEntity>

    fun findAllByAptNmAndSggOrderByDealYDescDealMDescDealDDesc(
        aptNm: String,
        sgg: String,
        pageRequest: PageRequest
    ): Page<AptTradeEntity>
}