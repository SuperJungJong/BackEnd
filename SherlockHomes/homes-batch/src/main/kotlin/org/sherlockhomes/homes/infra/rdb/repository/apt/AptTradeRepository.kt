package org.sherlockhomes.homes.infra.rdb.repository.apt

import org.sherlockhomes.homes.infra.rdb.entity.apt.AptTradeEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AptTradeRepository : JpaRepository<AptTradeEntity, Long>