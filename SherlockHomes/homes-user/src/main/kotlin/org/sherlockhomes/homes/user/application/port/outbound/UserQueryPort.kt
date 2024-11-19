package org.sherlockhomes.homes.user.application.port.outbound

import org.sherlockhomes.homes.user.domain.User

interface UserQueryPort {

    fun findById(userId: Long): User

    fun findByCi(ci: String): User
}