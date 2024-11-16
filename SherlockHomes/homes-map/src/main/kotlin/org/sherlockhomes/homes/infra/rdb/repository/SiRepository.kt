package org.sherlockhomes.homes.infra.rdb.repository

import org.sherlockhomes.homes.infra.rdb.entity.SiEntity
import org.springframework.data.jpa.repository.JpaRepository

interface SiRepository : JpaRepository<SiEntity, Long>
