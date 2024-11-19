package org.sherlockhomes.homes.infra.rdb.repository

import org.sherlockhomes.homes.infra.rdb.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserEntity, Long> {
    fun findByCi(ci: String): UserEntity
}