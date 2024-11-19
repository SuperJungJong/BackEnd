package org.sherlockhomes.homes.user.application.port.outbound

import org.sherlockhomes.homes.user.domain.User

interface UserCommandPort {

    fun save(user: User): Long
}