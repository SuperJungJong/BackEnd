package org.sherlockhomes.homes.infra.rdb.repository.mono

import org.sherlockhomes.homes.infra.rdb.entity.mono.MonoTradeEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MonoTradeRepository : JpaRepository<MonoTradeEntity, Long>