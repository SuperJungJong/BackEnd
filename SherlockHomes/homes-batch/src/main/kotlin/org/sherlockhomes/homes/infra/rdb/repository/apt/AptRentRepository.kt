package org.sherlockhomes.homes.infra.rdb.repository.apt

import org.sherlockhomes.homes.infra.rdb.entity.apt.AptRentEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AptRentRepository : JpaRepository<AptRentEntity, Long>