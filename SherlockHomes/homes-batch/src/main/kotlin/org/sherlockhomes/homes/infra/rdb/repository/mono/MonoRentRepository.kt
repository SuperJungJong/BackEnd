package org.sherlockhomes.homes.infra.rdb.repository.mono

import org.sherlockhomes.homes.infra.rdb.entity.mono.MonoRentEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MonoRentRepository : JpaRepository<MonoRentEntity, Long>